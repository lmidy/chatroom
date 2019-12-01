package edu.udacity.java.nano;

import edu.udacity.java.nano.model.Message;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.ViewResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.containsString;


@RunWith(SpringRunner.class)
@WebMvcTest
public class loginJoinTests {

    @Autowired
    private MockMvc mockMVC;

    private Message message;

    @Test
    public void login() throws Exception {
        this.mockMVC.perform(get("/")).andDo(print()).andExpect(status().isOk())
                .andExpect(view().name("login"));
    }

    @Test
    public void guestJoin()throws Exception {
        this.mockMVC.perform(get("/index")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Chat Room")));
    }

    /*@Test
    public void logout() throws Exception {
        mockMVC.perform(get("http://localhost:8080/chat/joey"))
                .andDo(print())
                .andExpect(content().string(containsString("left the chat")));
    }

    @Test
    public void sendMessage() throws Exception {
        mockMVC.perform(
                post("http://localhost:8080/chat/joey")
                .param("username", "Joe")
                .param("message", "hello"))
                .andDo(print())
                .andExpect(content()
                        .string(containsString("<div class=\"message-content\">Joe wrote: hello</div>")));
    }*/
}
