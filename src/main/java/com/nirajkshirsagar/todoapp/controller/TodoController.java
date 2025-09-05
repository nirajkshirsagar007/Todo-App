package com.nirajkshirsagar.todoapp.controller;

import com.nirajkshirsagar.todoapp.entity.TodoEntity;
import com.nirajkshirsagar.todoapp.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class TodoController {

    private final TodoRepository todoRepository;

    @GetMapping({"","/","/home"})
    public String showHomePage(Model model)
    {

        model.addAttribute("todos",todoRepository.findAll());
        return "index";
    }
    @PostMapping("/add")
    public String add(@RequestParam String title)
    {
        TodoEntity newTodo = TodoEntity.builder()
                .title(title)
                .completed(false)
                .build();
        todoRepository.save(newTodo);
        return "redirect:/";
    }
}
