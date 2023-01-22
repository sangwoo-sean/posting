<template>
    <div class="d-flex-center flex-col">
        <h1>buttons</h1>
        <hr />
        <div>
            <button class="btn">button</button>
            <a href="javascript:void(0)" class="btn">a.btn</a>
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
        </div>
        <hr />

        <h1>cards</h1>
        <hr />
        <div class="article-card">
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
                            quisquam tenetur? Architecto dignissimos dolore eligendi incidunt iusto omnis placeat quo
                            ullam vero. Adipisci culpa doloribus eligendi ipsam iste iure laboriosam, minus quae quas
                            quibusdam. Consequatur delectus fugit harum ipsa natus omnis praesentium quibusdam sunt
                            veritatis! Accusamus aliquam amet aperiam aspernatur atque beatae dicta dolor dolores
                            eligendi est eveniet expedita facere facilis fugit illum, impedit laborum libero maiores
                            minima necessitatibus, neque odit optio perspiciatis quia quis quos ratione repellendus sunt
                            temporibus voluptates! Aliquid dolores ex numquam quia repellat voluptatibus?</span
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
                <div>
                    <div class="body">
                        <h2>Lorem ipsum dolor sit amet.</h2>
                        <span class="content"
                            >Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aspernatur facere, possimus.
                            Accusamus consequuntur corporis debitis dicta earum eveniet molestiae numquam provident
                            quisquam tenetur? Architecto dignissimos dolore eligendi incidunt iusto omnis placeat quo
                            ullam vero. Adipisci culpa doloribus eligendi ipsam iste iure laboriosam, minus quae quas
                            quibusdam. Consequatur delectus fugit harum ipsa natus omnis praesentium quibusdam sunt
                            veritatis! Accusamus aliquam amet aperiam aspernatur atque beatae dicta dolor dolores
                            eligendi est eveniet expedita facere facilis fugit illum, impedit laborum libero maiores
                            minima necessitatibus, neque odit optio perspiciatis quia quis quos ratione repellendus sunt
                            temporibus voluptates! Aliquid dolores ex numquam quia repellat voluptatibus?</span
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

        <hr />
    </div>
</template>

<script>
export default {
    name: "Elements"
};
</script>

<style scoped></style>
