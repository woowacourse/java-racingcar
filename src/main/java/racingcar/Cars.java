package racingcar;

import racingcar.util.Utils;

import java.util.*;

public class Cars {
    private List<Car> cars = new ArrayList<>();

    Cars(String names) {
        names = names.replaceAll("\\s+", "");
        List<String> carNames = new ArrayList<>(Arrays.asList(names.split(",")));
        instantiateCar(carNames);
    }

    Cars(ArrayList<Car> cars) {
        this.cars = cars;
    }

    public int getSize() {
        return cars.size();
    }

    public String getCarState(int index) {
        return cars.get(index).toString();
    }

    public void updateCarMovement() {
        for (Car car : cars) {
            car.moveCar(Utils.randomNumberGenerator());
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public void instantiateCar(List<String> carNames) {
        try {
            isDuplicate(carNames);
            addCarToCars(carNames);
        } catch (Exception e) {
            CarGameLauncher.doCarGame();
        }
    }

    public void addCarToCars(List<String> carNames) {
        for (String name : carNames) {
            cars.add(new Car(name));
        }
    }

    public static void isDuplicate(List<String> names) {
        Set<String> nameSet = new HashSet<>(names);
        if (names.size() != nameSet.size()) {
            System.out.println("이름에 중복이 있습니다!");
            throw new IllegalArgumentException();
        }
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
