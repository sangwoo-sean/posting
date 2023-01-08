import { createPinia } from "pinia";
import { createApp } from "vue";
import App from "./App.vue";
import router from "./router/router";
import common from "@/common/common";
import AxiosInterceptor from "@/interceptor/AxiosInterceptor";

createApp(App).use(common).use(createPinia()).use(AxiosInterceptor).use(router).mount("#app");
