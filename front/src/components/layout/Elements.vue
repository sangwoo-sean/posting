<template>
    <div class="d-flex-center flex-col">
        <h1>buttons</h1>
        <hr />
        <div>
            <div class="btn-wrapper">
                <button class="btn">button1</button>
                <button class="btn">button2</button>
                <button class="btn">button3</button>
            </div>
            <div class="btn-wrapper">
                <button class="btn btn-dark-border">button dark border</button>
                <a href="javascript:void(0)" class="btn">a.btn</a>
            </div>
            <div class="btn-wrapper">
                <button class="btn btn-dark">button dark</button>
                <a href="javascript:void(0)" class="btn">a.btn</a>
            </div>
        </div>
        <hr />

        <h1>form</h1>
        <hr />
        <div style="width: 30%">
            <div class="input-group">
                <label>title</label>
                <input type="text" placeholder="placeholder" />
            </div>
            <div class="input-group">
                <label>title</label>
                <textarea placeholder="placeholder" rows="10"></textarea>
            </div>

            <h3>editable</h3>
            <div class="tags edit">
                <span class="tag" v-for="tag in tags"
                    >{{ tag }}<span class="delete-btn" @click="deleteTag(tag)"></span
                ></span>
                <input
                    type="text"
                    placeholder="태그를 입력하세요"
                    @keyup.enter="createTag"
                    @keydown.delete="deleteLastTag"
                    maxlength="20"
                />
            </div>
            <h3>읽기전용</h3>
            <div class="tags">
                <span class="tag" v-for="tag in tags"
                    >{{ tag }}<span class="delete-btn" @click="deleteTag(tag)"></span
                ></span>
            </div>
        </div>
        <hr />

        <h1>cards</h1>
        <hr />
        <div class="article-wrapper">
            <div class="article-card">
                <div class="header">
                    <span>author</span>
                    <span>Jan 22,2023</span>
                    <span>popular</span>
                </div>
                <div class="main">
                    <div class="detail">
                        <div class="body">
                            <h2>Lorem ipsum.</h2>
                            <span class="content">Lorem ipsum</span>
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
            <div class="article-card">
                <div class="header">
                    <span>author</span>
                    <span>Jan 22,2023</span>
                    <span>popular</span>
                </div>
                <div class="main">
                    <div class="detail">
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
            <div class="article-card">
                <div class="header">
                    <span>author</span>
                    <span>Jan 22,2023</span>
                    <span>popular</span>
                </div>
                <div class="main">
                    <div class="detail">
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
                </div>
            </div>
        </div>

        <hr />
        <h1>comments</h1>
        <div style="width: 50%">
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
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Id, porro.</p>
                            <p>
                                Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet deleniti distinctio
                                dolores, eos harum hic incidunt, inventore itaque maiores minus quas ratione saepe sint
                                velit voluptatem! Beatae cum odio quasi.
                            </p>
                            <p>
                                Lorem ipsum dolor sit amet, consectetur adipisicing elit. Alias aperiam deserunt eaque
                                facere harum laboriosam laudantium maxime, nam necessitatibus odio placeat tempore!
                                Alias aliquid consequuntur corporis debitis delectus dicta esse ex explicabo ipsum
                                itaque, libero magni maiores modi molestias nemo nesciunt officiis provident qui
                                sapiente suscipit tempora unde vero voluptates!
                            </p>
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
    </div>
</template>

<script>
export default {
    name: "Elements",
    data() {
        return {
            tags: ["lorem", "ipsum"]
        };
    },
    methods: {
        createTag(e) {
            const value = e.target.value;
            if (!value) return;

            if (this.tags.length >= 10) {
                alert("태그는 10개까지만 추가 가능합니다.");
                return;
            }

            if (this.tags.includes(value)) {
                e.target.value = "";
                return;
            }

            this.tags.push(value);
            e.target.value = "";
        },
        deleteLastTag(e) {
            if (e.target.value) return;

            this.tags.splice(this.tags.length - 1, 1);
        },
        deleteTag(targetTag) {
            this.tags = this.tags.filter((tag) => tag !== targetTag);
        }
    }
};
</script>

<style scoped></style>
