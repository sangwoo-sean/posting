import { createRouter, createWebHistory } from "vue-router";

import Error from "@/components/Error";
import Home from "@/components/Home.vue";
import Login from "@/components/Login.vue";
import Signup from "@/components/Signup.vue";
import Elements from "@/components/layout/Elements.vue";
import MyPage from "@/components/MyPage.vue";
import WriteArticle from "@/components/WriteArticle.vue";

const routes = [
    { path: "/", component: Home },
    { path: "/login", component: Login },
    { path: "/signup", component: Signup },
    { path: "/mypage", component: MyPage },
    { path: "/write", component: WriteArticle },
    { path: "/error", component: Error },
    { path: "/elements", component: Elements }
];

export default createRouter({
    history: createWebHistory(),
    routes
});
