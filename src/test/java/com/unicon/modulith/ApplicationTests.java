package com.unicon.modulith;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.modulith.core.ApplicationModules;

@SpringBootTest
class ApplicationTests {


  @Test
  void getModules() {
    ApplicationModules modules = ApplicationModules.of(Application.class);
    System.out.println(modules);

    assertDoesNotThrow(modules::verify);
  }

}
