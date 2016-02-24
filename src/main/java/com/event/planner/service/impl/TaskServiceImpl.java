package com.event.planner.service.impl;

import com.event.planner.model.Task;
import com.event.planner.repository.TaskRepository;
import com.event.planner.service.TaskService;
import com.event.planner.utils.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Anton Shvechikov on 23.02.16.
 */
@Service
@Transactional
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository repository;

    @Cacheable(value = "tasksCache")
    @Transactional(readOnly = true)
    public List<Task> getAll() {
        return Lists.iteratorToList(repository.findAllByOrderByCreationDateDesc().iterator());
    }

    public void delete(long taskId) {
        if (taskId > 0L) {
            repository.delete(taskId);
        }
    }

    public Task save(Task task) {
        if (task != null) {
            return repository.save(task);
        }
        return null;
    }
}
