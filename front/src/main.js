import { createPinia } from "pinia";
import { createApp } from "vue";
import App from "./App.vue";
import router from "./router/router";
import common from "@/common/common";
import AxiosInterceptor from "@/interceptor/AxiosInterceptor";
import piniaPluginPersistedstate from "pinia-plugin-persistedstate";

const pinia = createPinia();
pinia.use(piniaPluginPersistedstate);

createApp(App).use(common).use(pinia).use(AxiosInterceptor).use(router).mount("#app");
