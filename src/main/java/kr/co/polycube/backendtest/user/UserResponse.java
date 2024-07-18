package kr.co.polycube.backendtest.user;

import lombok.Data;

public class UserResponse {
    @Data
    public static class SaveDTO {
        private Long id;

        public SaveDTO(User userET) {
            this.id = userET.getId();
        }
    }
}
