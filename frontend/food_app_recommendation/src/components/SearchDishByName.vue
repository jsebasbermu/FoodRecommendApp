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
    
    <br>
    <br>
    
    <!-- Search Form -->
    <div class="search-form">
      <label for="searchInput" class="search-label">Dish Name:</label>
      <input type="text" v-model="searchInput" id="searchInput" class="search-input">
      <button @click="searchDish" class="search-button">Search</button>
    </div>

    <!-- Display message before searching -->
    <div v-if="!searchResults.length" class="search-message">
      Start searching for dish using dish name.
    </div>

    <!-- Dish Table -->
    <div class="dish-table" v-if="searchResults.length">
      <table class="test-table">
        <thead>
          <tr>
            <th>Dish Name</th>
            <th>Description</th>
            <th></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="dish in searchResults" :key="dish.dishId">
            <td>{{ dish.dishName }}</td>
            <td>{{ dish.description }}</td>
            <td class="button-cell">
              <button @click="seeRecipe(dish.dishId)">See Recipe</button>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
import DishListService from "@/services/DishListService";

export default {
  name: "SearchDish",
  data() {
    return {
      searchInput: "",
      searchResults: []
    };
  },
  methods: {
    searchDish() {
      DishListService.searchDishesByName(this.searchInput)
        .then(response => {
          this.searchResults = response.data;
        })
        .catch(error => {
          console.error("Error searching dish:", error);
        });
    },
    seeRecipe(dishId) {
      this.$router.push({ name: "recommendedDish", params: { selectedId: dishId.toString() } });
    }
  }
};
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
  text-align: center;
  margin-bottom: 20px;
}

.company-logo img {
  max-width: 30%;
  height: auto;
}

.app-name {
  font-size: 24px;
  margin-top: 10px;
}

.search-form {
  display: flex;
  align-items: center;
  margin-bottom: 20px;
}

.search-label {
  margin-right: 10px;
}

.search-input {
  flex: 1;
  padding: 10px;
  border: 1px solid #CCCCCC;
  border-radius: 5px;
  font-size: 16px;
}

.search-button {
  padding: 10px 20px;
  border: none;
  border-radius: 5px;
  background-color: #ff0303;
  color: #FFFFFF;
  font-family: 'Inter', sans-serif;
  font-size: 16px;
  font-weight: bold;
  cursor: pointer;
  transition: background-color 0.3s ease;
}

.search-button:hover {
  background-color: #D1D1D1;
}

.dish-table {
  width: 50%;
}

table {
  width: 100%;
  border-collapse: collapse;
}

thead {
  background-color: #D1D1D1;
}

thead th {
  padding: 10px;
  text-align: left;
  font-size: 18px;
  font-weight: bold;
  color: #444444;
}

tbody tr:nth-child(even) {
  background-color: #F5F5F5;
}

tbody td {
  padding: 10px;
  font-size: 16px;
  color: #444444;
}

.button-cell {
  text-align: center;
}

button {
  padding: 10px 20px;
  border: none;
  border-radius: 5px;
  background-color: #ff0303;
  color: #FFFFFF;
  font-family: 'Inter', sans-serif;
  font-size: 16px;
  font-weight: bold;
  cursor: pointer;
  transition: background-color 0.3s ease;
}

button:hover {
  background-color: #D1D1D1;
}
</style>
