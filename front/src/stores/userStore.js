import { defineStore } from "pinia/dist/pinia";

export const useUserStore = defineStore('userStore', {
    state: () => ({
        token: "",
        email: ""
    }),
    actions: {
        setToken(token) {
            this.token = token;
        },
        login({token, email}) {
            this.token = token;
            this.email = email;
        }
    }
})