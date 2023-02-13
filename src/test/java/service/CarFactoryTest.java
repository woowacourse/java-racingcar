package service;

import domain.Car;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarFactoryTest {

    @DisplayName("입력 받은 문자열 리스트를 통해 각각 Car 객체를 생성하고, 이를 토대로 Car가 연속으로 담긴 List 생성")
    @ParameterizedTest
    @ValueSource(strings = {"kim", "lee", "park"})
    void buildCars(String name) {
        List<Car> cars = CarFactory.buildCars(List.of("kim", "lee", "park"));
        Assertions.assertThat(
            cars.stream().anyMatch(
                car -> car.getName().equals(name)
            )
        ).isTrue();
    }
}