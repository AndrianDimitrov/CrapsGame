package com.example.crapsGame.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RoundResponseDTO {
    private int stake;
    private String gameType;
    private String result;
    private int totalWin;
    private RoundDetailsDTO roundDetails;
}
