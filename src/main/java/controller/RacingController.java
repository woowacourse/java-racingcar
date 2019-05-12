package controller;

import domain.*;
import view.InputView;
import view.OutputView;

public class RacingController {

    public static void main(String[] args) {
        Race race = new Race(InputView.setCarsOnRace(), InputView.setRoundCount());
        Winners winners = new Winners(race.moveAllCarsByRoundCount());
        OutputView.outputGameResultTile();
        OutputView.outputGameResult(race.toString());
        OutputView.outputWinners(winners.getRaceWinners());
    }
}
