package com.categories.collab.service.impl;

import com.categories.collab.domain.Message;
import com.categories.collab.repositories.MessageRepository;
import com.categories.collab.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageRepository messageRepository;

    @Override
    public Iterable<Message> listAllMessagesOrderByDate() {
        return messageRepository.findAllByOrderByCreateDateDesc();
    }

    @Override
    public Iterable<Message> listUserMessages(String username) {
        return messageRepository.findAllByUsernameOrderByCreateDate(username);
    }

    @Override
    public Iterable<Message> getMessageList() {
        return messageRepository.findAll();
    }

    @Override
    public Message getMessageById(Integer id) {
        return messageRepository.findOne(id);
    }

    @Override
    public Message saveMessage(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public Iterable<Message> saveMessageList(Iterable<Message> categories) {
        return messageRepository.save(categories);
    }

    @Override
    public void deleteMessage(Integer id) {
        messageRepository.delete(id);
    }
}
