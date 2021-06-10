package com.hyapp.bizapi.controller;

@RestController
@Scope("singleton")
@RequestMapping(value = "/sample")
public class SampleController {

  @Autowired
  private SampleService sampleService;

  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<String> changeSettings(@RequestParam("name") String name, @RequestParam("locale") String locale) {
    System.out.println(String.format("From [%s], Data is [%s].", locale, name));
    System.out.println(String.format("Before[%s]:%s", locale, this.sampleService.getName()));

    this.sampleService.setName(name);

    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println(String.format("After[%s]:%s", locale, this.sampleService.getName()));

    return new ResponseEntity<String>(HttpStatus.OK);
  }


}
