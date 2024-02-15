package view;

import model.Cars;

public class OutputView {

    public void writeResultMessage() {
        System.out.println();
        System.out.println("실행 결과");
    }
    public void writeRoundResult(Cars cars) {
        System.out.println(cars);
    }
}