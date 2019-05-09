/*
 * @(#)RacingGame.java
 *
 * v 1.0.0
 *
 * 2019.05.09
 *
 * Copyright (c) 2019 MrKwon, imkimheejoo
 * WoowahanTechCamp, Seoul, KOREA
 * All right Reserved
 */

package racing.view;

import java.util.Scanner;

import racing.controller.Controller;
import racing.domain.Car;
import racing.domain.CarList;

/**
 * 레이싱 게임 한판 진행을 위한 클래스
 *
 * @author imkimheejoo
 * @author MrKwon
 * @version 1.0.0
 * @see Car
 */
public class RacingGame {
    private static final String INPUT_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분.)";
    private static final String INPUT_TIMES_MESSAGE = "시도할 횟수는 몇회인가요?";
    private static final String PROCESS_RESULT_MESSAGE = "실행결과";
    private static final String FINAL_WINNER_MESSAGE = "가 최종 우승했습니다.";

    private Scanner sc = new Scanner(System.in);
    private CarList carList = new CarList();

    private void inputCarNames() {
        System.out.println(INPUT_NAMES_MESSAGE);
        try {
            String[] carNames = Controller.splitNames(sc.nextLine());
            carList.addCars(carNames);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            inputCarNames();
        }
    }

    private void inputTotalTimes() {
        try {
            System.out.println(INPUT_TIMES_MESSAGE);
            int totalTimes = Integer.parseInt(sc.nextLine());
            carList.setTotalTimes(totalTimes);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            inputTotalTimes();
        }
    }

    private void printRacingResult() {
        System.out.println(PROCESS_RESULT_MESSAGE);
        System.out.println(carList.toString());
    }

    private void printAllWinners() {
        System.out.println(Controller.getWinners(carList) + FINAL_WINNER_MESSAGE);
    }

    public void start() {
        RacingGame racingGame = new RacingGame();

        racingGame.inputCarNames();
        racingGame.inputTotalTimes();
        racingGame.printRacingResult();
        racingGame.printAllWinners();
    }
}
