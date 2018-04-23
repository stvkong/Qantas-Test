package au.com.kong.ms.sample;

/**
 * @author Stephen Kong 
 * version 1.0
 * date    22/04/2018
 */
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.google.gson.Gson;

import au.com.kong.ms.sample.controller.utils.TmpDataStore;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SampleControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getRootUrlJsonTest() throws Exception {
    	String jsonStr = new Gson().toJson(TmpDataStore.getInstance().getNode());
        mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo(jsonStr)));
    }
    
    @Test
    public void getLevelOneUrlJsonTest() throws Exception {
    	String jsonStr = new Gson().toJson(TmpDataStore.getInstance().getNodeByUrl("http://localhost/level1"));
        mvc.perform(MockMvcRequestBuilders.get("/level1").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo(jsonStr)));
    }
    
    @Test
    public void getWrongUrlJsonTest() throws Exception {
    	mvc.perform(MockMvcRequestBuilders.get("/level").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}
