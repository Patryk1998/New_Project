package com.crud.tasks.controller;

import com.crud.tasks.domain.CreatedTrelloCard;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCardDto;
import com.crud.tasks.trello.client.TrelloClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/trello")
public class TrelloController {

    @Autowired
    private TrelloClient trelloClient;

    @RequestMapping(method = RequestMethod.GET, value = "getTrelloBoards")
    public void getTrelloBoards() throws TaskNotFoundException {

        List<TrelloBoardDto> trelloBoards = trelloClient.getTrelloBoards().orElseThrow(TaskNotFoundException::new);

        trelloBoards.forEach( trelloBoardDto -> {
                System.out.println("ID: " + trelloBoardDto.getId() + ", NAME: " + trelloBoardDto.getName());
                System.out.println("contains: " );
                trelloBoardDto.getLists().forEach(trelloListDto -> System.out.println(
                        "name: " + trelloListDto.getName() + ", id: " + trelloListDto.getId() + ", closed: " + trelloListDto.getIsClose()
                ));}
        );

        trelloBoards.stream()
                .filter(trelloBoardDto -> trelloBoardDto.getName() != null && trelloBoardDto.getId() != null)
                .filter(trelloBoardDto -> trelloBoardDto.getName().contains("Kodilla"))
                .forEach(trelloBoardDto -> System.out.println(trelloBoardDto.getId() + " " + trelloBoardDto.getName()));

    }

    @RequestMapping(method = RequestMethod.POST, value = "createTrelloCard")
    public CreatedTrelloCard createTrelloCard(@RequestBody TrelloCardDto trelloCardDto) {
        return trelloClient.createNewCard(trelloCardDto);
    }
}
