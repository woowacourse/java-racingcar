package view;

import model.Car;
import model.CarStatus;

import java.util.List;

public class OutputView {
    public void printResultComment() {
        System.out.println("실행 결과");
    }
    public void printResult(List<Car> cars) {
        for(Car car : cars) {
            System.out.println(car.getName() + " : " + printResultDetail(car.getStatuses()));
        }
        System.out.println();
    }

    private String printResultDetail(List<CarStatus> carStatuses){
        return String.join("",carStatuses.stream().map(carStatus -> carStatus.getOutput()).toList());

    }
}
