package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class TaskMapperTestSuite {
    @InjectMocks
    private TaskMapper taskMapper;

    @Test
    public void mapToTaskTest() {
        //Given
        TaskDto taskDto = new TaskDto(1L, "title", "content");
        //When
        Task mappedTask = taskMapper.mapToTask(taskDto);
        //Then
        assertEquals(taskDto.getId(), mappedTask.getId());
        assertEquals(taskDto.getTitle(), mappedTask.getTitle());
        assertEquals(taskDto.getContent(), mappedTask.getContent());
    }

    @Test
    public void mapToTaskDtoTest() {
        //Given
        Task task = new Task(1L, "title", "content");
        //When
        TaskDto mappedTask = taskMapper.mapToTaskDto(task);
        //Then
        assertEquals(task.getId(), mappedTask.getId());
        assertEquals(task.getTitle(), mappedTask.getTitle());
        assertEquals(task.getContent(), mappedTask.getContent());
    }

    @Test
    public void mapTaskDtoListTest() {
        //Given
        List<Task> tasksList = new ArrayList<>();
        tasksList.add(new Task(1L, "title", "content"));
        tasksList.add(new Task(2L, "title2", "content2"));
        //When
        List<TaskDto> mappedTasksList = taskMapper.mapToTaskDtoList(tasksList);
        //Then
        assertEquals(tasksList.size(), mappedTasksList.size());
        assertEquals(tasksList.get(0).getTitle(), mappedTasksList.get(0).getTitle());
        assertEquals(tasksList.get(1).getContent(), mappedTasksList.get(1).getContent());
    }
}
