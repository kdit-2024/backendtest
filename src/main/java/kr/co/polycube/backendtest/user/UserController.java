package kr.co.polycube.backendtest.user;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    @PostMapping("/users")
    public ResponseEntity<?> saveUser(@Valid @RequestBody UserRequest.SaveDTO reqDTO, Errors errors){
        UserResponse.SaveDTO respDTO = userService.saveUser(reqDTO);
        return ResponseEntity.ok(respDTO);
    }
}
