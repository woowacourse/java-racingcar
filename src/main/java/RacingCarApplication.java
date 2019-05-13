/*
 * @(#)RacingCarApplication.java      1.0 2019/05/12
 *
 * Copyright (c) 2019 Hyogeon Kim,
 * Calculator, Java, Seoul, KOREA
 */
import model.LapRecorder;
import model.Winners;
import controller.RacingGameController;
import view.InputView;
import view.OutputView;

/**
 * @version 1.0 2019년 05년 12일
 * @author 김효건
 */
public class RacingCarApplication {
    /*자동차 게임을 실행시키는 메인 클래스*/
    public static void main(String[] args) throws CloneNotSupportedException {
        RacingGameController racingGameService = setRacingGame();
        LapRecorder lapRecorder = racingGameService.run();
        Winners winners = racingGameService.getWinners();
        OutputView.printGameResult(lapRecorder);
        OutputView.printWinners(winners);
    }

    private static RacingGameController setRacingGame() {
        try {
            String inputCarNames = InputView.inputCarsNames();
            String lapCount = InputView.inputLapCount();
            return new RacingGameController(inputCarNames, lapCount);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            return setRacingGame();
        }
    }
}
