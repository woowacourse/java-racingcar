package racinggame.controller;

import racinggame.domain.*;
import racinggame.view.InputView;
import racinggame.view.OutputView;

public class Main {
    public static void main(String... args) {
        Names names = new Names(InputView.inputName());
        Repeat repeat = new Repeat(InputView.inputRepeat());
        Cars cars = RacingGame.makeCars(names);
        int maxPosition = 0;

        OutputView.printResultFormat();
        for(int i=0;i<repeat.getRepeat();i++){
            maxPosition = RacingGame.moveCars(cars, maxPosition);
            OutputView.printCarsLog(cars);
        }
        Winners winners = cars.makeWinners(maxPosition);
        OutputView.printWinnersLog(winners);
    }

}

