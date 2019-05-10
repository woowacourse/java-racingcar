/*
 * @(#)RacingView.java
 *
 * v 2.0.0
 *
 * 2019.05.11
 *
 * Copyright (c) 2019 MrKwon, imkimheejoo
 * WoowahanTechCamp, Seoul, KOREA
 * All right Reserved
 */

package racing.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import racing.domain.Car;
import racing.domain.RacingGame;


/**
 * 레이싱 게임에 필요한 입력, 출력을 받는 뷰 클래스
 *
 * @author imkimheejoo
 * @author MrKwon
 * @version 2.0.0
 */
public class RacingView {
    private static final int INT_ZERO = 0;
    private static final String CAR_NAME_REQUEST_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String CAR_NAME_INPUT_DELIMITER = ",";
    private static final String CAR_NAMES_INVALID_ERROR = "레이싱 게임에 참여할 이름들을 입력해주세요.";
    private static final String TIMES_REQUEST_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String TIMES_INVALID_MESSAGE = "이동 횟수는 양수입니다.";
    private static final String RESULT_EACH_GAME_MESSAGE = "%s : %s\n";
    private static final String RESULT_TITLE_MESSAGE = "\n실행 결과";
    private static final String RESULT_TOTAL_MESSAGE = "가 최종 우승했습니다.";

    private final Scanner sc = new Scanner(System.in);

    public List<Car> getCarNames() {
        try {
            String[] tmp = sc.next().split(CAR_NAME_INPUT_DELIMITER);
            return makeCarListFromArray(tmp);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getCarNames();
        }
    }

    private List<Car> makeCarListFromArray(String[] carNames) {
        validInputs(carNames);
        List<Car> carArrayList = new ArrayList<>();
        for (String carName : carNames) {
            Car tmpCar = new Car(carName);
            carArrayList.add(tmpCar);
        }
        return carArrayList;
    }

    private void validInputs(String[] carNames) {
        if (carNames.length == 0) {
            throw new IllegalArgumentException(CAR_NAMES_INVALID_ERROR);
        }
    }

    public int getRuns() {
        try {
            return validRuns();
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return getRuns();
        }
    }

    private int validRuns() {
        int runs = sc.nextInt();
        if (runs <= 0) {
            throw new IllegalArgumentException(TIMES_INVALID_MESSAGE);
        }
        return runs;
    }

    public void printMessageCarNames() {
        System.out.println(CAR_NAME_REQUEST_MESSAGE);
    }

    public void printMessageRuns() {
        System.out.println(TIMES_REQUEST_MESSAGE);
    }

    public void printResultTitle() {
        System.out.println(RESULT_TITLE_MESSAGE);
    }

    public void printEachGameResult(RacingGame racingGame) {
        for (Car car : racingGame.getCars()) {
            System.out.printf(RESULT_EACH_GAME_MESSAGE, car.getName(), car.getStringPosition());
        }
        System.out.println();
    }

    public void printResultTotal(RacingGame racingGame) {
        String[] resultArray = getWinners(racingGame);
        String result = String.join(", ", resultArray);
        System.out.println(result + RESULT_TOTAL_MESSAGE);
    }

    private String[] getWinners(RacingGame racingGame) {
        int maxPosition = Collections.max(racingGame.getCars()).getPosition();
        String[] result = new String[countWinnerNumber(maxPosition, racingGame)];

        int index = INT_ZERO;
        for (Car car : racingGame.getCars()) {
            if (car.getPosition() == maxPosition) {
                result[index] = car.getName();
                index++;
            }
        }

        return result;
    }

    private int countWinnerNumber(int number, RacingGame racingGame) {
        int result = INT_ZERO;
        for (Car car : racingGame.getCars()) {
            if (car.getPosition() == number) {
                result++;
            }
        }
        return result;
    }
}
