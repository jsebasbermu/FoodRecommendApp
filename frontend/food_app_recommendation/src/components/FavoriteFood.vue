<template>
    <div class="favFood">
        <div>
            <h1>Favorite Food</h1>

        </div>
        <div>

            <label for="food-list">Please choose the food you want to save from below</label>
            <br><br>

            <select name="favoriteFood" id="food-list" v-model="selectedDish">
                <option v-for="dish in dishes" :key="dish.dishName" :value="dish.dishName">
                    {{ dish.dishName }}
                </option>

            </select>
            <br><br>


        </div>
        <br><br>

        <div class="button-container">
            <button type="submit" @click="saveFavoriteFood">Save</button>
            <button type="submit" @click="clearFavoriteFoods">Clear Food List</button>
        </div>

        <div>
            <h1>Favorite Foods</h1>
            <ul>
                <li v-for="(food, index) in favoriteFoods" :key="index">{{ food }}</li>
            </ul>
        </div>
    </div>

</template>

<script>
import FavoriteFoodService from "../services/FavoriteFoodService";

export default {
    name: "FavoriteFood",
    data() {
        return {
            favoriteFoods: [],
            dishes: null,
            selectedDish: null,
        }
    },
    methods: {
        clearFavoriteFoods(event) {
            event.preventDefault();

            localStorage.removeItem('favoriteFoods');
            alert("Food list removed ");

        },

        saveFavoriteFood() {
            let favoriteFoods = localStorage.getItem('favoriteFoods')

            if (!favoriteFoods) {
                favoriteFoods = [];
            } else {
                favoriteFoods = JSON.parse(favoriteFoods);
            }
            favoriteFoods.push(this.selectedDish);
            localStorage.setItem('favoriteFoods', JSON.stringify(favoriteFoods));
            console.log(localStorage.getItem('favoriteFoods'));
            alert("Food added to the Favorite List");
            const storedFoods = localStorage.getItem("favoriteFoods");
            if (storedFoods) {
                this.favoriteFoods = JSON.parse(storedFoods);
            }

        },

        allDishes() {

            FavoriteFoodService.getAllDishes()
                .then(response => {
                    this.dishes = response.data;
                    console.log(this.dishes);
                })
                .catch(error => {
                    console.log(error);
                })
        },
        loadFavoriteFoods() {
            const storedFoods = localStorage.getItem("favoriteFoods");
            if (storedFoods) {
                this.favoriteFoods = JSON.parse(storedFoods);
            }
        },


    },
    mounted() {

        this.allDishes();
        this.loadFavoriteFoods();

    },

}

</script>


<style>
button {
    padding: 10px 20px;
    
    font-size: 16px;
    background-color: #007bff;
    color: #fff;
    border: none;
    border-radius: 5px;
    cursor: pointer;
}

button:hover {
    background-color: #0056b3;
}

label {
    display: block;
    font-weight: bold;
    font-size: 16px;
}

select {
    padding: 10px;
    font-size: 16px;
    border: 1px solid #ccc;
    border-radius: 5px;
    background-color: #fff;
    color: #333;
    width: 200px;
}

select option:hover {
    background-color: #f2f2f2;
}
.favFood {
  max-width: 400px;
  margin: 0 auto;
  padding: 20px;
  
  border-radius: 5px;
  background-color: white;
}
</style>