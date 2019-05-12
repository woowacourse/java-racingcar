/*
 * @(#)OutputView.java
 *
 * v 2.0.0
 *
 * 2019.05.12
 *
 * Copyright (c) 2019 KwonMC.
 * WoowahanTechCamp, Seoul, KOREA
 * All right Reserved
 */

package racing.view;

import java.util.Collections;

import racing.domain.Car;
import racing.domain.RacingGame;

/**
 * 출력에 관련된 모든 기능이 있는 뷰 클래스
 *
 * @author kwonmc
 * @version 2.0.0
 */
public class OutputView {
    private static final String CAR_NAME_REQUEST_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TIMES_REQUEST_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String RESULT_EACH_GAME_MESSAGE = "%s : %s\n";
    private static final String RESULT_TITLE_MESSAGE = "\n실행 결과";
    private static final String RESULT_TOTAL_MESSAGE = "가 최종 우승했습니다.";

    public static void printMessageCarNames() {
        System.out.println(CAR_NAME_REQUEST_MESSAGE);
    }

    public static void printMessageRuns() {
        System.out.println(TIMES_REQUEST_MESSAGE);
    }

    public static void printResultTitle() {
        System.out.println(RESULT_TITLE_MESSAGE);
    }

    public static void printEachGameResult(RacingGame racingGame) {
        for (Car car : racingGame.getCars()) {
            System.out.printf(RESULT_EACH_GAME_MESSAGE, car.getName(), car.getStringPosition());
        }
        System.out.println();
    }

    public static void printResultTotal(RacingGame racingGame) {
        String[] resultArray = racingGame.getWinners();
        String result = String.join(", ", resultArray);
        System.out.println(result + RESULT_TOTAL_MESSAGE);
    }
}
