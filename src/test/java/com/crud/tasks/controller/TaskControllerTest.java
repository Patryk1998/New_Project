//package com.crud.tasks.controller;
//
//import com.crud.tasks.domain.Task;
//import com.crud.tasks.domain.TaskDto;
//import com.crud.tasks.mapper.TaskMapper;
//import com.crud.tasks.service.DbService;
//import com.google.gson.Gson;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.ArgumentMatchers;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.hamcrest.Matchers.is;
//import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
//import static org.mockito.Mockito.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest(TaskController.class)
//public class TaskControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private DbService dbService;
//
//    @MockBean
//    private TaskMapper taskMapper;
//
//    @Test
//    public void shouldFetchEmptyTasksList() throws Exception {
//        //Given
//        List<TaskDto> emptyListTasksDto = new ArrayList<>();
//
//        when(taskMapper.mapToTaskDtoList(ArgumentMatchers.anyList())).thenReturn(emptyListTasksDto);
//
//        //When & Then
//        mockMvc.perform(get("/v1/task/getTasks").contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().is(200))
//                .andExpect(jsonPath("$", hasSize(0)));
//    }
//
//    @Test
//    public void shouldFetchTasksList() throws Exception {
//        //Given
//        TaskDto taskDto = new TaskDto(1L, "title", "content");
//        List<TaskDto> taskDtos = new ArrayList<>();
//        taskDtos.add(taskDto);
//
//        when(taskMapper.mapToTaskDtoList(ArgumentMatchers.anyList())).thenReturn(taskDtos);
//
//        //When & Then
//        mockMvc.perform(get("/v1/task/getTasks").contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().is(200))
//                .andExpect(jsonPath("$", hasSize(1)))
//                .andExpect(jsonPath("$[0].id", is(1)))
//                .andExpect(jsonPath("$[0].title", is("title")))
//                .andExpect(jsonPath("$[0].content", is("content")));
//
//    }
//
//    @Test
//    public void shouldFetchTask() throws Exception {
//        //Given
//        TaskDto taskDto = new TaskDto(1L, "title", "content");
//        Task task = new Task(1L, "title", "content");
//
//        when(dbService.getTaskById(ArgumentMatchers.anyLong())).thenReturn(java.util.Optional.ofNullable(task));
//        when(taskMapper.mapToTaskDto(ArgumentMatchers.any(Task.class))).thenReturn(taskDto);
//
//        //When & Then
//        mockMvc.perform(get("/v1/task/getTask").param("id", "1")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().is(200))
//                .andExpect(jsonPath("$.id", is(1)))
//                .andExpect(jsonPath("$.title", is("title")))
//                .andExpect(jsonPath("$.content", is("content")));
//
//    }
//
//    @Test
//    public void shouldUpdateTask() throws Exception {
//        //Given
//        TaskDto taskDto = new TaskDto(1L, "update title", "update content");
//        Task task = new Task(1L, "update title", "update content");
//        Gson gson = new Gson();
//        String json = gson.toJson(taskDto);
//
//        when(taskMapper.mapToTask(ArgumentMatchers.any(TaskDto.class))).thenReturn(task);
//        when(dbService.saveTask(ArgumentMatchers.any(Task.class))).thenReturn(task);
//        when(taskMapper.mapToTaskDto(ArgumentMatchers.any(Task.class))).thenReturn(taskDto);
//
//        //When & Then
//        mockMvc.perform(put("/v1/task/updateTask")
//                .contentType(MediaType.APPLICATION_JSON)
//                .characterEncoding("UTF-8")
//                .content(json))
//                .andExpect(status().is(200))
//                .andExpect(jsonPath("$.id", is(1)))
//                .andExpect(jsonPath("$.title", is("update title")))
//                .andExpect(jsonPath("$.content", is("update content")));
//    }
//
//    @Test
//    public void shouldDeleteTask() throws Exception {
//        //When & Then
//        mockMvc.perform(delete("/v1/task/deleteTask")
//                .param("id", "1")
//                .contentType(MediaType.APPLICATION_JSON));
//        verify(dbService, times(1)).deleteTaskById(ArgumentMatchers.anyLong());
//    }
//
//    @Test
//    public void shouldCreateTask() throws Exception {
//        //Given
//        TaskDto taskDto = new TaskDto(1L, "Tasktask", "ContentContent");
//        Gson gson = new Gson();
//        String json = gson.toJson(taskDto);
//
//        //When & Then
//        mockMvc.perform(post("/v1/task/createTask")
//                .contentType(MediaType.APPLICATION_JSON)
//                .characterEncoding("UTF-8")
//                .content(json));
//
//        System.out.println(Task.class);
//        verify(dbService, times(1)).saveTask(ArgumentMatchers.any());
//    }
//}