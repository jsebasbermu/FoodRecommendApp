<template>
    <div class="user-dashboard">
      <!-- Header Section -->
      <header class="header">
        <div class="company-logo">
          <img src="../assets/companylogo.png" alt="Company Logo">
        </div>
        <h2 class="app-name">MoodPlate</h2>
      </header>
  
      <!-- Main Content -->
      <div>
        <h1>Welcome to Your Dashboard, {{ userName }}</h1>
      </div>
      <div class="button-group">
        <router-link to="/moodCuisineSelection">
          <button>Get Recommendations</button>
        </router-link>
        <router-link to="/searchDishes">
          <button>Search</button>
        </router-link>
        <router-link to="/favoritefood">
          <button>Favorites</button>
        </router-link>
        <router-link to="/feedbackSubmission">
          <button>Feedback</button>
        </router-link>
        <router-link to="/" @click="logout">
          <button>Logout</button>
        </router-link>

      </div>
      <div>
  <div v-if="userPreferences.length === 0">
    <h2>You don't have any past activities.</h2>
  </div>
  <div v-else>
    <h2>Your past activities</h2>
    <table>
      <thead>
        <tr>
          <th>Dish</th>
          <th>Mood</th>
          <th>Cuisine</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="preference in userPreferences" :key="preference.userPreferencesId">
          <td>{{ preference.dish.dishName }}</td>
          <td>{{ preference.mood.moodName }}</td>
          <td>{{ preference.cuisine.cuisineName }}</td>
        </tr>
      </tbody>
    </table>
  </div>
</div>

    </div>
  </template>
  

<script>
import LoginService from '@/services/LoginService';
import UserPreferenceService from '@/services/UserPreferenceService';


export default {
    name: "UserDashboard",
    data() {
        return {
            userName: '',
            userPreferences: []
        };
    },
    methods: {
        getUserInfo() {
            let userId = localStorage.getItem('userId');
            if (userId) {
                // Make API call to fetch user details
                LoginService.getUserDetails(userId)
                    .then(response => {
                        // Extract user name from response data
                        this.userName = response.data.userName;
                        this.getUserPreferences(userId);
                    })
                    .catch(error => {
                        console.error('Error fetching user details:', error);
                    });
            } else {
                console.error('User ID not found in local storage');
            }
        },
        getUserPreferences(userId) {
            UserPreferenceService.getUserPreferencesByUserId(userId)
                .then(response => {
                    this.userPreferences = response.data;
                    console.log(response.data);
                })
                .catch(error => {
                    console.error('Error fetching user preferences:', error);
                });
        },
        logout(event) {
            event.preventDefault();
            // Remove student ID from localStorage
            localStorage.removeItem('userId');
        }
    },
    mounted() {
        this.getUserInfo();

    }
}

</script>

<style scoped>

.user-dashboard {
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

.user-dashboard h1 {
    font-size: 36px;
    font-weight: bold;
    color: #444444; /* Darker gray */
    margin-bottom: 20px; /* Add spacing below */
}

.button-group {
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
    margin-bottom: 20px; /* Add spacing below */
}

.button-group button {
    margin: 10px;
    padding: 10px 20px;
    border: none;
    border-radius: 5px;
    background-color: #ff0303; /* Primary color */
    color: #FFFFFF; /* White text */
    font-family: 'Inter', sans-serif;
    font-size: 16px;
    font-weight: 600; /* Bold */
    cursor: pointer;
    transition: background-color 0.3s ease;
}

.button-group button:hover {
    background-color: #D1D1D1; /* Lighter gray on hover */
}

.user-dashboard h2 {
    font-size: 24px;
    font-weight: bold;
    color: #444444; /* Darker gray */
    margin-top: 20px; /* Add spacing above */
    margin-bottom: 10px; /* Add spacing below */
}

table {
    width: 100%;
    border-collapse: collapse;
    border: 1px solid #D1D1D1; /* Light gray border */
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

</style>
