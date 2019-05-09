package racingcar;

import racingcar.controller.Controller;
import racingcar.model.CarList;
import racingcar.view.View;

public class RacingCar {
    public static void main(String[] args) {
        Controller controller = new Controller();
        CarList carList = controller.makeCarList(View.inputNameOfCar());

        int numberOfTry = View.inputNumberOfTry();
        View.outputLine("실행 결과");
        for (int i = 0; i < numberOfTry; i++) {
            carList = controller.moveCar(carList);
            View.printCars(carList);
        }
        View.printWinningCars(controller.getWinningCars(carList));
    }
}
