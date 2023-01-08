import axios from "axios";
import { useUserStore } from "@/stores/userStore";

export default function AxiosInterceptor() {
    axios.interceptors.request.use(
        (config) => {
            console.log("request interceptor");
            console.log(useUserStore().token);
            config.headers.Authorization = useUserStore().token;
            return config;
        },
        (error) => {
            return Promise.reject(error);
        }
    );
    axios.interceptors.response.use(
        (response) => {
            console.log("response interceptor");
            return response;
        },
        (error) => {
            return Promise.reject(error);
        }
    );
}
