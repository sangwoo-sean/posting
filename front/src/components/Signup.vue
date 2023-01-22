<template>
    <div class="d-flex-center flex-col w50 m-auto">
        <h2>회원가입</h2>
        <div class="input-group">
            <label>닉네임</label>
            <input type="text" v-model="user.name" />
            <span v-if="submitted && !user.name" class="error">닉네임을 입력해주세요</span>
        </div>
        <div class="input-group">
            <label>이메일</label>
            <input type="email" v-model="user.email" />
            <span v-if="submitted && !user.email" class="error">이메일을 입력해주세요</span>
        </div>
        <div class="input-group">
            <label>비밀번호</label>
            <input type="password" v-model="user.password" />
            <span v-if="submitted && !user.password" class="error">비밀번호를 입력해주세요</span>
        </div>
        <div class="input-group">
            <label>비밀번호 확인</label>
            <input type="password" v-model="user.passwordCheck" />
            <span v-if="submitted && !user.passwordCheck" class="error">비밀번호 확인을 입력해주세요</span>
            <span v-if="submitted && user.password !== user.passwordCheck" class="error"
                >비밀번호 확인이 일치하지 않습니다</span
            >
        </div>
        <div class="btn-wrapper">
            <button class="btn btn-dark" @click="registerUser">회원가입</button>
        </div>
    </div>
</template>

<script>
import axios from "axios";
import { useUserStore } from "@/stores/userStore";

export default {
    name: "Signup",
    setup() {
        const userStore = useUserStore();
        return { userStore };
    },
    data() {
        return {
            user: {
                name: "",
                email: "",
                password: "",
                passwordCheck: ""
            },
            submitted: false
        };
    },
    methods: {
        registerUser() {
            this.submitted = true;

            if (!this.validation()) return;

            axios
                .post(process.env.VUE_APP_API_URL + "/user", this.user)
                .then((res) => {
                    alert("회원가입 되었습니다. 가입하신 계정으로 로그인 해주세요.");
                    this.$router.push("/login");
                })
                .catch((e) => {
                    alert(e.response.data.defaultMessage);
                });
        },
        validation() {
            if (!this.user.name) {
                return false;
            }

            if (!this.user.email) {
                return false;
            }

            if (!this.user.password) {
                return false;
            }

            if (!this.user.passwordCheck) {
                return false;
            }

            return true;
        }
    }
};
</script>

<style scoped></style>
