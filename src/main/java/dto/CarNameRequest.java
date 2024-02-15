package dto;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import domain.Car;
import domain.Cars;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public record CarNameRequest(List<String> carNames) {
    public Cars toCars() {
        return carNames.stream()
                .map(Car::fromName)
                .collect(collectingAndThen(toList(), Cars::from));
    }
}
