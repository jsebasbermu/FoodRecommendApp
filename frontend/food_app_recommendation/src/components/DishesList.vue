<template>
    <div class="dish-list">
        <h1>Recommended List of Dishes</h1>
        <p>Here's a recommended list of dishes for you!</p>
        <div class="test-table">
            <table>
                <thead>
                    <tr>
                        <th>Image</th>
                        <th>Dish</th>
                        <th>Description</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="dish in dishes" :key="dish.dishId">
                        <td>{{ dish.dishName }}</td>
                        <td>{{ dish.description }}</td>
                        <td>
                            <button @click="goToShowDetails(dish.dishId)">See recipe</button>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
        <br>
    </div>
</template>

<script>
import DishListService from '@/services/DishListService';

export default {
    name: 'dishesList',
    data() {
        return {
            dishes: [],
        };
    },
    methods: {
        getDishes() {
            const moodId = this.$route.params.moodId;
            const cuisineId = this.$route.params.cuisineId;

            DishListService.getDishesByMoodAndCuisine(moodId, cuisineId)
                .then(response => {
                    this.dishes = response.data;
                    console.log("Fetched dishes:", this.dishes);
                })
                .catch(error => {
                    console.error("Error fetching dishes:", error);
                });
        },
        goToShowDetails(dishId) {
            this.$router.push({
                name: 'recommendedDish',
                params: { selectedDish: dishId.toString() }
            });
        }
    },
    mounted() {
        this.getDishes();
    }
};
</script>

<style scoped>
.dish-list {
    font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
    padding-top: 2%;
    padding-left: 20%;
    padding-right: 20%;
}

/* button group style */
.button-group {
    display: flex;
    justify-content: left;
}

.dish-image img {
    height: 30vh;
    margin: 20px;
}

.list {
    display: flex;
}

button {
    background-color: #007bff;
    color: #fff;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    width: 20vh;
}
</style>