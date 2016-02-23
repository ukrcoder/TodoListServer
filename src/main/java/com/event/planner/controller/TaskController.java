package com.event.planner.controller;

import com.event.planner.model.Task;
import com.event.planner.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Anton Shvechikov on 23.02.16.
 */
@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Task ajaxAddTask(Task task) {
        return taskService.save(task);
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public List<Task> ajaxGetTasks() {
        return taskService.getAll();
    }

    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public void ajaxRemoveTask(long taskId) {
        taskService.delete(taskId);
    }
}
