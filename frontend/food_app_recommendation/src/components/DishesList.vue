<template>
    <div class="dish-list">
        <div>
            <h1>Recommended List of dishes</h1>
        </div>
        <div class="list">
            <div class="dish-image">
                <img :src="dish.imageUrl" alt="Dish Image" />
            </div>
            <div>
                <h2>Dish Name: </h2>
                <div>
                    <p>Description:</p>
                </div>
                <router-link to="/RecommendedDish">
                    <button>See recipe</button>
                </router-link>
            </div>

        </div>




    </div>
</template>
<script>
export default {
    data() {
        return {
            dish: {
                imageUrl: 'https://img.hellofresh.com/c_fit,f_auto,fl_lossy,h_500,q_50,w_1900/hellofresh_s3/image/HF_Y24_R07_W08_ES_ESQFC18619-2_edit_zuccini_Main_R_high-137f2c4e.jpg',
                name: 'Name of the dish', // Get name here
                description: '', // Get description here

            }
        };
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