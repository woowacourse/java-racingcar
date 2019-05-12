/*
 * @(#)Main.java
 *
 * v 2.0.0
 *
 * 2019.05.11
 *
 * Copyright (c) 2019 MrKwon, imkimheejoo.
 * WoowahanTechCamp, Seoul, KOREA
 * All right Reserved
 */

package racing;

import java.util.ArrayList;
import java.util.List;

import racing.domain.Car;
import racing.domain.RacingGame;
import racing.view.InputView;
import racing.view.OutputView;

/**
 * 레이싱 게임을 진행하는 컨트롤러 클래스
 *
 * @author imkimheejoo
 * @author MrKwon
 * @version 2.0.0
 * @see InputView
 * @see RacingGame
 */
public class Main {
    private static final String CAR_NAMES_INVALID_ERROR = "레이싱 게임에 참여할 이름들을 입력해주세요.";

    public static void main(String[] args) {
        InputView inputView = new InputView();
        List<Car> cars = getCars(inputView);
        int runs = getRuns(inputView);
        runRacingGame(runs, new RacingGame(cars));
    }

    private static List<Car> getCars(InputView inputView) {
        OutputView.printMessageCarNames();
        String[] cars = inputView.getCarNames();
        return makeCarListFromArray(cars);
    }

    private static List<Car> makeCarListFromArray(String[] carNames) {
        validInputs(carNames);
        List<Car> carArrayList = new ArrayList<>();
        for (String carName : carNames) {
            Car tmpCar = new Car(carName);
            carArrayList.add(tmpCar);
        }
        return carArrayList;
    }

    private static void validInputs(String[] carNames) {
        if (carNames.length == 0) {
            throw new IllegalArgumentException(CAR_NAMES_INVALID_ERROR);
        }
    }

    private static int getRuns(InputView inputView) {
        OutputView.printMessageRuns();
        return inputView.getRuns();
    }

    private static void runRacingGame(int runs, RacingGame racingGame) {
        OutputView.printResultTitle();
        for (int i = 0; i < runs; i++) {
            OutputView.printEachGameResult(racingGame.runEachGame());
        }
        OutputView.printResultTotal(racingGame);
    }
}
