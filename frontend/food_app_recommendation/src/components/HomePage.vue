<template>
    <div class="landing-page">
      <div class="left-content">
        <header>
        <div class="container">
          <h1>Discover Delicious Dishes</h1>
          <p>Get personalized recommendations based on your mood and preferences</p>
        </div>
      </header>
  
      <main>
        <section class="features">
          <div class="container">
            <h2>Features</h2>
            <div class="feature">
              <img src="../assets/search.jpg" alt="Search Icon" height="100px">
              <h3>Search by Dish Name</h3>
              <p>Find your favorite dishes quickly and easily using our search function.</p>
            </div>
            <div class="feature">
              <img src="../assets/cuisine.jpg" alt="Cuisine Icon" height="100px">
              <h3>Explore by Cuisine</h3>
              <p>Discover a world of culinary delights with our wide range of cuisines to choose from.</p>
            </div>
            <div class="feature">
              <img src="../assets/mood.jpg" alt="Mood Icon" height="100px">
              <h3>Recommendations by Mood</h3>
              <p>Let us help you decide what to eat based on your current mood or craving.</p>
            </div>
          </div>
        </section>
      </main>
      </div>

      <div class="right-content">
        <user-login class="child-component"></user-login>
      </div>

      

<!--   
      <footer>
        <div class="container">
          <p>&copy; 2024 Food Recommendation App. All rights reserved.</p>
        </div>
      </footer> -->
    </div>
  </template>
  
  <script>
  import UserLogin from './UserLogin.vue';
  export default {
    name: "HomePage",
    components: {
      UserLogin
    }
  };
  </script>
  
  <style scoped>
  .landing-page {
    display: flex;
    font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
    background-color: #f0f2f0;
  }
  
  .left-content {
    flex: 1; /* Take up remaining space */
    padding-top: 5%;
    padding-left: 25%;
  }
  
  .right-content {
    padding-top: 12%;
    padding-right: 25%;
    width: 500px;
  }

  .child-component {
    box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1); /* Horizontal offset, Vertical offset, Blur radius, Spread radius, Color */
  }

  </style>