<template>
    <div>
        <h1>Welcome to Your Dashboard, {{ username }}</h1>

    </div>
</template>

<script>
export default {
    name: "UserDashboard",
    data(){
        return {
            username: ''
        }
    },
    mounted(){
        this.username = "Robot123"
    }
}

</script>

<style>

</style>