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
    private static final int GO_FORWARD_CRITERIA = 4;

    public static String[] splitNames(String carNames) {
        String[] names = carNames.split(",");
        if (names.length == 0) {
            throw new IllegalArgumentException("이름을 입력해주세요 !");
        }
        return names;
    }

    public static String getWinners(CarList carList) {
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
