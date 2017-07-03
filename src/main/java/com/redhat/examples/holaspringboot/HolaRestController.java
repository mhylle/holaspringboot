package com.redhat.examples.holaspringboot;

import java.net.*;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@ConfigurationProperties(prefix = "helloapp")
public class HolaRestController
{
  
  private String saying;
  @RequestMapping(method = RequestMethod.GET, value = "/hola",
  produces = "text/plain")
  public String hola() throws UnknownHostException {
    String hostname = null;
    try {
      hostname = InetAddress.getLocalHost().getHostAddress();
    } catch (UnknownHostException e) {
      hostname = "Unknown host";
    }
    return saying + " " + hostname;
  }
  
  public String getSaying()
  {
    return saying;
  }
  
  public void setSaying(String saying)
  {
    this.saying = saying;
  }
}
