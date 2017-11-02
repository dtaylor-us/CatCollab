//package repositories;
//
//import com.categories.collab.common.Utils;
//import com.categories.collab.configuration.RepositoryConfiguration;
//import com.categories.collab.domain.User;
//import com.categories.collab.repositories.UserRepository;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.SpringApplicationConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import java.util.List;
//
//import static org.junit.Assert.*;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = {RepositoryConfiguration.class})
//public class UserRepositoryTest {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Test
//    public void testSave() {
//        User user = new User();
//
//        user.setUsername("user");
//        user.setPassword("password");
//        user.
//
//
//        assertNull(user.getId());
//        userRepository.save(user);
//        assertNotNull(user.getId());
//
//        User foundUser = userRepository.findOne(user.getId());
//        assertEquals(user.getId(), foundUser.getId());
//
//        foundUser.setTitle("Updated Title");
//        userRepository.save(foundUser);
//
//        User foundUpdatedUser = userRepository.findOne(foundUser.getId());
//        assertEquals(foundUpdatedUser.getTitle(), "Updated Title");
//
//        userRepository.delete(user.getId());
//
//    }
//
//    @Test
//    public void testFindByTitle() {
//        User user = new User();
//
//        String title = String.valueOf(user.getId());
//        user.setTitle(title);
//
//        userRepository.save(user);
//        List<User> foundUser = userRepository.findByTitle(title);
//
//        boolean result = foundUser.stream().anyMatch(cat -> cat.getTitle().equals(title));
//        assertEquals(result, true);
//
//        //cleanup
//        userRepository.delete(user.getId());
//    }
//
//    @Test
//    public void testDeleteUser() {
//        User user = new User();
//        userRepository.save(user);
//
//        assertEquals(true, userRepository.findOne(user.getId()) != null);
//
//        userRepository.delete(user);
//        assertNull(userRepository.findOne(user.getId()));
//    }
//}
