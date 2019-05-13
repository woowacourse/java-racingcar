package racingcar;

import racingcar.view.InputView;

import java.util.*;

public class Cars {
    private List<Car> cars = new ArrayList<>();

    Cars(List<String> carNames) {
        checkConditionsForCarNames(carNames);
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public static Cars prepareCarsForRacing() {
        try {
            List<String> carNames = InputView.askAndReceiveCarNames();
            Cars cars = new Cars(carNames);
            return cars;
        } catch (Exception e) {
            return prepareCarsForRacing();
        }

    }
    private static void checkConditionsForCarNames(List<String> carNames) {
        if (isDuplicate(carNames)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isDuplicate(List<String> names) {
        Set<String> nameSet = new HashSet<>(names);
        if (names.size() != nameSet.size()) {
            System.out.println("이름에 중복이 있습니다!");
            return true;
        }
        return false;
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
        for (int i = 0, n = this.cars.size(); i < n; i++) {
            max = cars.get(i).findMax(max);
        }
        return max;
    }

    public List<String> decideWinners(int maxPosition) {
        List<String> winnersName = new ArrayList<>();
        for (int i = 0; i < cars.size(); i++) {
            cars.get(i).findScoreSameAsMax(maxPosition, winnersName);
        }
        return winnersName;
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
