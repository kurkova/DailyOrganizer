package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class TrelloMapperTestSuite {
    @InjectMocks
    private TrelloMapper trelloMapper;

    @Test
    public void mapToBoardsTest() {
        //Given
        List<TrelloListDto> trelloListDto = new ArrayList<>();
        trelloListDto.add(new TrelloListDto("1", "to do", false));
        List<TrelloBoardDto> trelloBoardDtoList = new ArrayList<>();
        trelloBoardDtoList.add(new TrelloBoardDto("1", "Thursday", trelloListDto));
        //When
        List<TrelloBoard> mappedBoardList = trelloMapper.mapToBoards(trelloBoardDtoList);
        //Then
        assertEquals(trelloBoardDtoList.get(0).getId(), mappedBoardList.get(0).getId());
        assertEquals("Thursday", mappedBoardList.get(0).getName());
    }

    @Test
    public void mapToBoardsDtoTest() {
        //Given
        List<TrelloList> trelloList = new ArrayList<>();
        trelloList.add(new TrelloList("2", "done", false));
        List<TrelloBoard> trelloBoardList = new ArrayList<>();
        trelloBoardList.add(new TrelloBoard("1", "Monday", trelloList));
        //When
        List<TrelloBoardDto> mappedBoardDtoList = trelloMapper.mapToBoardsDto(trelloBoardList);
        //Then
        assertEquals(trelloBoardList.get(0).getId(), mappedBoardDtoList.get(0).getId());
        assertEquals("Monday", mappedBoardDtoList.get(0).getName());
    }

    @Test
    public void mapToListTest() {
        //Given
        List<TrelloListDto> trelloListDto = new ArrayList<>();
        trelloListDto.add(new TrelloListDto("1", "to do", false));
        //When
        List<TrelloList> mappedTrelloList = trelloMapper.mapToList(trelloListDto);
        //Then
        assertEquals(trelloListDto.get(0).getName(), mappedTrelloList.get(0).getName());
    }

    @Test
    public void mapToListDtoTest() {
        //Given
        List<TrelloList> trelloList = new ArrayList<>();
        trelloList.add(new TrelloList("2", "done", false));
        //When
        List<TrelloListDto> mappedTrelloList = trelloMapper.mapToListDto(trelloList);
        //Then
        assertEquals(trelloList.get(0).getName(), mappedTrelloList.get(0).getName());
    }

    @Test
    public void mapToCardTest() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("Thursday", "descr", "pos2", "2");
        //When
        TrelloCard mappedTrelloCard = trelloMapper.mapToCard(trelloCardDto);
        //Then
        assertEquals(trelloCardDto.getDescription(), mappedTrelloCard.getDescription());
    }

    @Test
    public void mapToCardDtoTest() {
        //Given
        TrelloCard trelloCard = new TrelloCard("Monday", "description", "pos", "1");
        //When
        TrelloCardDto mappedTrelloCard = trelloMapper.mapToCardDto(trelloCard);
        //Then
        assertEquals(trelloCard.getName(), mappedTrelloCard.getName());
    }
}
