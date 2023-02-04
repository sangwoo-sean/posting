import { createRouter, createWebHistory } from "vue-router";

import Error from "@/components/Error";
import Home from "@/components/Home.vue";
import Login from "@/components/Login.vue";
import Signup from "@/components/Signup.vue";
import Elements from "@/components/layout/Elements.vue";
import MyPage from "@/components/MyPage.vue";
import WriteArticle from "@/components/WriteArticle.vue";
import ReadArticle from "@/components/layout/ReadArticle.vue";

import { useUserStore } from "@/stores/userStore";

const authLogin = (to, from, next) => {
    if (!useUserStore().userId) {
        next({ path: "/login", query: { redirect: to.fullPath } });
    }
    return next();
};

const routes = [
    { path: "/", component: Home },
    { path: "/login", component: Login },
    { path: "/signup", component: Signup },
    {
        path: "/mypage",
        component: MyPage,
        beforeEnter: authLogin
    },
    { path: "/write", component: WriteArticle, beforeEnter: authLogin },
    { path: "/article/:articleId", component: ReadArticle },
    { path: "/error", component: Error },
    { path: "/elements", component: Elements },
    { path: "/:pathMatch(.*)*", component: Error }
];

export default createRouter({
    history: createWebHistory(),
    routes
});
