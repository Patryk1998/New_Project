//package com.crud.tasks.trello.facade;
//
//import com.crud.tasks.domain.CreatedTrelloCardDto;
//import com.crud.tasks.domain.TrelloBoardDto;
//import com.crud.tasks.domain.TrelloCardDto;
//import com.crud.tasks.domain.TrelloListDto;
//import com.crud.tasks.domain.facade.TrelloBoard;
//import com.crud.tasks.domain.facade.TrelloCard;
//import com.crud.tasks.domain.facade.TrelloList;
//import com.crud.tasks.mapper.TrelloMaper;
//import com.crud.tasks.service.TrelloService;
//import com.crud.tasks.trello.validator.TrelloValidator;
//import static org.junit.Assert.*;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.mockito.ArgumentMatchers.anyList;
//import static org.mockito.Mockito.when;
//
//@RunWith(MockitoJUnitRunner.class)
//public class TrelloFacadeTest {
//
//    @InjectMocks
//    private TrelloFacade trelloFacade;
//
//    @Mock
//    private TrelloService trelloService;
//
//    @Mock
//    private TrelloValidator trelloValidator;
//
//    @Mock
//    private TrelloMaper trelloMaper;
//    @Test
//    public void shouldFetchEmptyList() {
//        //Given
//        List<TrelloListDto> trelloLists = new ArrayList<>();
//        trelloLists.add(new TrelloListDto("1", "test_list", false));
//
//        List<TrelloBoardDto> trelloBoards = new ArrayList<>();
//        trelloBoards.add(new TrelloBoardDto("1", "test", trelloLists));
//
//        List<TrelloList> mapperdTrelloLists = new ArrayList<>();
//        mapperdTrelloLists.add(new TrelloList("1", "test_list", false));
//
//        List<TrelloBoard> mappedTrelloBoards = new ArrayList<>();
//        mappedTrelloBoards.add(new TrelloBoard("1", "test", mapperdTrelloLists));
//
//        when(trelloService.fetchTrelloBoard()).thenReturn(trelloBoards);
//        when(trelloMaper.mapToBoards(trelloBoards)).thenReturn(mappedTrelloBoards);
//        when(trelloMaper.mapToBoardsDto(anyList())).thenReturn(new ArrayList<>());
//        when(trelloValidator.validateTrelloBoards(mappedTrelloBoards)).thenReturn(new ArrayList<>());
//
//        //When
//        List<TrelloBoardDto> trelloBoardDtos = trelloFacade.fetchTrelloBoards();
//
//        //Then
//        assertNotNull(trelloBoardDtos);
//        assertEquals(0, trelloBoardDtos.size());
//    }
//
//    @Test
//    public void shouldFetchTrelloBoards() {
//        //Given
//        List<TrelloListDto> trelloLists = new ArrayList<>();
//        trelloLists.add(new TrelloListDto("1", "my_list", false));
//
//        List<TrelloBoardDto> trelloBoards = new ArrayList<>();
//        trelloBoards.add(new TrelloBoardDto("my_task", "1", trelloLists));
//
//        List<TrelloList> mapperdTrelloLists = new ArrayList<>();
//        mapperdTrelloLists.add(new TrelloList("1", "my_list", false));
//
//        List<TrelloBoard> mappedTrelloBoards = new ArrayList<>();
//        mappedTrelloBoards.add(new TrelloBoard("my_task", "1", mapperdTrelloLists));
//
//        when(trelloService.fetchTrelloBoard()).thenReturn(trelloBoards);
//        when(trelloMaper.mapToBoards(trelloBoards)).thenReturn(mappedTrelloBoards);
//        when(trelloMaper.mapToBoardsDto(anyList())).thenReturn(trelloBoards);
//        when(trelloValidator.validateTrelloBoards(mappedTrelloBoards)).thenReturn(mappedTrelloBoards);
//
//        //When
//        List<TrelloBoardDto> trelloBoardDtos = trelloFacade.fetchTrelloBoards();
//
//        //Then
//        assertNotNull(trelloBoardDtos);
//        assertEquals(1, trelloBoardDtos.size());
//
//        trelloBoardDtos.forEach(trelloBoardDto -> {
//            assertEquals("1", trelloBoardDto.getId());
//            assertEquals("my_task", trelloBoardDto.getName());
//
//            trelloBoardDto.getLists().forEach(trelloListDto -> {
//                assertEquals("1", trelloListDto.getId());
//                assertEquals("my_list", trelloListDto.getName());
//                assertEquals(false, trelloListDto.isClose());
//            });
//        });
//    }
//
//    @Test
//    public void shouldCreateCard() {
//        //Given
//        TrelloCardDto trelloCardDto = new TrelloCardDto("name", "description", "position", "listId");
//        TrelloCard trelloCard = new TrelloCard("name", "description", "position", "listId");
//
//        when(trelloMaper.mapToCard(trelloCardDto)).thenReturn(trelloCard);
//        when(trelloMaper.mapToCardDto(trelloCard)).thenReturn(trelloCardDto);
//        when(trelloService.createdTrelloCard(trelloCardDto)).thenReturn(new CreatedTrelloCardDto("id", "name", "xxx"));
//
//        //When
//        CreatedTrelloCardDto createdTrelloCardDto = trelloFacade.createCard(trelloCardDto);
//
//        //Then
//        assertEquals("name", createdTrelloCardDto.getName());
//        assertEquals("id", createdTrelloCardDto.getId());
//        assertEquals("xxx", createdTrelloCardDto.getShortUrl());
//
//    }
//}