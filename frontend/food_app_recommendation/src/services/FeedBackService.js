import http from "../http-common.js";

class FeedBackService {
    saveFeedback(data) {
        return http.post("/FeedBack", data);
    }
}
export default new FeedBackService();