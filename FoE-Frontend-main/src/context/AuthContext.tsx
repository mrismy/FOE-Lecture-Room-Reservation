// src/context/AuthContext.js
import { createContext, useContext, useState, useEffect, ReactNode } from 'react';
import api from '../utils/api';
import { logout as apiLogout } from '../services/AuthService';

interface User {
    userId: number;
    firstName: string;
    lastName: string;
    email: string;
    userType: string;
}

interface AuthState {
    isAuthenticated: boolean;
    user: User | null;
    isLoading: boolean;
}

interface AuthContextType extends AuthState {
    logout: () => Promise<void>;
    reload: () => Promise<void>;
}

const AuthContext = createContext<AuthContextType | undefined>(undefined);

export const AuthProvider = ({ children } : { children: ReactNode }) => {
    const [authState, setAuthState] = useState({
        isAuthenticated: false,
        user: null,
        isLoading: true
    });

    const reload = async () => {
        try {
            const { data } = await api.get('/auth/me');
            setAuthState({
                isAuthenticated: true,
                user: data.user,
                isLoading: false
            });
        } catch {
            setAuthState({
                isAuthenticated: false,
                user: null,
                isLoading: false
            });
        }
    };

    // Initialize auth state on app load
    useEffect(() => {
        reload();
    }, []);

    const logout = async () => {
        await apiLogout();
        setAuthState({ isAuthenticated: false, user: null, isLoading: false });
    };

    return (
        <AuthContext.Provider value={{ ...authState, logout, reload }}>
            {children}
        </AuthContext.Provider>
    );
};

export const useAuth = () => useContext(AuthContext);