package com.event.planner.service;

import com.event.planner.model.Task;

import java.util.List;

/**
 * Created by Anton Shvechikov on 23.02.16.
 */
public interface TaskService {

    /**
     * Gets all tasks
     * @return {@code List<Task>}
     */
    List<Task> getAll();

    /**
     * Removes task with specified ID
     */
    void delete(long taskId);

    /**
     * Saves a task
     * @param task - specified task
     * @return {@code Task} task with generated ID
     */
    Task save(Task task);


}
