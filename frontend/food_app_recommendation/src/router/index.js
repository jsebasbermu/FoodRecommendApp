import { createWebHistory, createRouter } from "vue-router";
import UserLogin from "../components/UserLogin.vue";
import UserDashboard from "../components/UserDashboard.vue";
import UserRegistration from "../components/UserRegistration.vue";
import MoodCuisineSelection from "../components/MoodCuisineSelection.vue";
import FeedbackSubmission from "../components/FeedbackSubmission.vue";
import RecommendedDish from "../components/RecommendedDish.vue";
import HomePage from "../components/HomePage.vue";
import FavoriteFood from "../components/FavoriteFood.vue";
import DishesList from "../components/DishesList.vue";

const routes = [
    {
        path: "/",
        alias: "/home",
        name: "homePage",
        component: HomePage
    },
    {
        path: "/login",
        name: "userLogin",
        component: UserLogin
    },
    {
        path: "/userDashboard",
        name: "userDashboard",
        component: UserDashboard
    },
    {
        path: "/userRegistration",
        component: UserRegistration
    },
    {
        path: "/moodCuisineSelection",
        component: MoodCuisineSelection
    },
    {
        path: "/recommendedDish",
        component: RecommendedDish
    },
    {
        path: "/feedbackSubmission",
        component: FeedbackSubmission
    },
    {
        path: "/favoritefood",
        component: FavoriteFood
    },
    {
        path:"/dishesList",
        component: DishesList
    },
    {
        path:"/dishesList/:moodId/:cuisineId",
        name: "dishesList",
        component: DishesList
    }    

];

const router = createRouter({
    history: createWebHistory(),
    routes
})

export default router;