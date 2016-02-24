package com.event.planner.controller;

import com.event.planner.context.TestContext;
import com.event.planner.model.Task;
import com.event.planner.service.TaskService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;

import static java.util.Collections.singletonList;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Anton Shvechikov on 24.02.16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TestContext.class)
@WebAppConfiguration
public class TaskControllerTest {

    private ObjectMapper objectMapper = new ObjectMapper();

    private Task testTask = new Task("temp");
    private LocalDate now = LocalDate.now();
    private String tasksJsonList;

    private MockMvc mvc;

    @InjectMocks
    private TaskController taskController;

    @Mock
    private TaskService taskService;

    @Before
    public void setUp() throws Exception {
        taskController = new TaskController();
        mvc = MockMvcBuilders.standaloneSetup(taskController).build();
        MockitoAnnotations.initMocks(this);
        testTask.setId(1l);
        testTask.setCreationDate(now);
        tasksJsonList = objectMapper.writeValueAsString(singletonList(testTask));

        when(taskService.getAll()).thenReturn(singletonList(testTask));
    }

    @Test
    public void testAjaxAddTask() throws Exception {
        mvc.perform(post("/tasks/add").accept(MediaType.APPLICATION_JSON).content("{\"description\":\"test\"}"))
                .andExpect(status().isOk());
    }

    @Test
    public void testAjaxGetTasks() throws Exception {
        mvc.perform(get("/tasks")).andExpect(status().isOk()).andExpect(content().string(tasksJsonList));
        verify(taskService, times(1)).getAll();
        reset(taskService);
    }

    @Test
    @Ignore
    // TODO fix after writing client
    public void testAjaxRemoveTask() throws Exception {
        mvc.perform(post("/tasks/remove").content("{\"taskId\":1}"))
                .andExpect(status().isOk());
        verify(taskService, times(1)).delete(1L);
        reset(taskService);
    }
}