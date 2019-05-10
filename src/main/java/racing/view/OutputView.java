package racing.view;

import racing.domain.Car;

import java.util.Iterator;
import java.util.List;

public class OutputView {
    public static void printRace(final List<Car> carList) {
        Iterator<Car> it = carList.iterator();
        while (it.hasNext()) {
            Car car = it.next();
            System.out.println(car);
        }
        System.out.println();
    }

    public static void printResult(final List<Car> winnerCars) {
        for (int i = 0; i < winnerCars.size() - 1; i++) {
            winnerCars.get(i).printName();
            System.out.print(", ");
        }
        winnerCars.get(winnerCars.size() - 1).printName();
        System.out.println("가 최종 우승했습니다.");
    }
}
