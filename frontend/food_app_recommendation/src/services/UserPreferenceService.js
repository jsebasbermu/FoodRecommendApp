import http from "../http-common.js";

class UserPreferenceService {
    getAllUserPreferences() {
        return http.get('/userpreferences');
    }

    getUserPreferencesByUserId(userId) {
        return http.get(`/users/${userId}/userPreferences`);
    }

    saveUserPreference(userPreferenceData) {
        return http.post('/userpreferences', userPreferenceData);
    }
    
}

export default new UserPreferenceService();