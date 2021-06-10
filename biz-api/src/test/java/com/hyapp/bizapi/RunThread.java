package com.hyapp.bizapi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(SpringJUnit4ClassRunner.class)
@Data
@AllArgsConstructor
public class RunThread extends Thread {


  private final String val;
  private final String locale;
  private final MockMvc mockMvc;

  @Override
  public void run() {
    String responseContent = null;
    try {
      responseContent =
        this.mockMvc.perform(get(String.format("/sample?name=%s&locale=%s", this.val, this.locale)))
          .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
    }

    System.out.println(responseContent);
  }

}