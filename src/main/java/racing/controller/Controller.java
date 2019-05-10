/*
 * @(#)Controller.java
 *
 * v 1.0.0
 *
 * 2019.05.09
 *
 * Copyright (c) 2019 MrKwon, imkimheejoo.
 * WoowahanTechCamp, Seoul, KOREA
 * All right Reserved
 */

package racing.controller;

import java.util.List;

import racing.domain.CarContainer;
import racing.view.RacingGame;

/**
 * 게임 실행에 관한 컨트롤러 클래스
 *
 * @author imkimheejoo
 * @author kwonmc
 * @version 1.0.0
 */
public class Controller {
    public static final String INVALID_NAME_EXCEPTION_MESSAGE = "이름을 입력해주세요 !";
    public static final int GO_FORWARD_CRITERIA = 4;

    private static CarContainer carContainer = new CarContainer();

    public static CarContainer makeCarList(String carNames) {
        String[] names = carNames.split(",");
        validNamesEmpty(names);
        carContainer.addCars(names);
        return carContainer;
    }

    private static void validNamesEmpty(String[] names) {
        if (names.length == 0) {
            throw new IllegalArgumentException(INVALID_NAME_EXCEPTION_MESSAGE);
        }
    }

    public static void setGamePlayNumber(int number) {
        carContainer.setTotalTimes(number);
    }

    public static String makeResultString() {
        return carContainer.makeGameResult();
    }

    public static String getWinners() {
        return String.join(", ", carContainer.searchWinners());
    }

    public static boolean move(int randomNum) {
        return randomNum >= GO_FORWARD_CRITERIA;
    }

    public static void start() {
        RacingGame racingGame = new RacingGame();
        racingGame.inputCarNames();
        racingGame.inputTotalTimes();
        racingGame.printRacingResult();
        racingGame.printAllWinners();
    }
}
