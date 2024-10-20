package com.example.crapsGame.data.dto;

import lombok.Getter;

import static com.example.crapsGame.data.constants.CrapsConstants.INVALID_GAME_MSG;
import static com.example.crapsGame.data.constants.CrapsConstants.INVALID_STAKE_MSG;
import static com.example.crapsGame.data.constants.CrapsConstants.INVALID_ROUNDS_MSG;
import static com.example.crapsGame.data.constants.CrapsConstants.CRAPS_MSG;

@Getter
public class ExtendedGameRequestDTO {
    private int stake;
    private String gameType;
    private int rounds;

    public void setStake(int stake) {
        if (stake == 1) {
            this.stake = stake;
        } else {
            throw new IllegalArgumentException(INVALID_STAKE_MSG);
        }
    }

    public void setGameType(String gameType) {
        if (gameType.equals(CRAPS_MSG)) {
            this.gameType = gameType;
        } else {
            throw new IllegalArgumentException(INVALID_GAME_MSG);
        }
    }

    public void setRounds(int rounds) {
        if (rounds >= 2) {
            this.rounds = rounds;
        } else {
            throw new IllegalArgumentException(INVALID_ROUNDS_MSG);
        }
    }
}
