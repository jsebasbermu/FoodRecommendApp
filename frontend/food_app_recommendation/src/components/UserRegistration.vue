<template>
  <div class="user-registration">
    <!-- Header Section -->
    <header class="header">
      <div class="company-logo">
        <img src="../assets/companylogo.png" alt="Company Logo">
      </div>
      <h2 class="app-name">MoodPlate</h2>
    </header>
    <!-- Back to Home Button -->
    <router-link to="/" class="btn-back">Back to Home</router-link>

    <!-- Registration Form -->
    <h2>User Registration</h2>
    <form @submit.prevent="submitForm">
      <div class="form-group">
        <label for="username">Username</label>
        <input type="text" id="username" v-model="userRegistrationRequest.userName" required>
      </div>
      <div class="form-group">
        <label for="password">Password</label>
        <input type="password" id="password" v-model="userRegistrationRequest.password" required>
      </div>
      <button type="submit" @click="register">Sign Up</button>
    </form>



    <!-- Login Link -->
    <p>Already have an account? <router-link to="/" class="login-link">Click to login</router-link></p>
  </div>
</template>

  
  <script>
  import RegistrationService from "../services/RegistrationService";
  export default {
    name: "UserRegistration",
    data() {
      return {
        userRegistrationRequest: {userName: "", password: ""},
        message: ""
      };
    },
    methods: {
      register(event) {
          console.log(this.userRegistrationRequest);
          event.preventDefault();
            RegistrationService.register(this.userRegistrationRequest)
                .then( response => {
                    let user = response.data;
                    console.log(user);
                    localStorage.setItem('userId', user.userId);
                    this.message = response.data;
                    this.$router.push({ name: "homePage" }); 
                })
                .catch(error => {
                    console.log(error.response.data);
                    this.message = error.response.data;
                })
        }
    }
  };
  </script>
  
  <style scoped>
.user-registration {
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

.user-registration h2 {
    font-size: 24px;
    font-weight: normal;
    color: #444444;
    margin-bottom: 20px;
}

.form-group {
    margin-bottom: 15px;
}

label {
    font-weight: 200;
    color: #444444;
}

input[type="text"],
input[type="password"] {
    width: calc(100% - 20px);
    padding: 10px;
    border: 1px solid #D1D1D1;
    border-radius: 8px;
    margin-top: 5px;
    margin-bottom: 5px;
}

button {
    background-color: #ff0303;
    color: #FFFFFF;
    border: none;
    padding: 10px 20px;
    border-radius: 8px;
    font-weight: 600;
    cursor: pointer;
    transition: background-color 0.3s ease;
}

button:hover {
    background-color: #D1D1D1;
}

p {
    font-weight: 100;
    color: #555555;
}

.login-link {
    color: #31BD2E;
    font-weight: 600;
}
</style>
