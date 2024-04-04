<template>
    <div class="user-dashboard">
        <div>
            <h1>Welcome to Your Dashboard, {{ userName }}</h1>
        </div>
        <div class="button-group">
            <router-link to="/moodCuisineSelection">
                <button>Get Recommendations</button>
            </router-link>
            <button>View Records</button>
            <router-link to="/favoritefood">
                <button>Favorites</button>
            </router-link>
            
            <button>Search Dishes</button>

            <router-link to="/" @click="logout">
                <button>Logout</button>
            </router-link>
            <router-link to="/feedbackSubmission">
                <button>Feedback</button>
            </router-link>

        </div>
        <div>
            <h2>Your past activities</h2>
            <!-- <ul>
                <li v-for="preference in userPreferences" :key="preference.userPreferencesId">
                    Dish: {{ preference.dish.dishName }}, Mood: {{ preference.mood.moodName }}, Cuisine: {{ preference.cuisine.cuisineName }}
                </li>
            </ul> -->
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

<style>
.user-dashboard {
    font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
    padding-top: 2%;
    padding-left: 20%;
    padding-right: 20%;
}

/* table style */
table {
    width: 100%;
    border-collapse: collapse;
    margin-bottom: 20px;
    /* Optional: Adjust spacing */
}

th,
td {
    border: 1px solid #dddddd;
    padding: 8px;
    text-align: left;
}

th {
    background-color: #f2f2f2;
    font-weight: bold;
}

tr:nth-child(even) {
    background-color: #f9f9f9;
}

tr:hover {
    background-color: #f2f2f2;
}

/* button group style */
.button-group {
    display: flex;
    justify-content: left;
}

.button-group button {
    margin: 0 5px;
    /* Adjust margin as needed */
    min-width: 150px;
    min-height: 30px;
    width: auto;
    height: auto;
}
</style>