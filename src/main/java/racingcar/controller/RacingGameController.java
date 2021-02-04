package racingcar.controller;

import racingcar.domain.RacingGame;

import java.util.Arrays;
import java.util.List;

public class RacingGameController {
    public void start() {
        RacingGame racingGame = new RacingGame();

        //이름 Input 받아옴
        createCars(racingGame);

        //round Input 받아옴
        int round = 5;

        for (int i = 0; i < round; i++) {
            racingGame.playRound();
        }

        String winners = racingGame.decideWinner();

        //output으로 내보냄
        System.out.println(winners);
    }

    private void createCars(RacingGame racingGame) {
        List<String> names = Arrays.asList("포비","웨지","삭정");
        racingGame.makeCars(names);
    }
}
