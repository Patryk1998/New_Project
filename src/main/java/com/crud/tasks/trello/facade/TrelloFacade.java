package com.crud.tasks.trello.facade;

import com.crud.tasks.domain.CreatedTrelloCardDto;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCardDto;
import com.crud.tasks.domain.facade.TrelloBoard;
import com.crud.tasks.domain.facade.TrelloCard;
import com.crud.tasks.mapper.TrelloMaper;
import com.crud.tasks.service.TrelloService;
import com.crud.tasks.trello.validator.TrelloValidator;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TrelloFacade {

    private static final Logger LOGGER = LoggerFactory.getLogger(TrelloFacade.class);
    @Autowired
    private TrelloService trelloService;

    @Autowired
    private TrelloMaper trelloMaper;

    @Autowired
    private TrelloValidator trelloValidator;

    public List<TrelloBoardDto> fetchTrelloBoards() {
        List<TrelloBoard> trelloBoards = trelloMaper.mapToBoards(trelloService.fetchTrelloBoard());
        List<TrelloBoard> filteredBoard = trelloValidator.validateTrelloBoards(trelloBoards);
        return trelloMaper.mapToBoardsDto(filteredBoard);
    }

    public CreatedTrelloCardDto createCard(final TrelloCardDto trelloCardDto) {
        TrelloCard trelloCard = trelloMaper.mapToCard(trelloCardDto);
        trelloValidator.valideCard(trelloCard);
        return trelloService.createdTrelloCard(trelloMaper.mapToCardDto(trelloCard));
    }
}
