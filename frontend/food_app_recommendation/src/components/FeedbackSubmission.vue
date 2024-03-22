<template>
    <div>
        <h1>Feedback Survey</h1>
    </div>
    <div>

        <label for="food-list">Please choose the food you want to comment from below</label>
        <br><br>

        <select name="food" id="food-list">
            <option value="">{{ }}</option>
            <option value="">{{ }}</option>
            <option value="">{{ }}</option>
            <option value="">{{ }}</option>
            <option value="">{{ }}</option>
        </select>
        <br><br>
        <label for="feedback1">Overall how much did you like our recommendation ?</label>
        <br><br>
        <form id="feedback1">
            <div class="radio-group">
                <label for="rating1">1
                    <input type="radio" id="rating1" name="rating" value="1">
                </label>
                <label for="rating2">2
                    <input type="radio" id="rating2" name="rating" value="2">
                </label>
                <label for="rating3">3
                    <input type="radio" id="rating3" name="rating" value="3">
                </label>
                <label for="rating4">4
                    <input type="radio" id="rating3" name="rating" value="3">
                </label>
                <label for="rating5">5
                    <input type="radio" id="rating3" name="rating" value="3">
                </label>

            </div>
        </form>
        <br><br>
        <label for="feedback2">Did the food we recommended improve your mood ?</label>
        <br><br>
        <form id="feedback2">
            <div class="radio-group">
                <label for="rating1">1
                    <input type="radio" id="rating1" name="rating" value="1">
                </label>
                <label for="rating2">2
                    <input type="radio" id="rating2" name="rating" value="2">
                </label>
                <label for="rating3">3
                    <input type="radio" id="rating3" name="rating" value="3">
                </label>
                <label for="rating4">4
                    <input type="radio" id="rating3" name="rating" value="3">
                </label>
                <label for="rating5">5
                    <input type="radio" id="rating3" name="rating" value="3">
                </label>

            </div>
        </form>
        <br><br>
        <label for="feedback3">How well did the food we recommended suit your mood ?</label>
        <br><br>
        <form id="feedback3">
            <div class="radio-group">
                <label for="rating1">1
                    <input type="radio" id="rating1" name="rating" value="1">
                </label>
                <label for="rating2">2
                    <input type="radio" id="rating2" name="rating" value="2">
                </label>
                <label for="rating3">3
                    <input type="radio" id="rating3" name="rating" value="3">
                </label>
                <label for="rating4">4
                    <input type="radio" id="rating3" name="rating" value="3">
                </label>
                <label for="rating5">5
                    <input type="radio" id="rating3" name="rating" value="3">
                </label>

            </div>
        </form>
        <br><br>
        <label for="feedback4">Will you recommend our website to you friends ?</label>
        <br><br>
        <form id="feedback4">
            <div class="radio-group">
                <label for="rating1">1
                    <input type="radio" id="rating1" name="rating" value="1">
                </label>
                <label for="rating2">2
                    <input type="radio" id="rOverall how much do you like our recommendationating2" name="rating"
                        value="2">
                </label>
                <label for="rating3">3
                    <input type="radio" id="rating3" name="rating" value="3">
                </label>
                <label for="rating4">4
                    <input type="radio" id="rating3" name="rating" value="3">
                </label>
                <label for="rating5">5
                    <input type="radio" id="rating3" name="rating" value="3">
                </label>

            </div>


        </form>

        <form id="commentBox">
            <label for="commentBox">Please write your thoughts below</label> <br>
            <textarea id="commentBox" name="comment" rows="5" cols="50" placeholder="Write your thoughts here">

        </textarea>
        </form>

    </div>
    <br><br>

    <div>
        <button type="submit">Submit</button>
    </div>
</template>

<script>

</script>

<style></style>