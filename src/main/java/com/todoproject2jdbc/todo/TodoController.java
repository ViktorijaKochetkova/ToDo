package com.todoproject2jdbc.todo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class TodoController {
    private final TodoRepository todoRepository = new TodoRepository();
    @GetMapping("/todo-app")
    public String showTodoPage(Model model){
        model.addAttribute("todoList",this.getTodosFromDatabase());

    return "todo-page";
    }
    @PostMapping("/todo-app")
    public String addNewTodoItem(Todo todo){
            this.addTodoToDatabase(todo);
            //do something with DB
            return "redirect:todo-app";
    }

    @GetMapping("/todo-app/delete/{todoId}")
    public String deleteTodoItem(@PathVariable(name = "todoId") int todoId){
        this.todoRepository.deleteTodoItem(todoId);
        return "redirect:/todo-app?message=todo_deleted";
    }
    @GetMapping("/todo-app/update/{todoId}")
    public String updateTodoItem(@PathVariable (name = "todoId") int todoId){
        this.todoRepository.updateTodoStatus(todoId);
        return "redirect:/todo-app?message=todo_updated";
    }

    private boolean isTodoInfoPresent(String description, String status){
        return description != null
                && status != null
                && !status.isBlank()
                && !description.isBlank();
    }
    private ArrayList<Todo> getTodosFromDatabase() {
        return this.todoRepository.finAllTodos();
    }
    private void addTodoToDatabase (Todo todo){
        //add todo to DB
        todoRepository.createTodo(todo);
        System.out.println(todo);

    }
}
