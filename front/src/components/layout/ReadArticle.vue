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
            <p v-for="line in formatTextareaContent(article.content)" v-html="line"></p>
        </div>

        <div class="comment-wrapper">
            <div class="input-area">
                <textarea rows="3"></textarea>
                <button class="btn">comment</button>
            </div>
            <div class="comments">
                <div class="comment">
                    <div class="header">
                        <div>
                            <span class="author">작성자</span>
                            <span>23.1.25</span>
                        </div>
                        <div>
                            <a href="javascript:void(0)"><span>reply</span></a>
                        </div>
                    </div>
                    <div class="body">
                        <p>comment</p>
                        <p>comment</p>
                        <p>comment</p>
                    </div>
                </div>
                <div class="comment">
                    <div class="header">
                        <div>
                            <span class="author">작성자</span>
                            <span>23.1.25</span>
                        </div>
                        <div>
                            <a href="javascript:void(0)"><span>reply</span></a>
                        </div>
                    </div>
                    <div class="body">
                        <p>comment</p>
                        <p>comment</p>
                        <p>comment</p>
                    </div>
                    <div class="input-area">
                        <textarea rows="3"></textarea>
                        <button class="btn">reply</button>
                    </div>
                </div>
                <div class="comment">
                    <div class="header">
                        <div>
                            <span class="author">작성자</span>
                            <span>23.1.25</span>
                        </div>
                        <div>
                            <a href="javascript:void(0)"><span>reply</span></a>
                        </div>
                    </div>
                    <div class="body">
                        <span>comment</span>
                    </div>
                    <div class="input-area">
                        <textarea rows="3"></textarea>
                        <button class="btn">reply</button>
                    </div>
                    <div class="children">
                        <div class="child">
                            <div class="header">
                                <div>
                                    <span class="author">작성자</span>
                                    <span>23.1.25</span>
                                </div>
                            </div>
                            <div class="body">
                                <p>comment</p>
                                <p>comment</p>
                                <p>comment</p>
                            </div>
                        </div>
                        <div class="child">
                            <div class="header">
                                <div>
                                    <span class="author">작성자</span>
                                    <span>23.1.25</span>
                                </div>
                            </div>
                            <div class="body">
                                <p>comment</p>
                                <p>comment</p>
                                <p>comment</p>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="comment">
                    <div class="header">
                        <div>
                            <span class="author">작성자</span>
                            <span>23.1.25</span>
                        </div>
                        <div>
                            <a href="javascript:void(0)"><span>reply</span></a>
                        </div>
                    </div>
                    <div class="body">
                        <span>comment</span>
                    </div>
                    <div class="children">
                        <div class="child">
                            <div class="header">
                                <div>
                                    <span class="author">작성자</span>
                                    <span>23.1.25</span>
                                </div>
                            </div>
                            <div class="body">
                                <p>comment</p>
                                <p>comment</p>
                                <p>comment</p>
                            </div>
                        </div>
                        <div class="child">
                            <div class="header">
                                <div>
                                    <span class="author">작성자</span>
                                    <span>23.1.25</span>
                                </div>
                            </div>
                            <div class="body">
                                <p>comment</p>
                                <p>comment</p>
                                <p>comment</p>
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

export default {
    name: "ReadArticle",
    data() {
        return {
            article: {
                title: "",
                content: "",
                createdAt: "",
                viewCount: 0,
                tags: []
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

<style scoped>
.article-detail {
    min-height: 30rem;
}
</style>
