package com.example.crapsGame.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExtendedGameResponseDTO {
    private int totalStakes;
    private int totalWins;
    private double winToStakeRatio;
    private int numberWins;
}
