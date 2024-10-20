package com.example.crapsGame.controller;

import com.example.crapsGame.data.dto.*;
import com.example.crapsGame.service.CrapsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/craps")
public class CrapsController {
    private final CrapsService crapsService;

    @Autowired
    public CrapsController(CrapsService crapsService) {
        this.crapsService = crapsService;
    }

    @PostMapping("/play-round")
    public RoundResponseDTO playSingleRound(@RequestBody RoundRequestDTO request) {
        String result = crapsService.playRound();
        int totalWin = crapsService.calculateWin(result, request.getStake());

        RoundDetailsDTO roundDetails = new RoundDetailsDTO(crapsService.getThrowHistory());

        return new RoundResponseDTO(request.getStake(), request.getGameType(), result, totalWin, roundDetails);
    }

    @PostMapping("/play-n-rounds")
    public ExtendedGameResponseDTO playMultipleRounds(@RequestBody ExtendedGameRequestDTO request) {
            int totalStakes = request.getStake() * request.getRounds();
            int totalWins = 0;
            int numberWins = 0;

            for (int i = 0; i < request.getRounds(); i++) {
                String result = crapsService.playRound();
                int winAmount = crapsService.calculateWin(result, request.getStake());
                totalWins += winAmount;

                if (winAmount > 0) {
                    numberWins++;
                }
            }

            double winToStakeRatio = (double) totalWins / totalStakes;

            return new ExtendedGameResponseDTO(totalStakes, totalWins, winToStakeRatio, numberWins);
    }

}
