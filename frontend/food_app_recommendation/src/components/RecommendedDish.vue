<template>
    <div class="dish-recommended">
      <div class="dish-image">
        <img :src="dish.imageUrl" alt="Dish Image" />
      </div>
      <div class="dish-details">
        <h2>{{ dish.name }}</h2>
        <div>
          <h3>Description:</h3>
          <p>{{ dish.description }}</p>
        </div>
        <div>
          <h3>Ingredients:</h3>
          <p>{{ dish.ingredients }}</p>
        </div>
        <div>
          <h3>Instructions:</h3>
          <p>{{ dish.instructions }}</p>
        </div>
        <button class="add-to-favorites-btn">Add to favorites</button>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        dish: {
          imageUrl: 'https://img.hellofresh.com/c_fit,f_auto,fl_lossy,h_500,q_50,w_1900/hellofresh_s3/image/HF_Y24_R07_W08_ES_ESQFC18619-2_edit_zuccini_Main_R_high-137f2c4e.jpg',
          name: 'Name of the dish', // Get name here
          description: '', // Get description here
          ingredients: '', // Get ingredients here
          instructions: '' // Get instructions from backend
        }
      };
    }
  };
  </script>
  
  <style scoped>
  .dish-recommended {
    display: flex;
    justify-content: space-between;
    align-items: flex-start;
    margin-bottom: 20px;
  }
  
  .dish-image img {
    height: 100vh; /* Ocupa todo el alto de la pantalla */
    width: 45vw; /* Ancho automático */
  }
  
  .dish-details {
    flex: 1;
    padding: 20px;
  }
  
  h2 {
    margin-top: 0;
  }
  
  button.add-to-favorites-btn {
    background-color: #ff0000; /* Rojo */
    color: #fff;
    padding: 10px 20px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
  }
  
  button.add-to-favorites-btn:hover {
    background-color: #cc0000; /* Rojo oscuro al pasar el ratón */
  }
  </style>
  