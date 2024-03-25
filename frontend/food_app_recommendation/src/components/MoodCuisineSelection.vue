<template>
    <div class="mood-cuisine-selection">
      <h2>Mood & Cuisine Selection</h2>
      <div class="form-group">
        <label for="mood">Mood:</label>
        <select v-model="selectedMood" id="mood">
          <option value="Stressed">Stressed</option>
          <option value="Angry">Angry</option>
          <option value="Sad">Sad</option>
          <option value="Bored">Bored</option>
          <option value="Hungry">Hungry</option>
          <option value="Happy">Happy</option>
          <option value="Celebration">Celebration</option>
          <option value="Loved">Loved</option>
        </select>
      </div>
      <div class="form-group">
        <label for="cuisine">Cuisine:</label>
        <select v-model="selectedCuisine" id="cuisine">
          <option value="Korean">Korean</option>
          <option value="Thai">Thai</option>
          <option value="Vietnamese">Vietnamese</option>
          <option value="Japanese">Japanese</option>
          <option value="Indonesian">Indonesian</option>
          <option value="Colombian">Colombian</option>
          <option value="Turkish">Turkish</option>
        </select>
      </div>
      <button @click="goToProfile">Go to profile</button>
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        selectedMood: '',
        selectedCuisine: ''
      };
    },
    methods: {
      goToProfile() {
        this.$router.push('/userDashboard');
      }
    }
  };
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
  