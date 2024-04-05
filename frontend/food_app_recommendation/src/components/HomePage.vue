<template>
  <div class="landing-page">
    <!-- Header Section -->
    <header class="header">
      <div class="company-logo">
        <img src="../assets/companylogo.png" alt="Company Logo">
      </div>
      <h2 class="app-name">MoodPlate</h2>
    </header>

    <!-- Content Sections -->
    <div class="content">
      <!-- Left Content -->
      <div class="left-content">
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

      <!-- Right Content -->
      <div class="right-content">
        <user-login class="child-component"></user-login>
      </div>
    </div>
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
    flex-direction: column; /* Align items in a column */
    justify-content: center; /* Vertically center align */
    align-items: center; /* Horizontally center align */
    background-color: #F5F5F5; /* Light gray */
    padding: 20px;
    font-family: 'Inter', sans-serif;
}

.header {
    margin-bottom: 20px; /* Add spacing between the header and content */
    text-align: center; /* Align content center */
}

.company-logo img {
    max-width: 30%; /* Ensure the logo fits within the header */
    height: auto; /* Maintain aspect ratio */
}

.app-name {
    font-size: 24px; /* Adjust font size */
    margin-top: 10px; /* Add spacing between logo and app name */
}

.content {
    display: flex;
    justify-content: space-between;
    align-items: center; /* Vertically center align content */
    width: 100%; /* Ensure content spans full width */ 
}

.left-content {
    flex: 4; /* Equal width for both content sections */
}
.right-content {
  padding-right: 20%;
  flex: 2;
}

.container {
    max-width: 800px;
    margin: 0 auto;
    text-align: center;
}

.features {
    margin-top: 50px;
}

.features h2 {
    font-size: 24px;
    font-weight: bold;
    margin-bottom: 20px;
}

.feature {
    margin-bottom: 30px;
}

.feature img {
    margin-bottom: 10px;
}

.feature h3 {
    font-size: 20px;
    font-weight: bold;
    margin-bottom: 10px;
}

.feature p {
    font-size: 16px;
    color: #777777; /* Dark gray */
}

.child-component {
    border-radius: 10px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1); /* Adding shadow */
}
</style>
