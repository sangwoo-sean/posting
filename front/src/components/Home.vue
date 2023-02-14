<template>
    <div class="d-flex-center flex-col">
        <div class="article-wrapper d-flex-center flex-col">
            <div class="article-card" v-for="(article, index) in articles" :key="index">
                <div class="header">
                    <span>{{ article.author }}</span>
                    <span>{{ new Date(article.createdAt).toLocaleDateString() }}</span>
                    <span>popular</span>
                </div>
                <div class="main">
                    <div class="detail">
                        <router-link :to="'/article/' + article.id" class="body">
                            <h2>{{ article.title }}</h2>
                            <span class="content">{{ article.content }}</span>
                        </router-link>
                        <div class="footer">
                            <div class="tags">
                                <span class="tag" v-for="(tag, index) in article.tags" :key="index">{{ tag }}</span>
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
                    <router-link :to="'/article/' + article.id" class="image">
                        <img src="https://via.placeholder.com/100x100" alt="article" width="100" height="100" />
                    </router-link>
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
                .get(process.env.VUE_APP_API_URL + "/articles")
                .then((res) => {
                    this.articles = res.data;
                })
                .catch(console.error);
        }
    }
};
</script>

<style scoped></style>
