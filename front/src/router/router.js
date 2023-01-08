import { createRouter, createWebHistory } from "vue-router";

import HelloWorld from "@/components/HelloWorld";
import Error from "@/components/Error";

const routes = [
    { path: "/", component: HelloWorld },
    { path: "/error", component: Error },
];

export default createRouter({
    history: createWebHistory(),
    routes,
});
