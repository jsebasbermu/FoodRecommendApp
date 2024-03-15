import { createWebHistory, createRouter } from "vue-router";
import UserLogin from "../components/UserLogin.vue";

const routes = [
    {
        path: "/",
        alias: "/login",
        name: "userLogin",
        component: UserLogin
    }
];

const router = createRouter({
    history: createWebHistory(),
    routes
})

export default router;