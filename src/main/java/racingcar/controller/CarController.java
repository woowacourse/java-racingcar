package racingcar.controller;

import racingcar.domain.Car;
import racingcar.view.Output;

import java.util.ArrayList;
import java.util.List;

public class CarController {
    public static void raceStart(List<Car> carList, int tryNum) {
        System.out.println("실행 결과");
        for(int i=0; i<tryNum; i++){
            move(carList);
            Output.racePrint(carList);
        }
    }

    private static void move(List<Car> carList) {
        for(Car car : carList) {
            car.goForward();
        }
    }

    public static void finalWinner(List<Car> carList) {
        // 1. 최고 위치찾기
        // 2. 같은 위치 우승자 -> 배열
        // 3. 출력 : pobi, honux가 최종 우승했습니다.
        int maxPosition = findMaxPosition(carList);
        List<String> winnerList = getWinnerList(carList, maxPosition);
        Output.winnerPrint(winnerList);
    }

    private static List<String> getWinnerList(List<Car> carList, int maxPosition) {
        List<String> winnerList = new ArrayList<>();
        for (Car car : carList) {
            if (car.getPosition() == maxPosition){
                winnerList.add(car.getName());
            }
        }
        return winnerList;
    }

    private static int findMaxPosition(List<Car> carList) {
        int maxNum = 0;

        for (Car car : carList) {
            if (car.getPosition() > maxNum){
                maxNum = car.getPosition();
            }
        }
        return maxNum;
    }
}
