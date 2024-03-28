import http from "../http-common.js";

class LoginService {
    login(data) {
        return http.post("/login", data);
    }
    getUserDetails(userId) {
        return http.get(`/users/${userId}`);
    }
}

export default new LoginService();