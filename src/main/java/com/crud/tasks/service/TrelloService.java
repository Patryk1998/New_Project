package com.crud.tasks.service;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.domain.CreatedTrelloCardDto;
import com.crud.tasks.domain.Mail;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCardDto;
import com.crud.tasks.trello.client.TrelloClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrelloService {

    private static final String SUBJECT = "Tasks: New Trello Card!";

    @Autowired
    private TrelloClient trelloClient;

    @Autowired
    private SimpleEmailService mailService;

    @Autowired
    private AdminConfig adminConfig;

    public List<TrelloBoardDto> fetchTrelloBoard() {
        return trelloClient.getTrelloBoards();
    }

    public CreatedTrelloCardDto createdTrelloCard(final TrelloCardDto trelloCardDto) {
        CreatedTrelloCardDto newCard = trelloClient.createNewCard(trelloCardDto);

        if(newCard != null) {
            Optional.ofNullable(newCard).ifPresent(card -> mailService.send(new Mail(adminConfig.getAdminMail(), SUBJECT,
                    "New card: " + card.getName() + " has been created on your Trello account!", null)));
        }
        return newCard;

    }
}
