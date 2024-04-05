<template>
  <div class="mood-cuisine-selection">
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
    <h2>Mood & Cuisine Selection</h2>
    <div class="form-group">
      <label for="mood">Mood:</label>
      <select v-model="selectedMood" id="mood">
        <option v-for="mood in moodsList" :key="mood.moodId" :value="mood.moodId">{{ mood.moodName }}</option>
      </select>
    </div>
    <div class="form-group">
      <label for="cuisine">Cuisine:</label>
      <select v-model="selectedCuisine" id="cuisine">
        <option v-for="cuisine in cuisinesList" :key="cuisine.cuisineId" :value="cuisine.cuisineId">{{ cuisine.cuisineName }}</option>
      </select>
    </div>
    <button @click="goToRecommendation">Get Recommendations</button>
  </div>
</template>


<script>
import FavoriteFoodService from '@/services/FavoriteFoodService';
export default {
  name: "MoodCuisineSelection",
  data() {
    return {
      moodsList: [],
      cuisinesList: [],
      selectedMood: "",
      selectedCuisine: ""
    };
  },
  methods: {
    getMoods() {
      FavoriteFoodService.getAllMoods().
        then(response => {
          this.moodsList = response.data;
          console.log(response.data);
        })
        .catch(error => {
          console.error('Error fetching moods:', error);
        });
    },
    getCuisines() {
      FavoriteFoodService.getAllCuisines().
        then(response => {
          this.cuisinesList = response.data;
          console.log(response.data);
        })
        .catch(error => {
          console.error('Error fetching cuisines:', error);
        });
    },
    goToRecommendation() {
      this.$router.push({
        name: 'dishesList',
        params: {
          moodId: this.selectedMood.toString(),
          cuisineId: this.selectedCuisine.toString()
        }
      });
    }
  },
  mounted() {

    this.getMoods();
    this.getCuisines();
  }
}
</script>

<style scoped>
.mood-cuisine-selection {
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

.form-group {
    margin-bottom: 20px; /* Add spacing between form groups */
}

form-group label {
    font-weight: bold; /* Make labels bold */
}

select {
    width: 100%; /* Full width for select inputs */
    padding: 10px; /* Add padding */
    border: 1px solid #CCCCCC; /* Add border */
    border-radius: 5px; /* Add border radius */
    font-size: 16px; /* Adjust font size */
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
