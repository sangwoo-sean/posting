<template>
    <div style="width: 50%; margin: auto">
        <h2>Write Your Own Article</h2>

        <div class="input-group title">
            <input type="text" placeholder="제목을 입력하세요" v-model="title" maxlength="100" />
        </div>
        <div class="input-group content">
            <textarea placeholder="내용을 입력하세요" rows="10" v-model="content" maxlength="4000"></textarea>
        </div>

        <div class="d-flex justify-right">
            <button class="btn btn-dark" @click="registerArticle">출간</button>
        </div>
    </div>
</template>

<script>
import axios from "axios";
import { useUserStore } from "@/stores/userStore";

export default {
    name: "WriteArticle",
    setup() {
        const userStore = useUserStore();
        return { userStore };
    },
    data() {
        return {
            title: "",
            content: ""
        };
    },
    methods: {
        registerArticle() {
            if (!this.validate()) return;

            const params = { title: this.title, content: this.content, userId: this.userStore.userId };
            axios
                .post(process.env.VUE_APP_API_URL + "/article", params)
                .then((res) => {
                    console.log(res);
                    alert("아티클이 등록되었습니다");
                    this.$router.push("/article/" + res.data);
                })
                .catch(console.error);
        },
        validate() {
            if (!this.title) {
                alert("제목을 입력해주세요");
                return false;
            }

            if (this.title.trim().length <= 2 || this.title.trim().length >= 100) {
                alert("제목은 2자~100자로 입력해주세요");
                return false;
            }

            if (!this.content) {
                alert("내용을 입력해주세요");
                return false;
            }

            if (this.content.trim().length >= 4000) {
                alert("내용은 4000자 이하로 입력해주세요");
                return false;
            }

            return true;
        }
    }
};
</script>

<style scoped>
.title input {
    font-size: 3rem;
}
.content textarea {
    font-size: 1.5rem;
}
</style>
