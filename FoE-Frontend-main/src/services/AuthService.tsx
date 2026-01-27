import api from '../utils/api';

export interface LoginPayload {
  email: string;
  password: string;
}

export interface RegisterPayload {
  firstName: string;
  lastName?: string;
  email: string;
  password: string;
}

export const login = async (payload: LoginPayload) => {
  const { data } = await api.post('/auth/login', payload, { withCredentials: true });
  if (data?.token) {
    localStorage.setItem('accessToken', data.token);
  }
  return data;
};

export const register = async (payload: RegisterPayload) => {
  const { data } = await api.post('/auth/register', payload, { withCredentials: true });
  if (data?.token) {
    localStorage.setItem('accessToken', data.token);
  }
  return data;
};

export const refreshToken = async () => {
  const response = await api.get('/auth/refresh', { withCredentials: true });
  return response.data.token;
};

export const logout = async () => {
  try {
    await api.post('/auth/logout', {}, { withCredentials: true });
  } finally {
    localStorage.removeItem('accessToken');
  }
};

export const startOAuth2Flow = () => {
  window.location.href = 'http://localhost:8082/oauth2/authorization/google';
};
