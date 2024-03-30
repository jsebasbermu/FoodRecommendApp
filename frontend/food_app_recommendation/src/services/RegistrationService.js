import http from "../http-common.js";

class RegistrationService {
    register(data) {
        return http.post("/users", data);
    }
}
export default new RegistrationService();