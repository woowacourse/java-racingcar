package racing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class RacingGame {
    private static final String INPUT_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분.";
    private static final String INPUT_TIMES_MESSAGE = "시도할 횟수는 몇회인가요?";
    private static final String PROCESS_RESULT_MESSAGE = "실행결과";
    private static final String FINAL_WINNER_MESSAGE = "가 최종 우승했습니다.";

    private ArrayList<Car> carList = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
    private int totalTimes;

    void setCarList(ArrayList<Car> carList) {
        this.carList = carList;
    }

    void inputCarNames() {
        System.out.println(INPUT_NAMES_MESSAGE);
        String[] carNames = sc.nextLine().split(",");
        for (String carName : carNames) {
            Car car = new Car(carName);
            carList.add(car);
        }
    }

    void inputTotalTimes() {
        System.out.println(INPUT_TIMES_MESSAGE);
        totalTimes = Integer.parseInt(sc.nextLine());
    }

    private void printOneTimeResult() {
        for (Car car : carList) {
            System.out.println(car.toString());
        }
        System.out.println();
    }

    private void playOneTime() {
        for (Car car : carList) {
            car.moveOneTime();
        }
    }

    void printAllTimeResult() {
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

    List<String> getWinnerList() {
        List<String> result = new ArrayList<>();
        Integer maxStatus  = Collections.max(carList).getStatus();
        for (Car car : carList) {
            if (maxStatus.equals(car.getStatus())) {
                result.add(car.getName());
            }
        }
        return result;
    }
}
