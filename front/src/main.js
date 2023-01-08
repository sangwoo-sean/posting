import { createPinia } from "pinia";
import { createApp } from "vue";
import App from "./App.vue";
import router from "./router/router";
import AxiosInterceptor from "@/interceptor/AxiosInterceptor";

createApp(App).use(createPinia()).use(AxiosInterceptor).use(router).mount("#app");
