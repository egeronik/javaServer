package com.example.taskproject;

import com.example.taskproject.dataManagment.Task;
import com.example.taskproject.dataManagment.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(path = "/demo")
public class MainController {

    @Autowired
    private TaskRepository taskRepository;

    @PostMapping(path = "/add")
    public @ResponseBody
    Task addNewUser( @RequestBody Task task) {
//        System.out.println("Text:"+text+"Im:"+importance+"ch:"+checked);
//        Task n = new Task();
//        n.setText(text);
//        n.setImportance(importance);
//        n.setChecked(checked);
        System.out.println(task.toString());
        taskRepository.save(task);
        return task;
    }



    @GetMapping
    public Task empty(){
        return null;
    }

    @GetMapping("/all")
    public @ResponseBody
    Iterable<Task> getAllUsers() {
        return taskRepository.findAll();
    }

    @GetMapping("{id}")
    public @ResponseBody Task getTaskById(@PathVariable Integer id){
        return taskRepository.findById(id).orElse(null);
    }


    @DeleteMapping("{id}")
    @ResponseBody
    public Task deleteTask(@PathVariable int id){
        if(taskRepository.existsById(id)){
            Task tmp = taskRepository.findById(id).orElse(null);
            taskRepository.deleteById(id);
            return tmp;
        }else
            return null;
    }
}