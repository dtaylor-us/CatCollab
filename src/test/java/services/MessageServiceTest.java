package services;

import com.categories.collab.Application;
import com.categories.collab.common.Utils;
import com.categories.collab.domain.Message;
import com.categories.collab.service.MessageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class})
@WebAppConfiguration

public class MessageServiceTest {

    @Autowired
    private MessageService messageService;

    @Test
    public void testSave() {
        Message message = new Message("Title", "Descripting");

        assertNull(message.getId());
        messageService.saveMessage(message);
        assertNotNull(message.getId());

        Message foundMessage = messageService.getMessageById(message.getId());
        assertEquals(message.getId(), foundMessage.getId());

        foundMessage.setSubject("Updated Title");
        messageService.saveMessage(foundMessage);

        Message foundUpdatedMessage = messageService.getMessageById(foundMessage.getId());
        assertEquals(foundUpdatedMessage.getSubject(), "Updated Title");

        messageService.deleteMessage(message.getId());

    }

    @Test
    public void testSaveMessageList() {
        List<Message> messages = new ArrayList<>();

        messages.add(new Message("Test-Title1"));
        messages.add(new Message("Test-Title2"));

        messageService.saveMessageList(messages);
        List<Message> foundMessageList = Utils.iterableToList(messageService.getMessageList());

        boolean result = foundMessageList.size() > 0;
        assertEquals(result, true);

    }

    @Test
    public void testDeleteMessage() {
        Message message = new Message();
        messageService.saveMessage(message);

        assertEquals(true, messageService.getMessageById(message.getId()) != null);

        messageService.deleteMessage(message.getId());
        assertNull(messageService.getMessageById(message.getId()));
    }}
