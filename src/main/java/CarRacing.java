import domain.Car;
import view.OutputView;

import java.util.ArrayList;
import java.util.Random;

public class CarRacing {
    public static final int MAX_RAND = 10;
    public static final int TOL_FOR_CAR = 4;

    public void play(ArrayList<Car> cars, int n) {
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> indiceMoved = moveCars(cars.size());
            for (Integer carIndex : indiceMoved) {
                cars.get(carIndex).Move();
            }
            OutputView.printCars(cars);
        }
        ArrayList<Car> winningCars = new ArrayList<Car>();
        OutputView.printWinningCars(winningCars);
    }

    private ArrayList<Integer> moveCars(int totalCarNumber) {
        Random random = new Random();
        ArrayList<Integer> indexMoved = new ArrayList<>();
        for (int i = 0; i < totalCarNumber; i++) {
            if (random.nextInt(10) >= 4) {
                indexMoved.add(i);
            }
        }
        return indexMoved;
    }

    private ArrayList<Car> getWinningCars(ArrayList<Car> cars) {
        ArrayList<Car> winningCars = new ArrayList<>();
        Car carAtMaxPos = cars.get(0);
        for (Car car : cars) {
            int comp = car.compareTo(carAtMaxPos);
            if (comp > 0) {
                winningCars.clear();
                winningCars.add(car);
                carAtMaxPos = car;
            }
            if (comp == 0) {
                winningCars.add(car);
            }
        }
        return winningCars;
    }
}
