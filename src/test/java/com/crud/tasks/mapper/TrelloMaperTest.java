//package com.crud.tasks.mapper;
//
//import com.crud.tasks.TasksApplication;
//import com.crud.tasks.domain.Trello;
//import com.crud.tasks.domain.TrelloBoardDto;
//import com.crud.tasks.domain.TrelloCardDto;
//import com.crud.tasks.domain.TrelloListDto;
//import com.crud.tasks.domain.facade.TrelloBoard;
//import com.crud.tasks.domain.facade.TrelloCard;
//import com.crud.tasks.domain.facade.TrelloList;
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
//public class TrelloMaperTest {
//
//    @Autowired
//    private TrelloMaper trelloMaper;
//
//    @Test
//    public void mapToListTest() {
//        //Given
//        TrelloListDto trelloListDto = new TrelloListDto("id1", "name1", true);
//        List<TrelloListDto> test = new ArrayList<>();
//        test.add(trelloListDto);
//        //When
//        List<TrelloList> list = trelloMaper.mapToList(test);
//        //Then
//        assertEquals(trelloListDto.getId(), list.get(0).getId());
//        assertEquals(trelloListDto.getName(), list.get(0).getName());
//        assertEquals(trelloListDto.isClose(), list.get(0).isClosed());
//    }
//
//    @Test
//    public void mapToListDtoTest() {
//        //Given
//        TrelloList trelloList = new TrelloList("id1", "name1", false);
//        List<TrelloList> test = new ArrayList<>();
//        test.add(trelloList);
//        //When
//        List<TrelloListDto> list = trelloMaper.mapToListDto(test);
//        //Then
//        assertEquals(trelloList.getId(), list.get(0).getId());
//        assertEquals(trelloList.getName(), list.get(0).getName());
//        assertEquals(trelloList.isClosed(), list.get(0).isClose());
//    }
//
//    @Test
//    public void mapToBoardTest() {
//        //Given
//        TrelloListDto trelloListDto = new TrelloListDto("id1", "name1", true);
//        List<TrelloListDto> testLists = new ArrayList<>();
//        testLists.add(trelloListDto);
//        TrelloBoardDto trelloBoardDto = new TrelloBoardDto("name", "id", testLists);
//        List<TrelloBoardDto> testBoards = new ArrayList<>();
//        testBoards.add(trelloBoardDto);
//        //When
//        List<TrelloBoard> list = trelloMaper.mapToBoards(testBoards);
//        //Then
//        assertEquals(trelloBoardDto.getId(), list.get(0).getId());
//        assertEquals(trelloBoardDto.getName(), list.get(0).getName());
//        assertEquals(trelloListDto.getId(), list.get(0).getLists().get(0).getId());
//        assertEquals(trelloListDto.getName(), list.get(0).getLists().get(0).getName());
//        assertEquals(trelloListDto.isClose(), list.get(0).getLists().get(0).isClosed());
//    }
//
//    @Test
//    public void mapToBoardDtoTest() {
//        //Given
//        TrelloList trelloList = new TrelloList("id1", "name1", false);
//        List<TrelloList> testLists = new ArrayList<>();
//        testLists.add(trelloList);
//        TrelloBoard trelloBoard = new TrelloBoard("name", "id", testLists);
//        List<TrelloBoard> testBoards = new ArrayList<>();
//        testBoards.add(trelloBoard);
//        //When
//        List<TrelloBoardDto> list = trelloMaper.mapToBoardsDto(testBoards);
//        //Then
//        assertEquals(trelloBoard.getId(), list.get(0).getId());
//        assertEquals(trelloBoard.getName(), list.get(0).getName());
//        assertEquals(trelloList.getId(), list.get(0).getLists().get(0).getId());
//        assertEquals(trelloList.getName(), list.get(0).getLists().get(0).getName());
//        assertEquals(trelloList.isClosed(), list.get(0).getLists().get(0).isClose());
//    }
//
//    @Test
//    public void mapToCardTest() {
//        //Given
//        TrelloCardDto trelloCardDto = new TrelloCardDto("name", "description", "position", "123");
//        //When
//        TrelloCard trelloCard = trelloMaper.mapToCard(trelloCardDto);
//        //Then
//        assertEquals(trelloCardDto.getName(), trelloCard.getName());
//        assertEquals(trelloCardDto.getDescription(), trelloCard.getDescription());
//        assertEquals(trelloCardDto.getPos(), trelloCard.getPos());
//        assertEquals(trelloCardDto.getListId(), trelloCard.getListId());
//    }
//
//    @Test
//    public void mapToCardDtoTest() {
//        //Given
//        TrelloCard trelloCard = new TrelloCard("name", "description", "position", "123");
//        //When
//        TrelloCardDto trelloCardDto = trelloMaper.mapToCardDto(trelloCard);
//        //Then
//        assertEquals(trelloCard.getName(), trelloCardDto.getName());
//        assertEquals(trelloCard.getDescription(), trelloCardDto.getDescription());
//        assertEquals(trelloCard.getPos(), trelloCardDto.getPos());
//        assertEquals(trelloCard.getListId(), trelloCardDto.getListId());
//    }
//
//}