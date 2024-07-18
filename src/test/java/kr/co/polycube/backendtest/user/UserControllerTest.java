package kr.co.polycube.backendtest.user;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@Transactional
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class UserControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private UserRepository userRepository;

    private ObjectMapper om = new ObjectMapper();

    @Test
    public void saveUser_test() throws Exception {
        // given
        String name = "ssar";
        UserRequest.SaveDTO reqDTO = new UserRequest.SaveDTO();
        reqDTO.setName(name);

        String reqBody = om.writeValueAsString(reqDTO);
        //System.out.println(reqBody);

        // when
        ResultActions actions = mvc.perform(
                post("/users")
                        .content(reqBody)
                        .contentType(MediaType.APPLICATION_JSON));
        String respBody = actions.andReturn().getResponse().getContentAsString();
        //System.out.println(respBody);


        // then
        actions.andExpect(jsonPath("$.id").value(1));
    }

    @Test
    public void saveUser_fail_test() throws Exception {
        // given
        String name = "ssar";
        userRepository.save(User.builder().name(name).build());

        UserRequest.SaveDTO reqDTO = new UserRequest.SaveDTO();
        reqDTO.setName(name);

        String reqBody = om.writeValueAsString(reqDTO);
        //System.out.println(reqBody);

        // when
        ResultActions actions = mvc.perform(
                post("/users")
                        .content(reqBody)
                        .contentType(MediaType.APPLICATION_JSON));
        String respBody = actions.andReturn().getResponse().getContentAsString();
        //System.out.println(respBody);


        // then
        actions.andExpect(jsonPath("$.reason").value("중복된 유저네임 입니다 : "+name));
    }
}
