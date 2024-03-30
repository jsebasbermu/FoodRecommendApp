import http from "../http-common";

class FavoriteFoodService{
    getAllDishes() {
        return http.get('/dishes');
    }
}

export default new FavoriteFoodService;