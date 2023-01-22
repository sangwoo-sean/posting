import { defineStore } from "pinia/dist/pinia";

export const useUserStore = defineStore("userStore", {
    state: () => ({
        token: "",
        email: "",
        userId: ""
    }),
    actions: {
        login({ token, email, userId }) {
            this.token = token;
            this.email = email;
            this.userId = userId;
        },
        logout() {
            this.token = "";
            this.email = "";
        }
    },
    persist: true
});
