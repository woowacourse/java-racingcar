package racingcar.view;

import racingcar.domain.Car;

public class CarView {

    public void printCarStatus(final Car car) {
        StringBuilder carStatus = new StringBuilder(car.getName().value()).append(" : ");
        carStatus.append(getCarProgressBarStatus(car.getPosition()));
        OutputView.printMessage(carStatus.toString());
    }

    private StringBuilder getCarProgressBarStatus(final int carPosition) {
        StringBuilder progressBarStatus = new StringBuilder();
        for (int i = 0; i < carPosition; ++i) {
            progressBarStatus.append('-');
        }
        return progressBarStatus;
    }
}
