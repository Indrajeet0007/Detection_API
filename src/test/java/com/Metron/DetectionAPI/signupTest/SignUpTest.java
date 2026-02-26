package com.Metron.DetectionAPI.signupTest;
import com.Metron.DetectionAPI.enities.UserTable;
import com.Metron.DetectionAPI.service.UserTableDetailService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SignUpTest {
    @Test
    void contextLoads() {
    }
    @Test
    void getSignUp(){
        UserTable userTable = new UserTable();
        userTable.setUserName("indrajeet");
        userTable.setPassword("Indrajeet@99");
       Assertions.assertEquals(new UserTableDetailService().insert(userTable),userTable);
    }

}
