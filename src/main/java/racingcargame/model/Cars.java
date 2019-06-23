package racingcargame.model;

import java.util.*;

public class Cars {
    List<Car> cars = new ArrayList<>();

    public Cars(String carNames) {
        List<String> names = new ArrayList<>(Arrays.asList(carNames.split(",")));
        checkDuplicateNames(names);
        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    private static void checkDuplicateNames(List<String> names) {
        Set<String> namesWithoutDuplicates = new HashSet<>(names);
        if (names.size() != namesWithoutDuplicates.size()) {
            System.out.println("입력이 잘못되었습니다!");
            throw new IllegalArgumentException("중복된 이름이 존재합니다.\n다시 입력해주세요.");
        }
    }

    public Cars moveTheCars(List<Integer> randomNumbers) {
        for (int i = 0, n = cars.size(); i < n; i++) {
            Car movedCar = cars.get(i).move(randomNumbers.get(i));
            cars.remove(i);
            cars.add(i, movedCar);
        }
        return new Cars(new ArrayList<>(this.cars));
    }

    public int getSize() {
        return cars.size();
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
