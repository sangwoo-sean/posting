<template>
    <div class="d-flex-center flex-col">
        <div class="article-wrapper d-flex-center flex-col">
            <div class="article-card" v-for="(article, index) in articles" :key="index">
                <div class="header">
                    <span>author</span>
                    <span>Jan 22,2023</span>
                    <span>popular</span>
                </div>
                <div class="main">
                    <div>
                        <div class="body">
                            <h2>Lorem ipsum dolor sit amet.</h2>
                            <span class="content"
                                >Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aspernatur facere, possimus.
                                Accusamus consequuntur corporis debitis dicta earum eveniet molestiae numquam provident
                                quisquam tenetur? Architecto dignissimos dolore eligendi incidunt iusto omnis placeat
                                quo ullam vero. Adipisci culpa doloribus eligendi ipsam iste iure laboriosam, minus quae
                                quas quibusdam. Consequatur delectus fugit harum ipsa natus omnis praesentium quibusdam
                                sunt veritatis! Accusamus aliquam amet aperiam aspernatur atque beatae dicta dolor
                                dolores eligendi est eveniet expedita facere facilis fugit illum, impedit laborum libero
                                maiores minima necessitatibus, neque odit optio perspiciatis quia quis quos ratione
                                repellendus sunt temporibus voluptates! Aliquid dolores ex numquam quia repellat
                                voluptatibus?</span
                            >
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
            this.articles = [1, 2, 3, 4, 5, 6, 7, 8];
        },
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
