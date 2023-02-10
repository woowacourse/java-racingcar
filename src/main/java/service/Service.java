package service;

import domain.Car;
import domain.Cars;
import vo.Name;
import dto.Result;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Service {
    private final Cars cars;

    public Service(Cars cars) {
        this.cars = cars;
    }

    public void setCars(List<Name> names) {
        validateDuplication(names);
        for (Name carName : names) {
            cars.saveCar(new Car(carName));
        }
    }

    public void move() {
        cars.move();
    }

    public Result getResult() {
        return cars.getResult();
    }

    public List<Name> getWinners() {
        return cars.getWinners();
    }

    private void validateDuplication(List<Name> names) {
        Set<Name> namesWithoutDuplication = new HashSet<>(names);
        if(names.size() != namesWithoutDuplication.size()) {
            throw new IllegalArgumentException("중복된 이름은 사용할 수 없습니다.");
        }
    }
}
