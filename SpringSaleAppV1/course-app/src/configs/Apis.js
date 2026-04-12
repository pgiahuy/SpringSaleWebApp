import axios from "axios";

const API = axios.create({
    baseURL: "http://localhost:8080/SpringSaleAppV1/api",
});

export const getProducts = () => API.get("/products");
export const getCategories = () => API.get("/categories");

export default API;