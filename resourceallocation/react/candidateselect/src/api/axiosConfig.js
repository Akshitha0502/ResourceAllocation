// src/api/axiosConfig.js
import axios from "axios";

const axiosInstance = axios.create({
  baseURL: "http://localhost:8080/api", // Ensure this matches your Spring Boot API base URL
  headers: {
    "Content-Type": "application/json",
  },
});

export default axiosInstance;
