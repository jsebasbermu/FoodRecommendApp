        <!-- <div>
            <h2>Past Preferences</h2>
            <table>
            <thead>
                <tr>
                <th>Preference ID</th>
                <th>User</th>
                <th>Mood</th>
                <th>Cuisine</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="preference in pastPreferences" :key="preference.userPreferencesId">
                <td>{{ preference.userPreferencesId }}</td>
                <td>{{ preference.user.name }}</td>
                <td>{{ preference.mood.name }}</td>
                <td>{{ preference.cuisine.name }}</td>
                </tr>
            </tbody>
            </table>
        </div> -->
<template>
    <div>
        <div> <h1>Welcome to Your Dashboard, {{ userName }}</h1></div>
        <div>
            <h2>User Preferences</h2>
            <ul>
                <li v-for="preference in userPreferences" :key="preference.userPreferencesId">
                    Mood: {{ preference.mood.moodName }}, Cuisine: {{ preference.cuisine.cuisineName }}
                </li>
            </ul>
        </div>

       

    </div>
</template>

<script>
import LoginService from '@/services/LoginService';
import UserPreferenceService from '@/services/UserPreferenceService';


export default {
    name: "UserDashboard",
    data(){
        return {
            userName: '',
            userPreferences: []
        };
    },
    methods:{
        getUserInfo(){
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
        }
    },
    mounted(){
        this.getUserInfo();
        
    }
}

</script>

<style>

</style>