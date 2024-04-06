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

    <!-- Dish Details -->
    <div class="dish-recommended">
      <div v-if="dish">
        <div class="dish-image">
          <img :src="dish.imageURL" alt="Dish Image" />
        </div>
        <div class="dish-details">
          <h2>{{ dish.dishName }}</h2>
          <div>
            <h3>Description:</h3>
            <p>{{ dish.description }}</p>
          </div>
          <div>
            <h3>Ingredients:</h3>
            <p>{{ dish.ingredients }}</p>
          </div>
          <div v-if="dish.instructions">
            <h3>Instructions:</h3>
            <p>{{ dish.instructions }}</p>
          </div>
          <div v-else>
            <h3>Instructions:</h3>
            <p>Loading...</p>
          </div>
          <button @click="addToFavorites" class="add-to-favorites-btn">Add to favorites</button>
        </div>
      </div>
      <div v-else>
        <p>Loading...</p>
      </div>
    </div>
  </div>
</template>


<script>
import FavoriteFoodService from "@/services/FavoriteFoodService";
import DishListService from "@/services/DishListService";

export default {
  name: "RecommendedDish",
  data() {
    return {
      dish: {
        imageURL: "",
        name: "",
        description: "",
        ingredients: "",
        instructions: ""
      }
    };
  },
  methods: {
    fetchDishDetails(selectedId) {
      DishListService.getDishById(selectedId)
        .then(response => {
          this.dish = response.data;
          this.fetchInstructions(selectedId); // Fetch instructions after fetching dish details
        })
        .catch(error => {
          console.error("Error fetching dish details:", error);
          this.dish = null;
        });
    },
    fetchInstructions(dishId) {
  DishListService.getRecipesByDish(dishId)
    .then(response => {
      // Check if the response data is not empty
      if (response.data.length > 0) {
        // Extract instructions from the first recipe object
        this.dish.instructions = response.data[0].instructions;
      } else {
        this.dish.instructions = "Instructions not available";
      }
    })
    .catch(error => {
      console.error("Error fetching dish instructions:", error);
      this.dish.instructions = "Instructions not available";
    });
},

    addToFavorites() {
      FavoriteFoodService.addToFavorites(this.dish.dishName);
      console.log("Dish added to favorites:", this.dish);
      // Optionally, you can add a message or update UI to indicate the dish was added to favorites

      // Redirect user to "/favoritefood"
      this.$router.push("/favoritefood");
    }
  },
  mounted() {
    const selectedId = this.$route.params.selectedId;
    console.log("Dish ID: ", selectedId);
    this.fetchDishDetails(selectedId);
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

.btn-dashboard {
  margin-bottom: 20px;
}

.dish-recommended {
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-top: 20px;
}

.dish-image img {
  max-width: 100%;
  height: auto;
}

.dish-details {
  margin-top: 20px;
}

.dish-details h2 {
  font-size: 24px;
  margin-bottom: 10px;
}

.dish-details h3 {
  font-size: 20px;
  margin-bottom: 10px;
}

.dish-details p {
  font-size: 16px;
  color: #555555;
}

.add-to-favorites-btn {
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
  margin-top: 20px;
}

.add-to-favorites-btn:hover {
  background-color: #D1D1D1;
}
</style>
