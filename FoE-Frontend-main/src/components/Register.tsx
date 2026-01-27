import { FieldValues, useForm } from 'react-hook-form';
import logo from '../assets/logo.png';
import { AxiosError } from 'axios';
import { useNavigate } from 'react-router-dom';
import HighlightOffIcon from '@mui/icons-material/HighlightOff';
import { useState } from 'react';
import { register as registerUser } from '../services/AuthService';
const Register = () => {
  const navigate = useNavigate();
  const {
    register,
    handleSubmit,
    formState: { errors },
  } = useForm();
  const [errorMessage, setErrorMessage] = useState<string | null>(null);
  const onRegister = async (data: FieldValues) => {
    try {
      await registerUser({
        firstName: data.firstName,
        lastName: data.lastName,
        email: data.email,
        password: data.password,
      });
      navigate('/booking/month');
    } catch (error) {
      if (error instanceof AxiosError) {
        const message = (error.response?.data as any)?.message || error.message;
        setErrorMessage(message);
      } else {
        setErrorMessage('An unexpected error occurred.');
      }
    }
  };
  return (
    <div className="flex h-screen bg-blue-200 px-32 py-20">
      <div className="w-1/2 hidden md:flex flex-col justify-center items-center text-white bg-gradient-to-r from-violet-600 to-blue-500 p-8 mt-14 rounded-l-3xl">
        <img alt="FoE-Room Reservation" src={logo} className="h-16 mb-6" />
        <h1 className="text-4xl font-bold mb-4">Create an account</h1>
        <p className="text-lg leading-relaxed text-center">
          Register with email/password, or use Google login from the menu.
        </p>
      </div>
      <div className="w-full md:w-1/2 flex justify-center items-center bg-gray-100 mt-14 rounded-r-3xl">
        <div className="w-full max-w-md px-8 py-12 shadow-xl rounded-lg bg-white">
          <div className="flex flex-col items-center">
            <img alt="FoE-Room Reservation" src={logo} className="h-12 mb-4 md:hidden" />
            <h2 className="text-center text-3xl font-bold mb-6 text-gray-800">Register</h2>
          </div>
          <form onSubmit={handleSubmit(onRegister)} className="space-y-4">
            <div>
              <label htmlFor="firstName" className="block text-lg font-medium text-gray-700">First name</label>
              <input
                {...register('firstName', { required: true })}
                id="firstName"
                type="text"
                className="block w-full rounded-md border border-gray-300 py-2 px-4 shadow-sm focus:outline-none focus:ring-2 focus:ring-indigo-500"
                onClick={() => setErrorMessage(null)}
              />
              {errors.firstName?.type === 'required' && (
                <p className="text-red-600 mt-2">First name is required</p>
              )}
            </div>
            <div>
              <label htmlFor="lastName" className="block text-lg font-medium text-gray-700">Last name</label>
              <input
                {...register('lastName')}
                id="lastName"
                type="text"
                className="block w-full rounded-md border border-gray-300 py-2 px-4 shadow-sm focus:outline-none focus:ring-2 focus:ring-indigo-500"
                onClick={() => setErrorMessage(null)}
              />
            </div>
            <div>
              <label htmlFor="email" className="block text-lg font-medium text-gray-700">Email</label>
              <input
                {...register('email', { required: true })}
                id="email"
                type="email"
                className="block w-full rounded-md border border-gray-300 py-2 px-4 shadow-sm focus:outline-none focus:ring-2 focus:ring-indigo-500"
                onClick={() => setErrorMessage(null)}
              />
              {errors.email?.type === 'required' && (
                <p className="text-red-600 mt-2">Email is required</p>
              )}
            </div>
            <div>
              <label htmlFor="password" className="block text-lg font-medium text-gray-700">Password</label>
              <input
                {...register('password', { required: true })}
                id="password"
                type="password"
                className="block w-full rounded-md border border-gray-300 py-2 px-4 shadow-sm focus:outline-none focus:ring-2 focus:ring-indigo-500"
                onClick={() => setErrorMessage(null)}
              />
              {errors.password?.type === 'required' && (
                <p className="text-red-600 mt-2">Password is required</p>
              )}
            </div>
            {errorMessage && (
              <div className="p-2 bg-red-600 text-gray-100 hover:bg-red-500 rounded-md flex items-start space-x-3 shadow-sm">
                <div className="flex-shrink-0 text-white" onClick={() => setErrorMessage(null)}>
                  <HighlightOffIcon />
                </div>
                <div className="flex-1">
                  <p className="font-medium text-white">Error</p>
                  <p>{errorMessage}</p>
                </div>
              </div>
            )}
            <div className="space-y-2">
              <button
                type="submit"
                className="w-full bg-indigo-600 text-white py-2 rounded-md shadow-md hover:bg-indigo-500 focus:ring-2 focus:ring-indigo-500">
                Register
              </button>
              <button
                type="button"
                onClick={() => navigate('/auth/login')}
                className="w-full bg-gray-200 text-gray-800 py-2 rounded-md shadow-sm hover:bg-gray-300">
                Back to login
              </button>
            </div>
          </form>
        </div>
      </div>
    </div>
  );
};
export default Register;
