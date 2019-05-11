/*
 * @(#)InputView.java
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
 * 레이싱 게임에 필요한 입력을 받는 뷰 클래스
 *
 * @author imkimheejoo
 * @author MrKwon
 * @version 2.0.0
 */
public class InputView {
    private static final String TIMES_INVALID_MESSAGE = "이동 횟수는 양수입니다.";
    private static final String CAR_NAME_INPUT_DELIMITER = ",";
    private static final String CAR_NAMES_INVALID_ERROR = "레이싱 게임에 참여할 이름들을 입력해주세요.";

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
}
