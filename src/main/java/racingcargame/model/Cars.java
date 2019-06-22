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

    public Cars cloneCars() {
        List<String> names = new ArrayList<>();
        for (Car car : cars) {
            StringBuilder sb = new StringBuilder();
            sb.append(car.getName());
            names.add(sb.toString());
        }
        String carNames = String.join(",", names);
        return new Cars(carNames);
    }

    public Cars moveTheCars(List<Integer> randomNumbers) {
        for (int i = 0, n = cars.size(); i < n; i++) {
            Car movedCar = cars.get(i).update(randomNumbers.get(i));
            cars.remove(i);
            cars.add(i, movedCar);
        }
        return this;
    }

    public int getSize() {
        return cars.size();
    }

    public List<Car> getCars() {
        return this.cars;
    }
}
