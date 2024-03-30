import http from "../http-common";

class FavoriteFoodService{
    getAllDishes() {
        return http.get('/dishes');
    }
    getAllCuisines(){
        return http.get('/cuisines')
    }
    getAllMoods(){
        return http.get('/moods')
    }
}

export default new FavoriteFoodService;