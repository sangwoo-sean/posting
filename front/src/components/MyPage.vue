<template>
    <div>
        <h1>This is My Page</h1>
        <h1>name: {{ userStore.name }}</h1>
        <h1>email: {{ userStore.email }}</h1>
        <div>내가 쓴 글</div>
        <div>북마크한 글</div>
        <div>포인트</div>
        <div>비밀번호 변경</div>
        <div>기타 개인정보</div>
    </div>
</template>

<script>
import { useUserStore } from "@/stores/userStore";

export default {
    name: "MyPage",
    setup() {
        const userStore = useUserStore();
        return { userStore };
    }
};
</script>

<style scoped></style>
