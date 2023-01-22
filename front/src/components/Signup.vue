<template>
    <div class="d-flex-center flex-col w20 m-auto">
        <h2>회원가입</h2>
        <div class="input-group">
            <label>닉네임</label>
            <input type="text" v-model="user.name" maxlength="10" />
            <span v-if="!user.name" class="error">닉네임을 입력해주세요</span>
            <span v-else-if="isInvalid('name')" class="error">2~10자로 입력해주세요</span>
        </div>
        <div class="input-group">
            <label>이메일</label>
            <input type="email" v-model="user.email" maxlength="100" />
            <span v-if="!user.email" class="error">이메일을 입력해주세요</span>
            <span v-else-if="isInvalid('email')" class="error">이메일 형식이 올바르지 않습니다</span>
        </div>
        <div class="input-group">
            <label>비밀번호</label>
            <input type="password" v-model="user.password" maxlength="20" />
            <span v-if="!user.password" class="error">비밀번호를 입력해주세요</span>
            <span v-else-if="isInvalid('password')" class="error"
                >8~20자의 영문자+숫자+특수문자를 조합한 형태로 입력해주세요</span
            >
        </div>
        <div class="input-group">
            <label>비밀번호 확인</label>
            <input type="password" v-model="user.passwordCheck" maxlength="20" />
            <span v-if="!user.passwordCheck" class="error">비밀번호 확인을 입력해주세요</span>
            <span v-if="isInvalid('passwordCheck')" class="error">비밀번호 확인이 일치하지 않습니다</span>
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
            }
        };
    },
    methods: {
        registerUser() {
            if (!this.validation()) return;

            axios
                .post(process.env.VUE_APP_API_URL + "/signup", this.user)
                .then((res) => {
                    alert("회원가입 되었습니다. 가입하신 계정으로 로그인 해주세요.");
                    this.$router.push("/login");
                })
                .catch((e) => {
                    alert(e.response.data.defaultMessage);
                });
        },
        validation() {
            if (this.isInvalid("name")) return false;
            if (this.isInvalid("email")) return false;
            if (this.isInvalid("password")) return false;
            if (this.isInvalid("passwordCheck")) return false;
            return true;
        },
        isInvalid(type) {
            if (!type) return true;

            if (type === "name") {
                const value = this.user.name;
                if (value.length <= 2 || 20 <= value.length) return true;
            }
            if (type === "email") {
                const value = this.user.email;
                const emailRegex = /^[A-Z\d._%+-]+@[A-Z\d.-]+\.[A-Z]{2,4}$/i;
                if (!emailRegex.test(value)) return true;
            }
            if (type === "password") {
                const value = this.user.password;
                const passwordRegex =
                    /^(?=.*[A-Z])(?=.*\d)(?=.*[!@#$%^&*()_+\-=,./<>?;':"\[\]{}])[A-Z\d!@#$%^&*()_+\-=,./<>?;':"\[\]{}]{8,20}/i;
                if (!passwordRegex.test(value)) return true;
            }
            if (type === "passwordCheck") {
                const value = this.user.passwordCheck;
                if (value !== this.user.password) return true;
            }
            return false;
        }
    }
};
</script>

<style scoped></style>
