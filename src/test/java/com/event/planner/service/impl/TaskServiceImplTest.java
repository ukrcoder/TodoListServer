package com.event.planner.service.impl;

import com.event.planner.context.TestContext;
import com.event.planner.model.Task;
import com.event.planner.repository.TaskRepository;
import com.event.planner.service.TaskService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created by Anton Shvechikov on 24.02.16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TestContext.class)
public class TaskServiceImplTest {

    private static final Task TEST_TASK1 = new Task("temp");
    private static final Task TEST_TASK2 = new Task("temp2");
    private static final Task TEST_TASK3 = new Task("temp3");
    private static final Task NULL_TASK = null;

    private static final Long REMOVE_TASK_ID = 1l;
    private static final Long REMOVE_WRONG_TASK_ID = 0l;

    private static List<Task> tasks = Arrays.asList(TEST_TASK1, TEST_TASK2);

    @Mock
    private TaskRepository repository;

    @InjectMocks
    private TaskService taskService;

    @Before
    public void setUp() throws Exception {
        taskService = new TaskServiceImpl();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAll() throws Exception {
        when(repository.findAllByOrderByCreationDateDesc()).thenReturn(tasks);
        assertEquals(tasks, taskService.getAll());
        verify(repository, times(1)).findAllByOrderByCreationDateDesc();
        reset(repository);
    }

    @Test
    public void testDelete() throws Exception {
        taskService.delete(REMOVE_TASK_ID);
        verify(repository, times(1)).delete(REMOVE_TASK_ID);
        reset(repository);
        taskService.delete(REMOVE_WRONG_TASK_ID);
        verify(repository, times(0)).delete(REMOVE_WRONG_TASK_ID);
        reset(repository);
    }

    @Test
    public void testSave() throws Exception {
        taskService.save(TEST_TASK3);
        verify(repository, times(1)).save(TEST_TASK3);
        reset(repository);
    }

    @Test
    public void testSaveNullTask() throws Exception {
        taskService.save(NULL_TASK);
        verify(repository, times(0)).save(NULL_TASK);
        reset(repository);
    }
}
