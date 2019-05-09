package racingcar;

public class OutputView {
    public static void printCarStatus(Car car) {
        String carStatus = car.getName() + " : ";
        for (int i = 0; i < car.getPosition(); i++) {
            carStatus += "-";
        }
        System.out.println(carStatus);
    }
}
