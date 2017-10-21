package com.categories.collab.api;

import com.categories.collab.domain.Message;
import com.categories.collab.service.MessageService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/messages")
public class MessageAPI {
    Logger logger = Logger.getLogger(MessageAPI.class);

    @Autowired
    private MessageService messageService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Iterable<Message> getAll() {
        return messageService.listAllMessagesOrderByDate();
    }

    @RequestMapping(value = "/user/{username}", method = RequestMethod.GET)
    public Iterable<Message> getAllByUser(@PathVariable String username) {
        return messageService.listUserMessages(username);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Message getById(@PathVariable int id) {
        return messageService.getMessageById(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Message save(@ModelAttribute("message") Message message) {
        return messageService.saveMessage(message);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Boolean delete(@PathVariable int id) {
        try {
            messageService.deleteMessage(id);
            return true;
        } catch (Exception ex) {
            logger.info(ex);
            return false;
        }
    }
}
