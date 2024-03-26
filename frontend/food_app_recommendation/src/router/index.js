import { createWebHistory, createRouter } from "vue-router";
import UserLogin from "../components/UserLogin.vue";
import UserDashboard from "../components/UserDashboard.vue";
import UserRegistration from "../components/UserRegistration.vue";
import MoodCuisineSelection from "../components/MoodCuisineSelection.vue";
import FeedbackSubmission from "../components/FeedbackSubmission.vue";
import RecommendedDish from "../components/RecommendedDish.vue";

const routes = [
    {
        path: "/",
        alias: "/login",
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

];

const router = createRouter({
    history: createWebHistory(),
    routes
})

export default router;