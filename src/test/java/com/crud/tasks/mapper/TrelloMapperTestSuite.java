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

        List<TrelloList> trelloList = new ArrayList<>();
        trelloList.add(new TrelloList("2", "done", false));
        List<TrelloBoard> trelloBoardList = new ArrayList<>();
        trelloBoardList.add(new TrelloBoard("1", "Monday", trelloList));

        //Then
        List<TrelloBoard> mapedBoardList = trelloMapper.mapToBoards(trelloBoardDtoList);
        List<TrelloBoardDto> mapedBoardDtoList = trelloMapper.mapToBoardsDto(trelloBoardList);
        //When
        assertEquals(trelloBoardDtoList.get(0).getId(), mapedBoardDtoList.get(0).getId());
        assertEquals(trelloBoardList.get(0).getId(), mapedBoardList.get(0).getId());
    }

    @Test
    public void mapToListTest() {
        //Given
        List<TrelloListDto> trelloListDto = new ArrayList<>();
        trelloListDto.add(new TrelloListDto("1", "to do", false));
        List<TrelloList> trelloList = new ArrayList<>();
        trelloList.add(new TrelloList("2", "done", false));
        //Then
        List<TrelloListDto> mapedTrelloList = trelloMapper.mapToListDto(trelloList);
        List<TrelloList> mapedTrelloListDto = trelloMapper.mapToList(trelloListDto);
        //Then
        assertEquals(trelloList.get(0).getName(), mapedTrelloList.get(0).getName());
        assertEquals(trelloListDto.get(0).getName(), mapedTrelloListDto.get(0).getName());
    }

    @Test
    public void mapToCard() {
        //Given
        TrelloCard trelloCard = new TrelloCard("Monday", "description", "pos", "1");
        TrelloCardDto trelloCardDto = new TrelloCardDto("Thursday", "descr", "pos2", "2");
        //Then
        TrelloCardDto mapedTrelloCard = trelloMapper.mapToCardDto(trelloCard);
        TrelloCard mapedTrelloCardDto = trelloMapper.mapToCard(trelloCardDto);
        //When
        assertEquals(trelloCard.getName(), mapedTrelloCard.getName());
        assertEquals(trelloCardDto.getDescription(), mapedTrelloCardDto.getDescription());
    }
}
