package com.example.babo;

import com.example.babo.domain.ToDoList;
import com.example.babo.repository.ToDoListRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
class BaboApplicationTests {
	@Autowired
	private ToDoListRepository toDoListRepository;

	@Test
	void testJpa() {
		ToDoList todo1 = new ToDoList();
		todo1.setContent("스프링 공부하기");
		todo1.setCompleted(Boolean.TRUE);
		this.toDoListRepository.save(todo1);

		ToDoList todo2 = new ToDoList();
		todo2.setContent("세수하기");
		todo2.setCompleted(Boolean.TRUE);
		this.toDoListRepository.save(todo2);
	}
}
