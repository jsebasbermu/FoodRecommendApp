<template>
    <div class="user-registration">
      <h2>User Registration</h2>
      <form @submit.prevent="submitForm">
        <div class="form-group">
          <label for="username">Username</label>
          <input type="text" id="username" v-model="username" required>
        </div>
        <div class="form-group">
          <label for="password">Password</label>
          <input type="password" id="password" v-model="password" required>
        </div>
        <button type="submit">Sign In</button>
      </form>
      <p>Already have an account? <a href="#" @click="goToLogin">Click to login</a></p>
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        username: '',
        password: ''
      };
    },
    methods: {
      submitForm() {
        console.log('Username:', this.username);
        console.log('Password:', this.password);
      },
      goToLogin() {
        this.$router.push('/login');
      }
    }
  };
  </script>
  
  <style scoped>
  .user-registration {
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
  a {
    color: #007bff;
    text-decoration: none;
  }
  </style>
  