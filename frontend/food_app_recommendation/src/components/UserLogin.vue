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
        <p>Don't have an account? <router-link to="/userRegistration">Click here to sign up</router-link></p>
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
                    this.message = response.data;
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
  font-size: 16px;
}
input[type="text"],
input[type="password"] {
  width: 100%; 
  padding: 10px;
  font-size: 16px;
  box-sizing: border-box; 
}
button {
  padding: 10px 20px;
  font-size: 16px;
  background-color: #007bff;
  color: #fff;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}
button:hover {
  background-color: #0056b3;
}
router-link {
  color: #007bff;
  text-decoration: none;
}
</style>
