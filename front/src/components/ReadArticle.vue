<template>
    <div style="width: 50%; margin: auto; text-align: left">
        <h2>{{ article.title }}</h2>
        <div style="text-align: right">
            <span style="margin-right: 2rem">조회수: {{ article.viewCount }}</span>
            <span>출간일: {{ new Date(this.article.createdAt).toLocaleString() }}</span>
        </div>

        <div class="tags">
            <span class="tag" v-for="tag in article.tags">{{ tag }}</span>
        </div>

        <div class="article-detail">
            <p v-for="line in $formatTextareaContent(article.content)" v-html="line"></p>
        </div>

        <h4>comments ({{ article.comments.length }})</h4>
        <div class="comment-wrapper">
            <div class="input-area">
                <textarea rows="3"></textarea>
                <button class="btn" @click="createComment">comment</button>
            </div>
            <div class="comments">
                <div class="comment" v-for="(comment, index) in article.comments" :key="index">
                    <div class="header">
                        <div>
                            <span class="author">{{ comment.author }}</span>
                            <span>{{ comment.createdAt }}</span>
                        </div>
                        <div>
                            <button @click="comment.open = !comment.open">reply</button>
                        </div>
                    </div>
                    <div class="body">
                        <p v-for="line in $formatTextareaContent(comment.content)" v-html="line"></p>
                    </div>
                    <div class="input-area" v-show="comment.open">
                        <textarea rows="3"></textarea>
                        <button class="btn" @click="createComment($event, comment.id)">reply</button>
                    </div>
                    <div class="children" v-if="comment.children && comment.children.length > 0">
                        <div class="child" v-for="(child, childIndex) in comment.children" :key="childIndex">
                            <div class="header">
                                <div>
                                    <span class="author">{{ child.author }}</span>
                                    <span>{{ child.createdAt }}</span>
                                </div>
                            </div>
                            <div class="body">
                                <p v-for="line in $formatTextareaContent(child.content)" v-html="line"></p>
                            </div>
                        </div>
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
    name: "ReadArticle",
    setup() {
        const userStore = useUserStore();
        return { userStore };
    },
    data() {
        return {
            article: {
                title: "",
                content: "",
                createdAt: "",
                viewCount: 0,
                tags: [],
                comments: []
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
                    this.article.comments.forEach(
                        (comment) => (comment.createdAt = new Date(comment.createdAt).toLocaleString())
                    );
                    this.reArrangeComments();
                })
                .catch(console.error);
        },
        createComment(e, parentId) {
            const content = e.target.previousSibling.value;
            if (!content || !content.trim().length) return;

            const params = {
                content,
                userId: this.userStore.userId,
                articleId: Number(this.$route.params.articleId)
            };

            if (parentId) {
                params.parentId = parentId;
            }

            axios
                .post(process.env.VUE_APP_API_URL + "/comment", params)
                .then((res) => {
                    console.log(res);
                    e.target.previousSibling.value = "";
                    this.init();
                })
                .catch(console.error);
        },
        reArrangeComments() {
            const parents = this.article.comments.filter((comment) => !comment.parentId);
            parents.forEach((parent) => {
                parent.children = this.article.comments.filter((comment) => comment.parentId === parent.id);
            });
            this.article.comments = parents;
        }
    }
};
</script>

<style scoped>
.article-detail {
    min-height: 20rem;
}
</style>
