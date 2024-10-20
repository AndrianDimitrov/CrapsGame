package com.example.crapsGame;

import com.example.crapsGame.service.CrapsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static com.example.crapsGame.data.constants.CrapsConstants.LOSE_MSG;
import static com.example.crapsGame.data.constants.CrapsConstants.WIN_MSG;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

public class CrapsServiceTest {

    private CrapsService crapsService;

    @BeforeEach
    public void setUp() {
        crapsService = Mockito.spy(new CrapsService());
    }

    @Test
    public void testPlayRoundWin() {
        doReturn(7).when(crapsService).randomThrowDice();

        String result = crapsService.playRound();
        assertEquals(WIN_MSG, result);
    }

    @Test
    public void testPlayRoundLose() {
        doReturn(3).when(crapsService).randomThrowDice();

        String result = crapsService.playRound();
        assertEquals(LOSE_MSG, result);
    }

    @Test
    public void testPlayRoundContinueAndThenWin() {
        doReturn(5, 5).when(crapsService).randomThrowDice();

        String result = crapsService.playRound();
        assertEquals(WIN_MSG, result);
    }

    @Test
    public void testPlayRoundContinueAndThenLose() {
        doReturn(8, 7).when(crapsService).randomThrowDice();

        String result = crapsService.playRound();
        assertEquals(LOSE_MSG, result);
    }
}
