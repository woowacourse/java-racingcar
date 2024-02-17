package domain;

import dto.CarDto;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import utils.DtoMapper;
import utils.NumberGenerator;

public class Field {
    private final RacingCars racingCars;
    private final NumberGenerator numberGenerator;
    private final HashMap<Integer, List<CarDto>> record;

    public Field(RacingCars racingCars, NumberGenerator numberGenerator) {
        this.racingCars = racingCars;
        this.numberGenerator = numberGenerator;
        this.record = new LinkedHashMap<>();
    }

    public void race(int numberOfAttempts) {
        List<Car> cars = racingCars.getAllCars();
        for (int attempt = 1; attempt <= numberOfAttempts; attempt++) {
            runSingleAttempt(cars);
            recordAttempt(attempt, cars);
        }
    }

    private void runSingleAttempt(List<Car> cars) {
        for (Car car : cars) {
            int randomNumber = numberGenerator.getNumber();
            car.execute(randomNumber);
        }
    }

    private void recordAttempt(int attempt, List<Car> cars) {
        List<CarDto> carDtos = new ArrayList<>();
        for (Car car : cars) {
            carDtos.add(DtoMapper.convert(car));
        }
        record.put(attempt, carDtos);
    }

    public HashMap<Integer, List<CarDto>> getRacingRecord() {
        return record;
    }
}
