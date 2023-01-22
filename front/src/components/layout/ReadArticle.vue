<template>
    <div style="width: 50%; margin: auto; text-align: left">
        <h2>{{ article.title }}</h2>
        <div style="text-align: right">
            <span style="margin-right: 2rem">조회수: {{ article.viewCount }}</span>
            <span>출간일: {{ new Date(this.article.createdAt).toLocaleString() }}</span>
        </div>

        <div class="article-detail">
            <p v-for="line in formatTextareaContent(article.content)" v-html="line"></p>
        </div>
    </div>
</template>

<script>
import axios from "axios";

export default {
    name: "ReadArticle",
    data() {
        return {
            article: {
                title: "",
                content: "",
                createdAt: "",
                viewCount: 0
            }
        };
    },
    created() {
        this.init();
    },
    methods: {
        init() {
            let articleId = this.$route.params.articleId;
            axios
                .get(process.env.VUE_APP_API_URL + "/article/" + articleId)
                .then((res) => {
                    Object.assign(this.article, res.data);
                })
                .catch(console.error);
        },
        formatTextareaContent(input) {
            if (!input) return [];

            return input.split("\n").map((line) => (line === "" ? "<br>" : line));
        }
    }
};
</script>

<style scoped></style>
