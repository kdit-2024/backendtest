package kr.co.polycube.backendtest.user;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

public class UserRequest {

    @Data
    public static class SaveDTO {
        @NotEmpty
        private String name;

        public User toEntity(){
            return User.builder().name(name).build();
        }
    }

}
