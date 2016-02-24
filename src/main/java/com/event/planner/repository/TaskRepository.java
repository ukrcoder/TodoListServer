package com.event.planner.repository;

import com.event.planner.model.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Anton Shvechikov on 23.02.16.
 */
@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {

    List<Task> findAllByOrderByCreationDateDesc();
}
