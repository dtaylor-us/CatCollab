package com.categories.collab.repositories;

import com.categories.collab.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Integer> {


    List<Message> findAllByOrderByCreateDateDesc();

    List<Message> findAllByUsernameOrderByCreateDate(String username);

}
