<template>
    <div class="d-flex-center flex-col">
        <h2>로그인</h2>
        <div>
            <label>메일</label>
            <input type="email" v-model="user.email" />
        </div>
        <div>
            <label>비밀번호</label>
            <input type="password" v-model="user.password" />
        </div>
        <div>
            <button class="btn" @click="registerUser">회원가입</button>
            <button class="btn" @click="login">로그인</button>
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
        registerUser() {
            axios
                .post(process.env.VUE_APP_API_URL + "/user", this.user)
                .then((res) => {
                    alert("회원가입 되었습니다. 가입하신 계정으로 로그인 해주세요.");
                    this.user.email = "";
                    this.user.password = "";
                    this.$router.push("/login");
                })
                .catch((e) => {
                    alert(e.response.data.defaultMessage);
                });
        },
        login() {
            axios
                .post(process.env.VUE_APP_API_URL + "/login", this.user)
                .then((res) => {
                    const token = res.data;
                    this.userStore.login({ token, email: this.user.email });

                    this.user.email = "";
                    this.user.password = "";
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
