package com.example.babo.controller;


import com.example.babo.domain.ToDoList;
import com.example.babo.dto.checkboxDto;
import com.example.babo.repository.ToDoListRepository;
import com.example.babo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    @PutMapping("/todo/toggle/{id}")
    public ResponseEntity<String> todotoggle(@PathVariable Integer id, @RequestBody checkboxDto isChecked){
        this.toDoService.toggle(id, isChecked.getCompleted());
        return ResponseEntity.ok().body("Checkbox Modified successfully");
    }

    @PostMapping("/todo/create")
    public String todoCreate(@RequestParam String content){
        this.toDoService.create(content);
        return "redirect:/";
    }

    @DeleteMapping("/todo/delete/{id}")
    public ResponseEntity<String> todoDelete(@PathVariable Integer id){
        this.toDoService.delete(id);
        return ResponseEntity.ok().body("Deleted successfully");
    }

    @PutMapping("/todo/update/{id}")
    public ResponseEntity<String> todoUpdate(@RequestBody String content, @PathVariable Integer id){
        this.toDoService.update(id, content);
        return ResponseEntity.ok().body("Modified successfully");
    }
}