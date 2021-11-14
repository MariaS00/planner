package com.example.planner.repository;

import com.example.planner.model.Category;
import com.example.planner.model.Priority;
import com.example.planner.model.Task;
import com.example.planner.service.TaskService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class TaskRepositoryTest {

    @Autowired
    private TaskRepository repository;

    @Autowired
    private TaskService service;

    @Test
    void shouldDelete(){
    //given
    final var task1 = new Task("wysłac maila", LocalDateTime.of(2021,11,15,15,00), Priority.HIGH, Category.APPOINTMENT, "zyczenia");
    final var task2 = new Task("wysłahyvvtc maila", LocalDateTime.of(2021,11,15,15,00), Priority.HIGH, Category.APPOINTMENT, "zyczenia");
    repository.saveAllAndFlush(List.of(task1, task2));
    //when

    repository.delete(task1);
    //then
    assertEquals(1, repository.count());
}

    @Test
    void shouldFindByTaskTitle(){
    //given
    final var task1 = new Task("zrobić pranie", LocalDateTime.of(2021,11,15,15,00), Priority.MEDIUM, Category.WORK, "porządki");
    final var task2 = new Task("prrralka", LocalDateTime.of(2021,11,15,15,00), Priority.MEDIUM, Category.WORK, "świąteczne porządki");
    repository.saveAllAndFlush(List.of(task1, task2));
    //when


     final var result = repository.findByTaskTitle("prrralka");

    //then
    assertEquals(List.of(task2), result);

}

    @Test
    void shouldFindAllByTaskCategory(){

    //given
    final var task1 = new Task("spacer z koleżanką", LocalDateTime.of(2021,11,15,15,00), Priority.LOW, Category.SOCIAL_LIFE, "wyjście na Pietryne");
    final var task2 = new Task("prrralka", LocalDateTime.of(2011,10,15,9,00), Priority.MEDIUM, Category.WORK, "świąteczne porządki");

    repository.saveAllAndFlush(List.of(task1, task2));
    //when

    final var result = repository.findAllByTaskCategory(Category.SOCIAL_LIFE);

    //then
    assertEquals(List.of(task1), result);



}
    @Test
    void shouldFindAllByTaskDate(){

    //given
    final var task1 = new Task("spacer z koleżanką", LocalDateTime.of(2019,11,10,11,10), Priority.LOW, Category.SOCIAL_LIFE, "wyjście na Pietryne");
    final var task2 = new Task("prrralka", LocalDateTime.of(2021,11,15,13,30), Priority.MEDIUM, Category.WORK, "świąteczne porządki");

    repository.saveAllAndFlush(List.of(task1, task2));
    //when

    final var result = repository.findAllByTaskDate(LocalDateTime.of(2021,11,15,13,30));

    //then
    assertEquals(List.of(task2), result);

}
    @Test
    void shouldFindAllByTaskPriority(){

    //given

    final var task1 = new Task("spacer z koleżanką", LocalDateTime.of(2021,11,15,15,00), Priority.LOW, Category.SOCIAL_LIFE, "wyjście na Pietryne");
    final var task2 = new Task("prrralka", LocalDateTime.of(2019,1,15,1,00), Priority.MEDIUM, Category.WORK, "świąteczne porządki");

    repository.saveAllAndFlush(List.of(task1, task2));
    //when

    final var result = repository.findAllByTaskPriority(Priority.LOW);

    //then
    assertEquals(List.of(task1), result);

}

    @Test
    void shouldFindAllByTaskPriorityAndTaskDate(){

        //given

        final var task1 = new Task("spacer z koleżanką", LocalDateTime.of(2020,11,1,15,00), Priority.LOW, Category.SOCIAL_LIFE, "wyjście na Pietryne");
        final var task2 = new Task("prrralka", LocalDateTime.of(2021,11,15,15,00), Priority.MEDIUM, Category.WORK, "świąteczne porządki");

        repository.saveAllAndFlush(List.of(task1, task2));
        //when

        final var result = repository.findAllByTaskPriorityAndTaskDate(Priority.LOW,LocalDateTime.of(2020,11,1,15,00));

        //then
        assertEquals(List.of(task1), result);

}
    @Test
    void shouldFindAllByDescriptionStartingWithIgnoreCase(){

        //given

        final var task1 = new Task("spacer z koleżanką", LocalDateTime.of(2021,11,15,15,00), Priority.LOW, Category.SOCIAL_LIFE, "wyjście na Pietryne");
        final var task2 = new Task("prrralka", LocalDateTime.of(2020,10,15,15,00), Priority.MEDIUM, Category.WORK, "świąteczne porządki");

        repository.saveAllAndFlush(List.of(task1, task2));
        //when

        final var result = repository.findAllByDescriptionStartingWithIgnoreCase("Wyjście");

        //then
        assertEquals(List.of(task1), result);

}

    @Test
    void shouldCountAllByTaskDate(){

        //given

        final var task1 = new Task("spacer z koleżanką", LocalDateTime.of(2019,5,15,12,00), Priority.LOW, Category.SOCIAL_LIFE, "wyjście na Pietryne");
        final var task2 = new Task("prrralka", LocalDateTime.of(2021,11,15,15,00), Priority.MEDIUM, Category.WORK, "świąteczne porządki");
        final var task3 = new Task("paaaaaa", LocalDateTime.of(2021,11,15,15,00), Priority.MEDIUM, Category.WORK, "świąteczne porządki");

        repository.saveAllAndFlush(List.of(task1, task2, task3));
        //when


        final var result = repository.countAllByTaskDate(LocalDateTime.of(2021,11,15,15,00));

        //then
        assertEquals(2,result);

}
    @Test
    void ifTaskExists(){

    //given
    final var task1 = new Task("spacer z koleżanką", LocalDateTime.of(2021,11,15,15,00), Priority.LOW, Category.SOCIAL_LIFE, "wyjście na Pietryne");
    final var task2 = new Task("prrralka", LocalDateTime.of(2025,1,15,15,12), Priority.MEDIUM, Category.WORK, "świąteczne porządki");

    repository.saveAllAndFlush(List.of(task1, task2));

    //when

    final var result = repository.taskExists(task1.getTaskId());

    //then
    assertEquals(true, result);


}

    @Test
    void shouldUpdatePriority(){

        //given
        final var task1 = new Task("spacer z koleżanką", LocalDateTime.of(2020,11,30,15,00), Priority.LOW, Category.SOCIAL_LIFE, "wyjście na Pietryne");
        final var task2 = new Task("prrralka", LocalDateTime.of(2021,11,15,15,00), Priority.MEDIUM, Category.WORK, "świąteczne porządki");

        repository.saveAllAndFlush(List.of(task1, task2));

        //when

        final int result = repository.updatePriority(Priority.HIGH, task2.getTaskId());

        //then
        assertEquals(1, result);



}
    @Test
    void shouldUpdateTaskDate(){

        //given
        final var task1 = new Task("spacer z koleżanką", LocalDateTime.of(2021,11,15,15,00), Priority.LOW, Category.SOCIAL_LIFE, "wyjście na Pietryne");
        final var task2 = new Task("prrralka", LocalDateTime.of(2001,12,15,13,05), Priority.MEDIUM, Category.WORK, "świąteczne porządki");

        repository.saveAllAndFlush(List.of(task1, task2));

        //when

        final int result = repository.updateTaskDate(LocalDateTime.of(2021,11,15,15,00), task2.getTaskId());

        //then
        assertEquals(1, result);

}
    @Test
    void shouldUpdateTaskTitle(){

        //given
        final var task1 = new Task("spacer z koleżanką", LocalDateTime.of(2021,11,15,15,00), Priority.LOW, Category.SOCIAL_LIFE, "wyjście na Pietryne");
        final var task2 = new Task("prrralka", LocalDateTime.of(2021,11,15,15,00), Priority.MEDIUM, Category.WORK, "świąteczne porządki");

        repository.saveAllAndFlush(List.of(task1, task2));

        //when

        final int result = repository.updateTaskTitle("zmywanie", task1.getTaskId());

        //then
        assertEquals(1, result);

}
    @Test
    void shouldUpdateTaskDescription(){

        //given
        final var task1 = new Task("spacer z koleżanką", LocalDateTime.of(2021,11,15,15,00), Priority.LOW, Category.SOCIAL_LIFE, "wyjście na Pietryne");
        final var task2 = new Task("prrralka", LocalDateTime.of(2021,11,15,15,00), Priority.MEDIUM, Category.WORK, "świąteczne porządki");

        repository.saveAllAndFlush(List.of(task1, task2));

        //when

        final int result = repository.updateTaskDescription("zrobić przed wyjazdem", task1.getTaskId());

        //then
        assertEquals(1, result);

}

    @Test
    void shouldUpdateTaskCategory(){

        //given
        final var task1 = new Task("spacer z koleżanką", LocalDateTime.of(2011,1,15,15,00), Priority.LOW, Category.SOCIAL_LIFE, "wyjście na Pietryne");
        final var task2 = new Task("prrralka", LocalDateTime.of(2021,11,15,15,00), Priority.MEDIUM, Category.WORK, "świąteczne porządki");

        repository.saveAllAndFlush(List.of(task1, task2));

        //when

        final int result = repository.updateTaskCategory(Category.APPOINTMENT, task1.getTaskId());

        //then
        assertEquals(1, result);

}}