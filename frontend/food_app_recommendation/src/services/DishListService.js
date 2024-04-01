import http from "../http-common.js";

class DishListService {
    getDishesFromMood(moodId) {
        return http.get(`/moods/${moodId}/dishes`);
    }
    getDishesFromCuisine(cuisineId){
        return http.get(`/cuisines/${cuisineId}/dishes`)
    }
}

export default new DishListService();