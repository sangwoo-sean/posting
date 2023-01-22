<template>
    <header>
        <div class="header-logo">
            <router-link to="/">
                <img src="https://via.placeholder.com/200x50" alt="logo" />
            </router-link>
        </div>

        <nav>
            <ul>
                <li><a href="javascript:void(0)">Articles</a></li>
                <li><a href="javascript:void(0)">Event</a></li>
                <li><a href="javascript:void(0)">Notice</a></li>
            </ul>
        </nav>

        <div class="login-wrapper">
            <div v-if="!userStore.token">
                <router-link to="/login" class="btn">로그인</router-link>
            </div>
            <div v-else class="d-flex justify-right align-items-center" style="gap: 2rem">
                <div>
                    <router-link to="/mypage">{{ userStore.name }}</router-link>
                </div>
                <a href="javascript:void(0)" id="alarm" class="on">
                    <img src="@/assets/svg/bell.svg" alt="bell" width="20" />
                </a>
                <router-link to="/write">
                    <img src="@/assets/svg/pencil-square.svg" alt="write" width="20" />
                </router-link>
                <button class="btn" @click="logout">로그아웃</button>
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
            if (!confirm("로그아웃 하시겠습니까?")) return;

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
