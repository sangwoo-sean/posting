import { defineStore } from "pinia/dist/pinia";

export const useUserStore = defineStore("userStore", {
    state: () => ({
        token: "",
        name: "",
        email: "",
        userId: ""
    }),
    actions: {
        login({ token, email, userId, name }) {
            this.token = token;
            this.name = name;
            this.email = email;
            this.userId = userId;
        },
        logout() {
            this.token = "";
            this.email = "";
            this.name = "";
            this.userId = "";
        }
    },
    persist: true
});
