package com.example.crapsGame.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class RoundDetailsDTO {
    private List<Integer> throwHistory;
}
