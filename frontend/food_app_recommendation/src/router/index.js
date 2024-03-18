import { createWebHistory, createRouter } from "vue-router";
import UserLogin from "../components/UserLogin.vue";
import UserDashboard from "../components/UserDashboard.vue";

const routes = [
    {
        path: "/",
        alias: "/login",
        name: "userLogin",
        component: UserLogin
    },
    {
        path: "/",
        alias: "/userDashboard",
        name: "userDashboard",
        component: UserDashboard
    }
];

const router = createRouter({
    history: createWebHistory(),
    routes
})

export default router;