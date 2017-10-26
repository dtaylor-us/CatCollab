package com.categories.collab.api;

import com.categories.collab.domain.Message;
import com.categories.collab.service.MessageService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/messages")
public class MessageAPI {
    Logger logger = Logger.getLogger(MessageAPI.class);

    @Autowired
    private MessageService messageService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Iterable<Message> getAll() {
        return messageService.getMessageList();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Message getById(@PathVariable int id) {
        return messageService.getMessageById(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Message save(@RequestBody Message message) {
        System.out.println(message.getId());
        logger.info(message);
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
