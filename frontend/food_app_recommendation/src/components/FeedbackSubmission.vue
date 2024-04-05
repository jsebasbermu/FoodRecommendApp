<template>
    <div class="feedback">
        <div>
            <h1>Feedback Survey</h1>
        </div>
        <div>

            <label for="food-list">Please choose the food you want to comment</label>
            <br><br>

            <select name="favoriteFood" id="food-list" v-model="feedbackUser.dish">
                <option v-for="dish in dishes" :key="dish.dishName" :value="dish.dishName">
                    {{ dish.dishName }}
                </option>

            </select>
            <br><br>
            <label for="feedback1">Overall how much did you like our recommendation ?</label>
            <br><br>
            <form id="feedback1">
                <div class="radio-group">
                    <label for="rating1">1
                        <input type="radio" id="rating1" name="rating" value="1" v-model="feedbackUser.feedback1">
                    </label>
                    <label for="rating2">2
                        <input type="radio" id="rating2" name="rating" value="2" v-model="feedbackUser.feedback1">
                    </label>
                    <label for="rating3">3
                        <input type="radio" id="rating3" name="rating" value="3" v-model="feedbackUser.feedback1">
                    </label>
                    <label for="rating4">4
                        <input type="radio" id="rating4" name="rating" value="4" v-model="feedbackUser.feedback1">
                    </label>
                    <label for="rating5">5
                        <input type="radio" id="rating5" name="rating" value="5" v-model="feedbackUser.feedback1">
                    </label>

                </div>
            </form>
            <br><br>
            <label for="feedback2">Did the food we recommended improve your mood ?</label>
            <br><br>
            <form id="feedback2">
                <div class="radio-group">
                    <label for="rating1">1
                        <input type="radio" id="rating1" name="rating" value="1" v-model="feedbackUser.feedback2">
                    </label>
                    <label for="rating2">2
                        <input type="radio" id="rating2" name="rating" value="2" v-model="feedbackUser.feedback2">
                    </label>
                    <label for="rating3">3
                        <input type="radio" id="rating3" name="rating" value="3" v-model="feedbackUser.feedback2">
                    </label>
                    <label for="rating4">4
                        <input type="radio" id="rating4" name="rating" value="4" v-model="feedbackUser.feedback2">
                    </label>
                    <label for="rating5">5
                        <input type="radio" id="rating5" name="rating" value="5" v-model="feedbackUser.feedback2">
                    </label>

                </div>
            </form>
            <br><br>
            <label for="feedback3">How well did the food we recommended suit your mood ?</label>
            <br><br>
            <form id="feedback3">
                <div class="radio-group">
                    <label for="rating1">1
                        <input type="radio" id="rating1" name="rating" value="1" v-model="feedbackUser.feedback3">
                    </label>
                    <label for="rating2">2
                        <input type="radio" id="rating2" name="rating" value="2" v-model="feedbackUser.feedback3">
                    </label>
                    <label for="rating3">3
                        <input type="radio" id="rating3" name="rating" value="3" v-model="feedbackUser.feedback3">
                    </label>
                    <label for="rating4">4
                        <input type="radio" id="rating4" name="rating" value="4" v-model="feedbackUser.feedback3">
                    </label>
                    <label for="rating5">5
                        <input type="radio" id="rating5" name="rating" value="5" v-model="feedbackUser.feedback3">
                    </label>

                </div>
            </form>
            <br><br>
            <label for="feedback4">Will you recommend our website to you friends ?</label>
            <br><br>
            <form id="feedback4">
                <div class="radio-group">
                    <label for="rating1">1
                        <input type="radio" id="rating1" name="rating" value="1" v-model="feedbackUser.feedback4">
                    </label>
                    <label for="rating2">2
                        <input type="radio" id="rating2" name="rating" value="2" v-model="feedbackUser.feedback4">
                    </label>
                    <label for="rating3">3
                        <input type="radio" id="rating3" name="rating" value="3" v-model="feedbackUser.feedback4">
                    </label>
                    <label for="rating4">4
                        <input type="radio" id="rating4" name="rating" value="4" v-model="feedbackUser.feedback4">
                    </label>
                    <label for="rating5">5
                        <input type="radio" id="rating5" name="rating" value="5" v-model="feedbackUser.feedback4">
                    </label>

                </div>


            </form>

            <form id="commentBox">
                <br><br>
                <label for="commentBox">Please write your thoughts below</label> <br>
                <textarea id="commentBox" name="comment" rows="5" cols="50" placeholder="Write your thoughts here"
                    v-model="feedbackUser.commentBox">
            </textarea>
            </form>

        </div>
        <br><br>

        <div>
            <button type="submit" @click="saveFeedback">Submit</button>
        </div>
    </div>
</template>

<script>
import FavoriteFoodService from "../services/FavoriteFoodService";
import FeedBackService from "../services/FeedBackService";
let user = localStorage.getItem('userId');
export default {
    name: "feedbackUser",

    data() {
        return {
            dishes: null,

            feedbackUser: {
                user, dish: null, feedback1: null, feedback2: null, feedback3: null, feedback4: null, commentBox: "",
            },
            message: ""


        };

    },
    methods: {

        saveFeedback(event) {
            event.preventDefault();

            FeedBackService.saveFeedback(this.feedbackUser)
                .then(response => {
                    let feedbackUser = response.data;
                    console.log(feedbackUser);

                    this.message = "Feedback saved!";

                })
                .catch(error => {
                    console.log(error.response.data);
                    this.message = error.response.data;
                })
        },

        allDishes() {

            FavoriteFoodService.getAllDishes()
                .then(response => {
                    this.dishes = response.data;
                    console.log(this.dishes);
                })
                .catch(error => {
                    console.log(error);
                })
        },


    },
    mounted() {

        this.allDishes();

    },

};

</script>

<style>
button {
    padding: 10px 20px;

    font-size: 16px;
    background-color: #007bff;
    color: #fff;
    border: none;
    border-radius: 5px;
    cursor: pointer;
}

label {
    display: block;
    font-weight: bold;
    font-size: 16px;
}

select {
    padding: 10px;
    font-size: 16px;
    border: 1px solid #ccc;
    border-radius: 5px;
    background-color: #fff;
    color: #333;
    width: 200px;
}

select option:hover {
    background-color: #f2f2f2;
}

.feedback {
    max-width: 500px;
    margin: 10px;
    padding: 20px;
    border-radius: 5px;
    background-color: white;
}
.radio-group {
    display: flex;
    align-items: center; 
    justify-content: start;
    gap: 25px; 
}
</style>