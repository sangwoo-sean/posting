<template>
    <div class="d-flex-center flex-col">
        <div>메인화면입니다. 아티클이 주루룩</div>
        <div>
            <h2>환영합니다</h2>
            <button @click="requestSomething">USER 전용 API 호출</button>
        </div>

        <hr />

        <div></div>
    </div>
</template>

<script>
import axios from "axios";
import { useUserStore } from "@/stores/userStore";

export default {
    name: "Home",
    setup() {
        const userStore = useUserStore();
        return { userStore };
    },
    created() {
        console.log(this.$isEmpty(""));
        console.log(this.$isEmpty("?"));
    },
    methods: {
        requestSomething() {
            axios
                .get(process.env.VUE_APP_API_URL + "/user?email=" + this.userStore.email)
                .then((res) => {
                    console.log(res);
                    alert(res.data);
                })
                .catch(console.error);
        }
    }
};
</script>

<style scoped></style>
