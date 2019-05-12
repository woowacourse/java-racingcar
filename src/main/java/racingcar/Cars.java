package racingcar;

import java.util.*;

public class Cars {
    private List<Car> cars = new ArrayList<>();

    Cars(List<String> carNames) {
        instantiateCar(carNames, cars);
    }

    Cars(List<String> carNames, List<Integer> positions) {
        instantiateCar(carNames, cars, positions);
    }

    public int getSize() {
        return cars.size();
    }

    public String getCarState(int index) {
        return cars.get(index).getCarState();
    }

    public void updateCarMovement(int index) {
        cars.get(index).moveCar(Car.randomNumberGenerator());
    }

    public int decideMaxPosition() {
        int max = 0;
        for (Car car : cars) {
            max = car.findMax(max);
        }
        return max;
    }

    public List<String> decideWinners() {
        List<String> winnersName = new ArrayList<>();
        int maxPosition = decideMaxPosition();
        for (Car car : cars) {
            car.findScoreSameAsMax(maxPosition, winnersName);
        }
        return winnersName;
    }

    public static void instantiateCar(List<String> carNames, List<Car> cars) {
        try {
            isDuplicate(carNames);
            addCarToCars(carNames, cars);
        } catch (Exception e) {
            CarGameLauncher.doCarGame();
        }
    }

    public static void instantiateCar(List<String> carNames, List<Car> cars, List<Integer> positions) {
        try {
            isDuplicate(carNames);
            addCarToCars(carNames, cars, positions);
        } catch (Exception e) {
            CarGameLauncher.doCarGame();
        }
    }

    public static void addCarToCars(List<String> carNames, List<Car> cars) {
        for (String name : carNames) {
            cars.add(new Car(name));
        }
    }

    public static void addCarToCars(List<String> carNames, List<Car> cars, List<Integer> positions) {
        for (int i = 0, n = carNames.size(); i < n; i++) {
            cars.add(new Car(carNames.get(i), positions.get(i)));
        }
    }

    public static boolean isDuplicate(List<String> names) {
        Set<String> nameSet = new HashSet<>(names);
        if (names.size() != nameSet.size()) {
            System.out.println("이름에 중복이 있습니다!");
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars1 = (Cars) o;
        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}
