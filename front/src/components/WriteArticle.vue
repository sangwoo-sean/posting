<template>
    <div style="width: 50%; margin: auto">
        <h2>Write Your Own Article</h2>

        <div class="input-group title">
            <input type="text" placeholder="제목을 입력하세요" v-model="title" />
        </div>
        <div class="input-group content">
            <textarea placeholder="내용을 입력하세요" rows="10" v-model="content"></textarea>
        </div>

        <div class="d-flex justify-right">
            <button class="btn btn-dark" @click="registerArticle">출간</button>
        </div>
    </div>
</template>

<script>
export default {
    name: "WriteArticle",
    data() {
        return {
            title: "",
            content: ""
        };
    },
    methods: {
        registerArticle() {
            alert(this.title);
            alert(this.content);
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
