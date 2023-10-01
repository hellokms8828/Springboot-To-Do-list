package com.example.babo.controller;


import com.example.babo.domain.ToDoList;
import com.example.babo.repository.ToDoListRepository;
import com.example.babo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class DemoController {

    private final TodoService toDoService;
    @GetMapping("/")
//    @ResponseBody, string 반환 아니라서 없애도 됨
    public String todopage(Model model) {
        List<ToDoList> todoEntityList = this.toDoService.getList();
        model.addAttribute("todoEntityList", todoEntityList);
        return "todolist";
    }

}