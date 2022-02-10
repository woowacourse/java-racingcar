package racingcar;

import java.util.List;

public class Output {
    public void printCurrentPosition(List<Car> cars) {
        cars.forEach(this::printRacingProgress);
        System.out.println();
    }

    private void printRacingProgress(Car car) {
        System.out.printf("%s : %s%n", car.getName(), getPositionString(car.getPosition()));
    }

    private String getPositionString(int position) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < position; i++) {
            builder.append("-");
        }
        return builder.toString();
    }
}
