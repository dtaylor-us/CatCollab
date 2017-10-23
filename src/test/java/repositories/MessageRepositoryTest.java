package repositories;

import com.categories.collab.common.Utils;
import com.categories.collab.configuration.RepositoryConfiguration;
import com.categories.collab.domain.Message;
import com.categories.collab.repositories.MessageRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {RepositoryConfiguration.class})
public class MessageRepositoryTest {

    @Autowired
    private MessageRepository messageRepository;

    @Test
    public void testSave() {
        Message message = new Message("Title", "Descripting");

        assertNull(message.getId());
        messageRepository.save(message);
        assertNotNull(message.getId());

        Message foundMessage = messageRepository.findOne(message.getId());
        assertEquals(message.getId(), foundMessage.getId());

        foundMessage.setSubject("Updated Title");
        messageRepository.save(foundMessage);

        Message foundUpdatedMessage = messageRepository.findOne(foundMessage.getId());
        assertEquals(foundUpdatedMessage.getSubject(), "Updated Title");

        messageRepository.delete(message.getId());

    }

    @Test
    public void testSaveMessageList() {
        List<Message> categories = new ArrayList<>();

        categories.add(new Message("Test-Title1"));
        categories.add(new Message("Test-Title2"));

        messageRepository.save(categories);
        List<Message> foundMessageList = Utils.iterableToList(messageRepository.findAll());

        boolean result = foundMessageList.size() > 0;
        assertEquals(result, true);

    }

    @Test
    public void testDeleteMessage() {
        Message message = new Message();
        messageRepository.save(message);

        assertEquals(true, messageRepository.findOne(message.getId()) != null);

        messageRepository.delete(message);
        assertNull(messageRepository.findOne(message.getId()));
    }
}
