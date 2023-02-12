package service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import domain.Cars;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarFactoryTest {

    @DisplayName("입력 받은 자동차 이름들로 Car 객체를 생성하여 이를 관리하는 Cars 생성 테스트")
    @ParameterizedTest
    @CsvSource(value = {"kim:true", "lee:true", "park:false"}, delimiter = ':')
    void buildCarsTest(String name, boolean expected) {
        Cars cars = CarFactory.buildCars(List.of("kim", "lee"));
        boolean actual = String.join("", cars.getTotalStatus()).contains(name);
        assertEquals(expected, actual);
    }
}