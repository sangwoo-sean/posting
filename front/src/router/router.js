import { createRouter, createWebHistory } from "vue-router";

import Error from "@/components/Error";
import Home from "@/components/Home.vue";
import Login from "@/components/Login.vue";
import Signup from "@/components/Signup.vue";

const routes = [
    { path: "/", component: Home },
    { path: "/login", component: Login },
    { path: "/signup", component: Signup },
    { path: "/error", component: Error }
];

export default createRouter({
    history: createWebHistory(),
    routes
});
