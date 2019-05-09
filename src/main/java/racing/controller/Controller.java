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

import racing.domain.CarList;

/**
 * 게임 실행에 관한 컨트롤러 클래스
 *
 * @author imkimheejoo
 * @author kwonmc
 * @version 1.0.0
 */
public class Controller {
    public static final String INVALID_NAME_EXCEPTION_MESSAGE = "이름을 입력해주세요 !";

    private static final int GO_FORWARD_CRITERIA = 4;

    private static CarList carList = new CarList();

    public static void makeCarList(String carNames) {
        String[] names = carNames.split(",");
        if (names.length == 0) {
            throw new IllegalArgumentException(INVALID_NAME_EXCEPTION_MESSAGE);
        }
        carList.addCars(names);
    }

    public static void setGamePlayNumber(int number) {
        carList.setTotalTimes(number);
    }

    public static String makeResultString() {
        return carList.toString();
    }

    public static String getWinners() {
        List<String> winnerList = carList.getWinnerList();
        return String.join(", ", winnerList);
    }

    public static int generateRandomNumber() {
        return (int) (Math.random() * 10);
    }

    public static boolean move(int randomNum) {
        return randomNum >= GO_FORWARD_CRITERIA;
    }
}
