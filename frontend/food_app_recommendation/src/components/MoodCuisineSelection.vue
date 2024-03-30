<template>
    <div class="mood-cuisine-selection">
      <h2>Mood & Cuisine Selection</h2>
      <div class="form-group">
        <label for="mood">Mood:</label>
        <select v-model="selectedMood" id="mood">
          <option v-for="mood in moodsList" :key="mood.moodId" :value="mood.moodId">{{ mood.moodName }}</option>
        </select>
      </div>
      <div class="form-group">
        <label for="cuisine">Cuisine:</label>
        <select  v-model="selectedCuisine" id="cuisine">
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
      getMoods(){
        FavoriteFoodService.getAllMoods().
        then(response => {
          this.moodsList = response.data;
          console.log(response.data);
        })
        .catch(error => {
          console.error('Error fetching moods:', error);
        });
      },
      getCuisines(){
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
    mounted(){
        this.getMoods(); 
        this.getCuisines();
    }}
  </script>
  
  <style scoped>
  .mood-cuisine-selection {
    max-width: 400px;
    margin: 0 auto;
    padding: 20px;
    border: 1px solid #ccc;
    border-radius: 5px;
  }
  .form-group {
    margin-bottom: 15px;
  }
  label {
    display: block;
    font-weight: bold;
  }
  select,
  button {
    width: 100%;
    padding: 10px;
    font-size: 16px;
  }
  button {
    background-color: #007bff;
    color: #fff;
    border: none;
    border-radius: 5px;
    cursor: pointer;
  }
  button:hover {
    background-color: #0056b3;
  }
  </style>