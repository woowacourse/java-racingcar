package racing.view;

import racing.car.Cars;

public class OutputView {
    public static void printCarsInformation(Cars cars) {
        for (int i = 0; i < cars.size(); i++) {
            System.out.print(String.format("%s : ", cars.get(i).getName()));
            for (int j = 0; j < cars.get(i).getDistance(); j++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }

    public static void printWinners(Cars cars) {

    }
}
