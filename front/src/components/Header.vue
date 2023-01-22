<template>
    <header>
        <div class="header-logo">
            <router-link to="/">
                <img src="https://via.placeholder.com/200x50" alt="logo" />
            </router-link>
        </div>

        <nav>
            <ul>
                <li><a href="javascript:void(0)">menu1</a></li>
                <li><a href="javascript:void(0)">menu2</a></li>
                <li><a href="javascript:void(0)">menu3</a></li>
            </ul>
        </nav>

        <div class="login-wrapper">
            <div v-if="!userStore.token">
                <router-link to="/login" class="btn">로그인</router-link>
            </div>
            <div v-else class="d-flex justify-right align-items-center">
                <div>
                    <a href="javascript:void(0)">{{ userStore.email }}</a>
                </div>
                <button @click="logout">로그아웃</button>
            </div>
        </div>
    </header>
</template>

<script>
import { useUserStore } from "@/stores/userStore";
import axios from "axios";

export default {
    name: "Header",
    setup() {
        const userStore = useUserStore();
        return { userStore };
    },
    methods: {
        logout() {
            axios
                .post(process.env.VUE_APP_API_URL + "/logout")
                .then((res) => {
                    // this.userStore.logout();
                })
                .catch(console.error)
                .finally(() => {
                    this.userStore.logout();
                    this.router.push("/");
                });
        }
    }
};
</script>

<style scoped></style>
