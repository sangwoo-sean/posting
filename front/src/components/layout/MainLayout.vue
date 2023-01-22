<template>
    <div>
        <Header />
        <Main />
        <Footer />
    </div>
</template>

<script>
import Header from "@/components/layout/Header.vue";
import Footer from "@/components/layout/Footer.vue";
import Main from "@/components/layout/Main.vue";

export default {
    name: "MainLayout",
    components: { Main, Footer, Header }
};
</script>

<style scoped></style>
