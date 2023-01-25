<template>
    <div class="d-flex-center flex-col w20 m-auto">
        <h2>로그인</h2>
        <div class="input-group">
            <label>이메일</label>
            <input type="email" v-model="user.email" />
        </div>
        <div class="input-group">
            <label>비밀번호</label>
            <input type="password" v-model="user.password" @keyup.enter="login" />
        </div>
        <div class="btn-wrapper">
            <router-link to="/signup" class="btn">회원가입</router-link>
            <button class="btn btn-dark" @click="login">로그인</button>
        </div>
    </div>
</template>

<script>
import axios from "axios";
import { useUserStore } from "@/stores/userStore";

export default {
    name: "Login",
    setup() {
        const userStore = useUserStore();
        return { userStore };
    },
    data() {
        return {
            user: {
                email: "",
                password: ""
            }
        };
    },
    methods: {
        login() {
            axios
                .post(process.env.VUE_APP_API_URL + "/login", this.user)
                .then((res) => {
                    const { token, userId, name } = res.data;
                    this.userStore.login({ token, userId, name, email: this.user.email });
                    this.$router.push("/");
                })
                .catch((e) => {
                    console.error(e);
                    alert(e.response.data.defaultMessage ?? e.response.data);
                });
        }
    }
};
</script>

<style scoped></style>
