package com.hyapp.bizapi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringApplicationConfiguration(classes = Application.class)
public class SampleControllerTest {
  private MockMvc mockMvc;

  @Autowired
  private WebApplicationContext context;


  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
    this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
  }



  @Test
  public void sample() throws UnsupportedEncodingException, Exception {
    RunThread thread1 = new RunThread("hoge", "1st", this.mockMvc);
    RunThread thread2 = new RunThread("moge", "2nd", this.mockMvc);

    thread1.start();
    thread2.start();

    Thread.sleep(3050);

  }

}