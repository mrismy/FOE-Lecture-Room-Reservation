package com.rismy.FoE_RoomReservation.security;

import java.io.IOException;
import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseCookie;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.rismy.FoE_RoomReservation.model.User;
import com.rismy.FoE_RoomReservation.model.User.AuthProvider;
import com.rismy.FoE_RoomReservation.model.User.UserType;
import com.rismy.FoE_RoomReservation.repository.UserRepository;
import com.rismy.FoE_RoomReservation.service.impl.JwtTokenProvider;
import com.rismy.FoE_RoomReservation.utils.Utils;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	@Value("${frontend.url}")
	private String frontEndUrl;

	private final UserRepository userRepository;
	private final JwtTokenProvider jwtTokenProvider;

	@Autowired
	CustomAuthenticationSuccessHandler(UserRepository userRepository, JwtTokenProvider jwtTokenProvider) {
		this.userRepository = userRepository;
		this.jwtTokenProvider = jwtTokenProvider;
	}

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();
		String email = oAuth2User.getAttribute("email");
		String givenName = oAuth2User.getAttribute("given_name");
		String familyName = oAuth2User.getAttribute("family_name");

		User user;
		if (userRepository.existsByEmail(email)) {
			user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));
		} else {
			// Auto-provision a new user for Google login (no manual registration endpoint needed)
			user = new User();
			user.setEmail(email);
			user.setFirstName(givenName != null ? givenName : "");
			user.setLastName(familyName != null ? familyName : "");
			user.setUserType(UserType.regularUser);
			user.setAuthProvider(AuthProvider.GOOGLE);
			user = userRepository.save(user);
		}

		// Replace OAuth security context with our JWT auth
		SecurityContextHolder.clearContext();

		String accessToken = jwtTokenProvider.generateAccessToken(Utils.mapUserToUserDto(user));
		String refreshToken = jwtTokenProvider.generateRefreshToken(Utils.mapUserToUserDto(user));

		UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
				user.getEmail(), null, user.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authToken);

		ResponseCookie refreshCookie = ResponseCookie.from("refreshToken", refreshToken)
				.httpOnly(true)
				.secure(true)
				.path("/auth/refresh")
				.maxAge(jwtTokenProvider.getRefreshTokenExpiration() / 1000)
				.sameSite("Lax")
				.build();

		response.addHeader(HttpHeaders.SET_COOKIE, refreshCookie.toString());

		String redirectUrl = frontEndUrl + "/oauth-success?token=" + URLEncoder.encode(accessToken, "UTF-8");
		response.sendRedirect(redirectUrl);
	}
}
