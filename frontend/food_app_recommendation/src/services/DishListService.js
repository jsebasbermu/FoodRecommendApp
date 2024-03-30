import http from "../http-common.js";

class DishListService {
    getDishesFromMood(moodId) {
        return http.get(`/moods/${moodId}/dishes`);
    }
}

export default new DishListService();