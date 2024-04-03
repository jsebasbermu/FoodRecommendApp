<template>
    <div class="dish-list">

        <h1>Recommended List of Dishes</h1>
        <p>Here's a recommended list of dishes for you! </p>
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
                    <tr v-for="dish in dishList" :key="dish.dishId" :id="dish.dishId">

                        <td>{{ dish.dishName }}</td>
                        <td>{{ dish.description }}</td>
                        <td>
                            <button @click="goToShowDetails(dish.dishId)">See recipe</button>
                        </td>
                    </tr>
                    <tr v-for="dish in dishList2" :key="dish.dishId">

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

            moodId: 0,
            dishList: [],
            dishList2: [],
            selectedDish: "",

        };
    },

    methods: {
        getDishesFromMood() {
            const moodId = this.$route.params.moodId;

            DishListService.getDishesFromMood(moodId)
                .then(response => {
                    this.dishList = response.data;

                    console.log(this.dishList);
                })
                .catch(error => {
                    console.error("Error fetching dishes:", error);
                })
        },
        getDishesFromCuisin() {
            const cuisineId = this.$route.params.cuisineId;

            DishListService.getDishesFromCuisine(cuisineId)
                .then(response => {
                    this.dishList2 = response.data;
                    console.log(this.dishList2);
                })
                .catch(error => {
                    console.error("Error fetching dishes:", error);
                })


        },
        goToShowDetails(Dish) {
            this.$router.push({
                name: 'recommendedDish',
                params: {
                    selectedDish: Dish.toString()
                }
            });

        }

    },
    mounted() {

        const moodId = this.$route.params.moodId;
        const cuisineId = this.$route.params.cuisineId;


        this.getDishesFromMood();
        this.getDishesFromCuisin();
        console.log("Cuisine ID:", cuisineId);
        console.log("Mood ID:", moodId);

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