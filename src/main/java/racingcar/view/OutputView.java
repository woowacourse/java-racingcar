/*
 * Copyright (c) 2020 by 티거, 제이미
 * All rights reserved.
 *
 * @author      티거, 제이미
 * @version     1.0
 * @date        11 Feb 2020
 *
 */

package racingcar.view;

import java.util.List;
import java.util.Map;
import racingcar.domain.Car;
import racingcar.domain.RacingResults;

public class OutputView {

    private final static String CAR_DELIMITER = " : ";
    private final static String CAR_PROGRESS_SIGN = "-";
    private final static String WINNER_DELIMITER = ", ";

    public static void printInputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public static void printInputTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printExecutionResult() {
        System.out.println("\n실행 결과");
    }

    public static void printString(String string) {
        System.out.println(string);
    }

    public static void printResultFactory(RacingResults racingResults) {
        int size = racingResults.size();
        for (int i = 1; i <= size; i++) {
            parseResult(racingResults.getEpisodeResult(i));
            System.out.println();
        }
    }

    private static void parseResult(Map<Car, Integer> carIntegerMap) {
        for (Car car : carIntegerMap.keySet()) {
            System.out.print(car.getName());
            System.out.print(CAR_DELIMITER);
            for (int i = 0; i < carIntegerMap.get(car); i++) {
                System.out.print(CAR_PROGRESS_SIGN);
            }
            System.out.println();
        }
    }

    public static void printWinner(List<String> winners) {
        System.out.print(String.join(WINNER_DELIMITER, winners));
        System.out.println("가 최종 우승했습니다.");
    }
}
