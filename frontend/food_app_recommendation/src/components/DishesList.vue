<template>
    <div class="dish-list">
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
      <h1>Recommended List of Dishes</h1>
      <p>Here's a recommended list of dishes for you!</p>
      <div class="test-table">
        <table>
          <thead>
            <tr>
              <th>Dish Name</th>
              <th>Description</th>
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

.btn-dashboard {
    margin-bottom: 20px; /* Add spacing below */
}

.test-table {
    width: 50%;
}

table {
    width: 100%;
    border-collapse: collapse;
}

thead {
    background-color: #D1D1D1; /* Light gray background for header */
}

thead th {
    padding: 10px;
    text-align: left;
    font-size: 18px;
    font-weight: bold;
    color: #444444; /* Darker gray */
}

tbody tr:nth-child(even) {
    background-color: #F5F5F5; /* Alternate row background color */
}

tbody td {
    padding: 10px;
    font-size: 16px;
    color: #444444; /* Darker gray */
}

.button-cell {
    text-align: center;
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
}

button:hover {
    background-color: #D1D1D1; /* Lighter gray on hover */
}
</style>
