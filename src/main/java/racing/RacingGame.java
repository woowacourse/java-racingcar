package racing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class RacingGame {
    private ArrayList<Car> carList = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public void setCarList(ArrayList<Car> carList) {
        this.carList = carList;
    }

    public void getCarNames() {
        String[] carNames = sc.nextLine().split(",");
        for (String carName : carNames) {
            Car car = new Car(carName);
            carList.add(car);
        }
    }

    public void printOneTimeResult() {
        for (Car car : carList) {
            System.out.println(car.toString());
        }
    }

    public void printAllWinners() {
        List<String> winnerList = getWinnerList();
        String result = String.join(", ", winnerList);
        System.out.println(result + "가 최종 우승했습니다.");
    }

    public List<String> getWinnerList() {
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
