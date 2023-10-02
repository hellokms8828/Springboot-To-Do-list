package com.example.babo.service;

import com.example.babo.domain.ToDoList;
import com.example.babo.repository.ToDoListRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.stereotype.Service;
import java.util.List;

@RequiredArgsConstructor
@Service
public class TodoService {
    private final ToDoListRepository toDoRepository;

    public List<ToDoList> getList(){
        return this.toDoRepository.findAll();
    }

    public void create(String content){
        ToDoList newtodo = new ToDoList();
        newtodo.setContent(content);
        newtodo.setCompleted(false);
        this.toDoRepository.save(newtodo);
    }

    public void delete(Integer id){
        ToDoList todo = toDoRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 아이템이 없습니다. id=" + id));

        this.toDoRepository.delete(todo);
    }

    @Transactional
    public void update(Integer id, String content){
        ToDoList todo = toDoRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 아이템이 없습니다. id=" + id));

        todo.setContent(content);
        this.toDoRepository.save(todo);
    }

    @Transactional
    public void toggle(Integer id, Boolean ischecked){
        ToDoList todo = toDoRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 아이템이 없습니다. id=" + id));

        todo.setCompleted(ischecked);
        this.toDoRepository.save(todo);
    }
}