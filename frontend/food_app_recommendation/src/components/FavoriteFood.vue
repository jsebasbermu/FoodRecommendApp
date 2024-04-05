<template>
    <div class="favFood">
      <!-- Header Section -->
      <header class="header">
        <div class="company-logo">
          <img src="../assets/companylogo.png" alt="Company Logo">
        </div>
        <h2 class="app-name">MoodPlate</h2>
      </header>
  
    <!-- Back to Dashboard Button -->
    <router-link to="/userDashboard" class="btn-dashboard">&#8249; Back to User Dashboard</router-link>

      <!-- Main Content -->
      <div>
        <h1>Favorite Food</h1>
      </div>
      <div>
        <label for="food-list">Please choose the food you want to save from below</label>
        <br><br>
        <select name="favoriteFood" id="food-list" v-model="selectedDish">
          <option v-for="dish in dishes" :key="dish.dishName" :value="dish.dishName">{{ dish.dishName }}</option>
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
            this.favoriteFoods = []; // Clear the favoriteFoods array in the component

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


<style scoped>
.favFood {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    padding: 20px;
    font-family: 'Inter', sans-serif;
}

.header {
    text-align: center; /* Align content center */
    margin-bottom: 20px; /* Add spacing between the header and content */
}

.company-logo img {
    max-width: 30%; /* Ensure the logo fits within the header */
    height: auto; /* Maintain aspect ratio */
}

.app-name {
    font-size: 24px; /* Adjust font size */
    margin-top: 10px; /* Add spacing between logo and app name */
}

.button-container {
    display: flex;
    justify-content: center;
    margin-top: 20px; /* Add spacing above the button container */
}

button {
    padding: 10px 20px; /* Add padding */
    border: none; /* Remove default border */
    border-radius: 5px; /* Add border radius */
    background-color: #ff0303; /* Primary color */
    color: #FFFFFF; /* White text */
    font-family: 'Inter', sans-serif;
    font-size: 16px;
    font-weight: bold; /* Bold font weight */
    cursor: pointer;
    transition: background-color 0.3s ease;
    margin: 0 10px; /* Add spacing between buttons */
}

button:hover {
    background-color: #D1D1D1; /* Lighter gray on hover */
}

ul {
    list-style-type: none; /* Remove bullet points */
    padding: 0; /* Remove default padding */
    margin: 0; /* Remove default margin */
}

ul li {
    font-size: 16px; /* Adjust font size */
    margin-bottom: 5px; /* Add spacing between list items */
}
#food-list {
  padding: 10px;
  border: 1px solid #CCCCCC;
  border-radius: 5px;
  width: 100%; /* Adjust width as needed */
  font-size: 16px;
  color: #555555;
}
</style>
