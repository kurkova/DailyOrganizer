package com.crud.tasks.trello.validator;

import com.crud.tasks.domain.TrelloBoard;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TrelloValidatorTest {
    private TrelloValidator trelloValidator = new TrelloValidator();

    @Test
    public void testValidateTrelloBoards() {
        //Given
        List<TrelloBoard> trelloBoards = new ArrayList<>();
        trelloBoards.add(new TrelloBoard("1", "test", new ArrayList<>()));
        trelloBoards.add(new TrelloBoard("2", "name", new ArrayList<>()));
        //When
        List<TrelloBoard> excpectedTrelloBoardList = trelloValidator.validateTrelloBords(trelloBoards);
        //Then
        assertEquals(1, excpectedTrelloBoardList.size());
        excpectedTrelloBoardList.forEach(trelloBoard -> {
            assertEquals("2", trelloBoard.getId());
            assertEquals("name", trelloBoard.getName());
        });
    }
}