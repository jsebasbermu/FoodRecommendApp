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
    addToFavorites(dish) {
        let favoriteFoods = localStorage.getItem('favoriteFoods');
    
        if (!favoriteFoods) {
          favoriteFoods = [];
        } else {
          favoriteFoods = JSON.parse(favoriteFoods);
        }
    
        favoriteFoods.push(dish);
        localStorage.setItem('favoriteFoods', JSON.stringify(favoriteFoods));
      }
}

export default new FavoriteFoodService;