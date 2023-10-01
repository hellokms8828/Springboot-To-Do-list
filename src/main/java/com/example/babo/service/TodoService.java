package com.example.babo.service;

import com.example.babo.domain.ToDoList;
import com.example.babo.repository.ToDoListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@RequiredArgsConstructor
@Service
public class TodoService {
    private final ToDoListRepository toDoRepository;

    public List<ToDoList> getList(){
        return this.toDoRepository.findAll();
    }
}