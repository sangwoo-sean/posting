import axios from "axios";
import { useUserStore } from "@/stores/userStore";

function hasInvalidToken(error) {
    return error.response && error.response.status === 401;
}
function serverNetworkError(error) {
    return error.code === "ERR_NETWORK";
}

export default function AxiosInterceptor() {
    axios.defaults.withCredentials = true;

    axios.interceptors.request.use(
        (config) => {
            config.headers.Authorization = useUserStore().token;
            return config;
        },
        (error) => {
            return Promise.reject(error);
        }
    );
    axios.interceptors.response.use(
        (response) => {
            return response;
        },
        (error) => {
            if (hasInvalidToken(error)) {
                alert("토큰이 없거나 만료되었습니다.");
                window.location.href = "/";
            }
            if (serverNetworkError(error)) {
                alert("서버와 통신할 수 없습니다.");
            }
            return Promise.reject(error);
        }
    );
}
