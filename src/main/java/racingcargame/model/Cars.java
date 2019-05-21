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

    private static void checkDuplicateNames(List<String> names) {
        Set<String> namesWithoutDuplicates = new HashSet<>(names);
        if (names.size() != namesWithoutDuplicates.size()) {
            throw new IllegalArgumentException("중복된 이름이 존재합니다.\n다시 입력해주세요.");
        }
    }

    public void



}
