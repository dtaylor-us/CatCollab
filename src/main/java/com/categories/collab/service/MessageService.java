package com.categories.collab.service;

import com.categories.collab.domain.Message;
import org.springframework.stereotype.Service;

@Service
public interface MessageService {

    Iterable<Message> getMessageList();

    Message getMessageById(Integer id);

    Message saveMessage(Message message);

    Iterable<Message> saveMessageList(Iterable<Message> messages);

    void deleteMessage(Integer id);

}
