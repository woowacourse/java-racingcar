package view;

import model.Cars;

public class OutputView {
    public static void printResultHeader() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void printCarNameAndPosition(Cars cars) {
        cars.getCars()
                .forEach(car ->
                        System.out.printf("%s : %s%n", car.getName(), "-".repeat(car.getPosition()))
                );
        System.out.println();
    }
}
