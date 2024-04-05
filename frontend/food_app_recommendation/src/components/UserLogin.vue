<template>
    <div class="user-login">
        <h2>User Login</h2>
        <form action="userLoginForm">
            <div class="form-group">
                <label for="userName">Username: </label>
                <input type="text" id="userName" v-model="userLoginRequest.userName"/>
            </div>
            <div class="form-group">
                <label for="password">Password: </label>
                <input type="password" id="password" v-model="userLoginRequest.passWord"/>
            </div>
            <div>
                <button type="submit" @click="login">Login</button>
            </div>
        </form>
        <p style="color: black;">{{ message }}</p>
        <p>Don't have an account? <router-link to="/userRegistration" class="signup-link">Click here to sign up</router-link></p>
    </div>
</template>

<script>
import LoginService from "../services/LoginService";

export default {
    name: "UserLogin",
    data() {
        return {
            userLoginRequest: {userName: "", passWord: ""},
            message: ""
        }
    },
    methods: {
        login(event) {
          event.preventDefault();
            LoginService.login(this.userLoginRequest)
                .then( response => {
                    let user = response.data;
                    console.log(user);
                    localStorage.setItem('userId', user.userId);
                    this.message = response.data;
                    this.$router.push({ name: "userDashboard" }); 
                })
                .catch(error => {
                    console.log(error.response.data);
                    this.message = error.response.data;
                })
        }
    },
    mounted(){
        this.message = "";
    }
}

</script>

<style scoped>
.user-login {
    background-color: #FFFFFF;
    padding: 20px;
    font-family: 'Inter', sans-serif;
}

h2 {
    font-weight: normal;
    font-size: 24px;
}

.form-group {
    margin-bottom: 15px;
}

label {
    font-weight: 200; /* Extra light */
    color: #444444; /* Darker gray */
}

input[type="text"],
input[type="password"] {
    width: calc(100% - 20px); /* Adjusting width for padding */
    padding: 10px;
    border: 1px solid #D1D1D1;
    border-radius: 8px;
    margin-top: 5px; /* Adjust margin-top */
    margin-bottom: 5px; /* Adjust margin-bottom */
}

button {
    background-color: #ff0303;
    color: #FFFFFF;
    border: none;
    padding: 10px 20px;
    border-radius: 8px;
    font-weight: 600; /* Semibold */
    cursor: pointer;
    transition: background-color 0.3s ease;
}

button:hover {
    background-color: #31BD2E;
}

.message {
    color: #333333; /* Darker gray */
    font-weight: 300; /* Regular */
}

p {
    font-weight: 100; /* Extra light */
    color: #555555; /* Darker gray */
}

.router-link-exact-active {
    color: #31BD2E;
}

.signup-link {
    color: #31BD2E;
    font-weight: 600; /* Semibold */
}
</style>
