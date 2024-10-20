package com.example.crapsGame.service;

import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.example.crapsGame.data.constants.CrapConstants.LOSE_MSG;
import static com.example.crapsGame.data.constants.CrapConstants.WIN_MSG;

@Service
public class CrapsService {
    @Getter
    private List<Integer> throwHistory;
    private final Random rand = new Random();

    public String playRound() {
        throwHistory = new ArrayList<>();
        int throwDice = randomThrowDice();

        if (throwDice == 7 || throwDice == 11) {
            return WIN_MSG;
        } else if (throwDice == 2 || throwDice == 3 || throwDice == 12) {
            return LOSE_MSG;
        } else {
            return continueGame(throwDice);
        }
    }

    private String continueGame(int playerPoint) {
        int throwDice;
        do {
            throwDice = randomThrowDice();
            if (throwDice == playerPoint) {
                return WIN_MSG;
            }
        } while (throwDice != 7);
        return LOSE_MSG;
    }

    public int calculateWin(String result, int stake) {
        if (result.equals(WIN_MSG)) {
            return stake * 2;
        }
        return 0;
    }

    private int randomThrowDice() {
       int throwDice = rand.nextInt(6) + 1 + rand.nextInt(6) + 1;
        throwHistory.add(throwDice);
        return throwDice;
    }
}
