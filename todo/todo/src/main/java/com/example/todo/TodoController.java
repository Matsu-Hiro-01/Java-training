package com.example.todo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/todos")
@CrossOrigin
public class TodoController {
    private final List<Todo> todoList = new ArrayList<>();


    public TodoController () {
        todoList.add(new Todo(1,"買い出し", false));
        todoList.add(new Todo(2,"部屋の掃除", false));
    }
    //全件取得市表示
    @GetMapping
    public List<Todo> getAllTodo() {
        return todoList;
    }
    //新規追加（POST http://localhost:8080/api/todos）
    @PostMapping
    public Todo addTodo(@RequestBody Todo newTodo) {
        todoList.add(newTodo);
        return newTodo;
    }

    // 3. 削除（DELETE http://localhost:8080/todos/1 などのURLでアクセスする）
    // URLの末尾についたID（例: /todos/1）を {id} で受け取ります
    @DeleteMapping("/{id}")
    public String DeleteTodo(@PathVariable long id) {
        // リストの中から、送られてきたIDと一致するTodoを探して削除する（Javaのロジック）
        todoList.removeIf(todo -> todo.getId() == id);
        return "削除しました";
    }
    // 完了・未完了の状態を切り替えます
    @PutMapping("/{id}")
    public Todo toggleTodoComplete(@PathVariable long id) {
        for (Todo todo : todoList) {
            if (todo.getId() == id) {
                if (todo.isComplete() == false) {
                    todo.setComplete(true);
                } else {
                    todo.setComplete(false);
                }
                return todo;
            }
        }
        // もしIDが一致するTodoが見つからなかった場合は、何も返さない（null）
        return null;
    }
}
