package com.Metron.DetectionAPI;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DetectionApiApplicationTests {

	@Test
	void contextLoads() {
	}
    @Test
    void Check(){
        int result = 3+2;
        Assertions.assertEquals(5, result);
    }
}
