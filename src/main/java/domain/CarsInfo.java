package domain;

import util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

//TODO : 클래스 네이밍 수정
//TODO : .연산자 개행
//TODO : getCarsInfo() 반환 코드 불변으로 수정
public class CarsInfo {
    private final List<Car> carsInfo = new ArrayList<>();

    public CarsInfo(List<String> carNames) {
        checkNameDuplication(carNames);
        addCar(carNames);
    }

    private void checkNameDuplication(List<String> carNames) {
        long uniqueNameCount = carNames.stream()
                .distinct()
                .count();
        if (uniqueNameCount != carNames.size()) {
            throw new IllegalArgumentException("중복되는 자동차 이름이 존재합니다.");
        }
    }

    private void addCar(List<String> carNames) {
        for (String carName : carNames) {
            carsInfo.add(new Car(carName));
        }
    }

    public List<String> findWinners() {
        Integer maxDistance = findMaxDistance();
        return carsInfo.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .map(Car::getCarName)
                .collect(Collectors.toList());
    }

    private Integer findMaxDistance() {
        return carsInfo.stream()
                .mapToInt(Car::getDistance)
                .max().
                orElseThrow(NoSuchFieldError::new);
    }

    public void progressRound(RandomNumberGenerator randomNumberGenerator, RoundResult roundResult) {
        for (Car car : carsInfo) {
            Integer randomNumber = randomNumberGenerator.generateRandomNumber();
            boolean movingResult = roundResult.isGo(randomNumber);
            car.move(movingResult);
        }
    }

    public List<Car> getCarsInfo() {
        return Collections.unmodifiableList(carsInfo);
    }
}
