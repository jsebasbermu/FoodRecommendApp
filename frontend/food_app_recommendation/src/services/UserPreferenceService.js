import http from "../http-common.js";

class UserPreferenceService {
    getAllUserPreferences() {
        return http.get('/userpreferences');
    }

    getUserPreferencesByUserId(userId) {
        return http.get(`/users/${userId}/userPreferences`);
    }
}

export default new UserPreferenceService();