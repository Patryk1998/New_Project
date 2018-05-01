package com.crud.tasks.domain.facade;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class TrelloBoard {
    private String id;
    private String name;
    private List<TrelloList> lists;
}
