package bd.edu.seu.ecommerce;

import bd.edu.seu.ecommerce.model.User;
import bd.edu.seu.ecommerce.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MongoTester {

    @Autowired
    private UserService userService;

    @Test
    public void Test(){
        User user = new User();
        user.setEmail("demo123@gmail.com");
        user.setPassword("1234");
        user.setName("Demo123");
        userService.save(user);
    }
}
