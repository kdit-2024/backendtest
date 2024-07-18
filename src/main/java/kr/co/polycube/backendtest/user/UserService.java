package kr.co.polycube.backendtest.user;

import kr.co.polycube.backendtest.core.error.ex.Exception400;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public UserResponse.SaveDTO saveUser(UserRequest.SaveDTO reqDTO) {
        Optional<User> userOP = userRepository.findByName(reqDTO.getName());
        if(userOP.isPresent()){
            throw new Exception400("중복된 유저네임 입니다 : "+reqDTO.getName());
        }

        User userET = userRepository.save(reqDTO.toEntity());
        return new UserResponse.SaveDTO(userET);
    }
}
