<template>
    <div class="hello">
        <h1>{{ msg }}</h1>
        <div>
            <label>메일</label>
            <input type="email" v-model="user.email" />
        </div>
        <div>
            <label>비밀번호</label>
            <input type="password" v-model="user.password" />
        </div>
        <button @click="registerUser">회원가입</button>
        <button @click="login">로그인</button>
        <div>{{ userStore.email }}</div>
        <div>{{ userStore.token }}</div>
        <button @click="requestSomething">USER 전용 API 호출</button>
    </div>
</template>

<script>
import axios from "axios";
import { useUserStore } from "@/stores/userStore";

export default {
    name: "HelloWorld",
    props: {
        msg: String,
    },
    setup() {
        const userStore = useUserStore();
        return { userStore };
    },
    data() {
        return {
            user: {
                email: "",
                password: "",
            },
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
                })
                .catch((e) => {
                    alert(e.response.data.defaultMessage);
                });
        },
        login() {
            axios
                .post(process.env.VUE_APP_API_URL + "/login", this.user)
                .then((res) => {
                    alert("로그인 성공!");
                    const token = res.data;
                    this.userStore.login({ token, email: this.user.email });

                    this.user.email = "";
                    this.user.password = "";
                })
                .catch((e) => {
                    console.error(e);
                    alert(e.response.data.defaultMessage ?? e.response.data);
                });
        },
        requestSomething() {
            axios
                .get(process.env.VUE_APP_API_URL + "/user?email=" + this.userStore.email)
                .then((res) => {
                    console.log(res);
                    alert(res.data);
                })
                .catch(console.error);
        },
    },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
    margin: 40px 0 0;
}
ul {
    list-style-type: none;
    padding: 0;
}
li {
    display: inline-block;
    margin: 0 10px;
}
a {
    color: #42b983;
}
</style>
