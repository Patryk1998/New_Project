//package com.crud.tasks.trello.validator;
//
//import com.crud.tasks.domain.Trello;
//import com.crud.tasks.domain.facade.TrelloBoard;
//import org.junit.Assert;
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
//public class TrelloValidatorTest {
//
//    @Autowired
//    private TrelloValidator trelloValidator;
//
//    @Test
//    public void validateTrelloBoards() {
//        //Given
//        TrelloBoard trelloBoard1 = new TrelloBoard("name1", "id", new ArrayList<>());
//        TrelloBoard trelloBoard2 = new TrelloBoard("name2", "id2", new ArrayList<>());
//        TrelloBoard trelloBoard3 = new TrelloBoard("test", "id3", new ArrayList<>());
//        List<TrelloBoard> testList = new ArrayList<>();
//        testList.add(trelloBoard1);
//        testList.add(trelloBoard2);
//        testList.add(trelloBoard3);
//        //When
//        List<TrelloBoard> finalList = trelloValidator.validateTrelloBoards(testList);
//        //Then
//        Assert.assertEquals(2, finalList.size());
//    }
//}