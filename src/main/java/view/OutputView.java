package view;

import domain.Cars;

public class OutputView {
    public void printCarsDistance(Cars cars) {
        for (int i = 0; i < cars.getCarsSize(); i++) {
            String carName = cars.getCar(i).getCarName();
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < cars.getCar(i).getDistance(); j++) {
                sb.append('-');
            }
            System.out.println(carName + " : " + sb);
        }
        System.out.println();
    }

    public String carDistance(Cars cars) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cars.getCar(i).getDistance(); i++) {
            sb.append('-');
        }
        return sb.toString();
    }
}
