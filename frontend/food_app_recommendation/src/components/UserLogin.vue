<template>
    <div>
        <h4>User Login</h4>
        <form action="userLoginForm">
            <div>
                <label for="userName">Username: </label>
                <input type="text" id="userName" v-model="userLoginRequest.userName"/>
            </div>
            <div>
                <label for="password">Password: </label>
                <input type="password" id="password" v-model="userLoginRequest.password"/>
            </div>
            <div>
                <button type="submit" @click="login">Login</button>
            </div>
        </form>
        <p>{{  message }}</p>
    </div>
</template>

<script>
import LoginService from "../services/LoginService";

export default {
    name: "userLogin",
    data() {
        return {
            userLoginRequest: {userName: "", password: ""},
            message: ""
        }
    },
    methods: {
        login() {
            LoginService.login(this.userLoginRequest)
                .then( response => {
                    let user = response.data;
                    console.log(user);
                })
                .catch(error => {
                    console.log(error.response.data);
                })
        }
    },
    mounted(){
        this.mesage = "";
    }
}

</script>

<style>
</style>