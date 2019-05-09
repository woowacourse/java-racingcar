/*
 * @(#)RacingGame.java
 *
 * v 1.0.0
 *
 * 2019.05.08
 *
 * Copyright (c) 2019 MrKwon, imkimheejoo
 * WoowahanTechCamp, Seoul, KOREA
 * All right Reserved
 */

package racing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import racing.domain.Car;

/**
 * 레이싱 게임 한판 진행을 위한 클래스
 *
 * @author imkimheejoo
 * @author MrKwon
 * @version 1.0.0
 * @see Car
 */
class RacingGame {
    private static final String INPUT_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분.";
    private static final String INPUT_TIMES_MESSAGE = "시도할 횟수는 몇회인가요?";
    private static final String PROCESS_RESULT_MESSAGE = "실행결과";
    private static final String FINAL_WINNER_MESSAGE = "가 최종 우승했습니다.";
    private static final String INPUT_TIMES_EXCEPTION = "이동 횟수는 양수입니다 !";

    private ArrayList<Car> carList = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
    private int totalTimes;

    // 단위테스트용
//    void setCarList(ArrayList<Car> carList) {
//        this.carList = carList;
//    }

    // View 역할, 입력받는 기능
    void inputCarNames() {
        System.out.println(INPUT_NAMES_MESSAGE);
        String[] carNames = sc.nextLine().split(",");
        try {
            // TODO : 이 로직은 CarList 의 메소드를 호출해서 처리해야 하는 로직
            for (String carName : carNames) {
                Car car = new Car(carName);
                carList.add(car); // TODO : 모델의 add 메서드로 수정해야 하는 부분
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            inputCarNames();
        }
    }

    // View 역할, 입력받는 기능
    void inputTotalTimes() {
        try {
            // TODO : totalTimes 를 새로운 지역 변수로 만들고 CarList 클래스에 전달하고 세팅
            System.out.println(INPUT_TIMES_MESSAGE);
            totalTimes = Integer.parseInt(sc.nextLine());
            if (totalTimes <= 0) {
                throw new IllegalArgumentException(INPUT_TIMES_EXCEPTION);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            inputTotalTimes();
        }
    }

    // TODO : CarList 객체를 호출해서 toString 으로 출력하는 메서드 생성
    // public void printRacingResult() {  }

    // View 역할, 출력하는 기능
    private void printOneTimeResult() {
        // TODO : CarList 의 toString 을 오버라이딩
        for (Car car : carList) {
            System.out.println(car.toString());
        }
        System.out.println();
    }

    // View 역할, 출력하는 기능
    private void playOneTime() {
        // TODO : CarList 의 toString 을 오버라이딩
        for (Car car : carList) {
            car.moveOneTime();
        }
    }

    // View 역할, 출력하는 기능
    void printAllTimeResult() {
        // TODO : CarList 의 toString 을 오버라이딩
        System.out.println(PROCESS_RESULT_MESSAGE);
        printOneTimeResult(); // 최초 상태 출력

        for (int i = 0; i < totalTimes; i++) {
            playOneTime();
            printOneTimeResult();
        }
    }


    void printAllWinners() {
        List<String> winnerList = getWinnerList();
        String result = String.join(", ", winnerList);
        System.out.println(result + FINAL_WINNER_MESSAGE);
    }

    // TODO : CarList 클래스로 이주해야 하는 메소드
    private List<String> getWinnerList() {
        List<String> result = new ArrayList<>();
        Integer maxStatus = Collections.max(carList).getStatus();
        for (Car car : carList) {
            if (maxStatus.equals(car.getStatus())) {
                result.add(car.getName());
            }
        }
        return result;
    }
}
