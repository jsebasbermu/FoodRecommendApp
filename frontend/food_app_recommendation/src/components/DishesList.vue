<template>
    
    <div class="dish-list">
        <router-link to="/userDashboard" class="btn-dashboard">Back to User Dashboard</router-link>
        <h1>Recommended List of Dishes</h1>
        <p>Here's a recommended list of dishes for you!</p>
        <div class="test-table">
            <table>
                <thead>
                    <tr>
                        <th>Image</th>
                        <th>Dish</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="dish in dishes" :key="dish.dishId">
                        <td>{{ dish.dishName }}</td>
                        <td>{{ dish.description }}</td>
                        <td class="button-cell">
                            <button @click="saveUserPreference(dish)">See recipe</button>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
        <br>
    </div>
</template>

<script>
import DishListService from '@/services/DishListService';
import UserPreferenceService from '@/services/UserPreferenceService';

export default {
    name: 'dishesList',
    data() {
        return {
            dishes: [],
        };
    },
    methods: {
        getDishes() {
            const moodId = this.$route.params.moodId;
            const cuisineId = this.$route.params.cuisineId;

            DishListService.getDishesByMoodAndCuisine(moodId, cuisineId)
                .then(response => {
                    this.dishes = response.data;
                    console.log("Fetched dishes:", this.dishes);
                })
                .catch(error => {
                    console.error("Error fetching dishes:", error);
                });
        },
        saveUserPreference(dish) {
            const userId = localStorage.getItem('userId');
            const moodId = this.$route.params.moodId;
            const cuisineId = this.$route.params.cuisineId;
            const dishId = dish.dishId;

            const userPreferenceData = {
                user: { userId: parseInt(userId) },
                mood: { moodId: parseInt(moodId) },
                cuisine: { cuisineId: parseInt(cuisineId) },
                dish: { dishId: parseInt(dishId) }
            };

            console.log("User Preference Data:", userPreferenceData);

            UserPreferenceService.saveUserPreference(userPreferenceData)
                .then(response => {
                    console.log("User preference saved:", response.data);
                    // Navigate to recommended dish route after saving user preference
                    this.$router.push({
                        name: 'recommendedDish',
                        params: { selectedId: dishId.toString() }
                    });
                })
                .catch(error => {
                    console.error("Error saving user preference:", error);
                });
        }
},
    mounted() {
        this.getDishes();
    }
};
</script>

<style scoped>
.dish-list {
    font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
    padding-top: 2%;
    padding-left: 20%;
    padding-right: 20%;
}

/* button group style */
.button-group {
    display: flex;
    justify-content: left;
}

.dish-image img {
    height: 30vh;
    margin: 20px;
}

.list {
    display: flex;
}

button {
    background-color: #007bff;
    color: #fff;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    width: 20vh;
}

/* Styles for the button */
.btn-dashboard {
  display: block;
  margin-top: 20px;
  background-color: #007bff;
  color: #fff;
  padding: 10px 20px;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  text-decoration: none;
  font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
}

/* Styling for the button cell */
.button-cell {
  border: none;
  text-align: center;
}

/* Styling for the table header */
.test-table th:nth-child(3) {
  border: none;
  background-color: white;
}
</style>

