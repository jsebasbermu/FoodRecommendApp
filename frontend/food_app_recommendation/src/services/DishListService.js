import http from "../http-common.js";

class DishListService {
    getDishesFromMood(moodId) {
        return http.get(`/moods/${moodId}/dishes`);
    }
    getDishesFromCuisine(cuisineId){
        return http.get(`/cuisines/${cuisineId}/dishes`);
    }
    getDishesByMoodAndCuisine(moodId, cuisineId) {
        return http.get(`/dishes?moodId=${moodId}&cuisineId=${cuisineId}`);
    }
    getDishById(dishId) {
        return http.get(`/dishes/${dishId}`);
    }
    getRecipesByDish(dishId) {
        return http.get(`/dishes/${dishId}/recipes`);
    }
    
}

export default new DishListService();