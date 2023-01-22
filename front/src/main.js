import { createPinia } from "pinia";
import { createApp } from "vue";
import App from "./App.vue";
import router from "./router/router";
import common from "@/common/common";
import AxiosInterceptor from "@/interceptor/AxiosInterceptor";
import piniaPluginPersistedstate from "pinia-plugin-persistedstate";

import "@/assets/css/index.css";
import "@/assets/css/header.css";
import "@/assets/css/main.css";
import "@/assets/css/footer.css";
import "@/assets/css/elements.css";

const pinia = createPinia();
pinia.use(piniaPluginPersistedstate);

createApp(App).use(common).use(pinia).use(AxiosInterceptor).use(router).mount("#app");
