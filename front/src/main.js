import { createPinia } from "pinia";
import { createApp } from "vue";
import App from "./App.vue";
import AxiosInterceptor from "@/interceptor/AxiosInterceptor";

createApp(App).use(createPinia()).use(AxiosInterceptor).mount("#app");
