//package com.crud.tasks.mapper;
//
//import com.crud.tasks.domain.Task;
//import com.crud.tasks.domain.TaskDto;
//import static org.junit.Assert.*;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.Assert.*;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class TaskMapperTest {
//
//    @Autowired
//    private TaskMapper taskMapper;
//
//    @Test
//    public void mapToTask() {
//        //Given
//        TaskDto taskDto = new TaskDto( 1L, "title", "content");
//        //When
//        Task finalTask = taskMapper.mapToTask(taskDto);
//        //Then
//        assertEquals(1L, finalTask.getId(), 0);
//        assertEquals("title", finalTask.getTitle());
//        assertEquals("content", finalTask.getContent());
//    }
//
//    @Test
//    public void mapToTaskDto() {
//        //Given
//        Task task = new Task(1L, "title", "content");
//        //When
//        TaskDto finalTaskDto = taskMapper.mapToTaskDto(task);
//        //Then
//        assertEquals(1L, finalTaskDto.getId(), 0);
//        assertEquals("title", finalTaskDto.getTitle());
//        assertEquals("content", finalTaskDto.getContent());
//
//    }
//
//    @Test
//    public void mapToTaskDtoList() {
//        //Given
//        Task task1 = new Task(1L, "title1", "content1");
//        Task task2 = new Task(2L, "title2", "content2");
//        Task task3 = new Task(3L, "title3", "content3");
//        List<Task> taskList = new ArrayList<>();
//        taskList.add(task1);
//        taskList.add(task2);
//        taskList.add(task3);
//        //When
//        List<TaskDto> finalList = taskMapper.mapToTaskDtoList(taskList);
//        //Then
//        assertEquals(1L, finalList.get(0).getId(),0);
//        assertEquals(2L, finalList.get(1).getId(),0);
//        assertEquals(3L, finalList.get(2).getId(),0);
//        assertEquals("title1", finalList.get(0).getTitle());
//        assertEquals("title2", finalList.get(1).getTitle());
//        assertEquals("title3", finalList.get(2).getTitle());
//        assertEquals("content1", finalList.get(0).getContent());
//        assertEquals("content2", finalList.get(1).getContent());
//        assertEquals("content3", finalList.get(2).getContent());
//
//    }
//}