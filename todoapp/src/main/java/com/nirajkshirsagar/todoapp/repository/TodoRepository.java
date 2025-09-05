package com.nirajkshirsagar.todoapp.repository;

import com.nirajkshirsagar.todoapp.entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<TodoEntity, Long> {
}
