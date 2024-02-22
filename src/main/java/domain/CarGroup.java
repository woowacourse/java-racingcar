package domain;

import dto.CarDto;
import dto.ResultDto;
import utils.PowerGenerator;
import utils.RandomPowerGenerator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarGroup {
    private final List<Car> carGroup;
    private final PowerGenerator powerGenerator;

    public CarGroup(final String[] carNames) {
        this.carGroup = Arrays.stream(carNames)
                .map(Car::new)
                .collect(Collectors.toList());
        this.powerGenerator = new RandomPowerGenerator();
    }

    CarGroup(final String[] carNames, final PowerGenerator powerGenerator) {
        this.carGroup = Arrays.stream(carNames)
                .map(Car::new)
                .collect(Collectors.toList());
        this.powerGenerator = powerGenerator;
    }

    public ResultDto move() {
        for (Car car : carGroup) {
            car.move(powerGenerator.getNumber());
        }
        return ResultDto.toDto(carGroup);
    }

    public List<CarDto> getWinners() {
        final int positionMax = getPositionMax();

        if (positionMax == 0) {
            return List.of();
        }

        return carGroup.stream()
                .filter(car -> car.isPositionedAt(positionMax))
                .map(CarDto::toDto)
                .toList();
    }

    private int getPositionMax() {
        return carGroup.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}
