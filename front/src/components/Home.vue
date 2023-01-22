<template>
    <div class="d-flex-center flex-col">
        <div class="article-wrapper d-flex-center flex-col">
            <div class="article-card" v-for="(article, index) in articles" :key="index">
                <div class="header">
                    <span>author</span>
                    <span>{{ new Date(article.createdAt).toLocaleDateString("UK") }}</span>
                    <span>popular</span>
                </div>
                <div class="main">
                    <div class="detail">
                        <div class="body">
                            <h2>{{ article.title }}</h2>
                            <span class="content">{{ article.content }}</span>
                        </div>
                        <div class="footer">
                            <div class="tags">
                                <span class="tag">tag1</span>
                                <span class="tag">tag2</span>
                                <span class="tag">tag3</span>
                            </div>
                            <div class="icons">
                                <button>
                                    <img src="@/assets/svg/bookmark.svg" alt="bookmark" width="20" />
                                </button>
                                <button>
                                    <img src="@/assets/svg/three-dots.svg" alt="menu" width="20" />
                                </button>
                            </div>
                        </div>
                    </div>
                    <div class="image">
                        <img src="https://via.placeholder.com/100x100" alt="article" width="100" height="100" />
                    </div>
                </div>
            </div>
        </div>
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
        this.init();
    },
    data() {
        return {
            articles: []
        };
    },
    methods: {
        init() {
            this.findAllArticles();
        },
        findAllArticles() {
            axios
                .get(process.env.VUE_APP_API_URL + "/article/list")
                .then((res) => {
                    this.articles = res.data;
                })
                .catch(console.error);
        }
    }
};
</script>

<style scoped></style>
