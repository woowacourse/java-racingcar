package service;

import exception.DuplicateCarNameException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarServiceTest {
    @ParameterizedTest()
    @ValueSource(strings = {"a,b,a", "b,b"})
    @DisplayName("중복된 차 이름이 입력된다면 DuplicateCarNameException 예외가 발생한다.")
    void initCars(String wrongInput) {
        CarService carService = new CarService();
        Assertions.assertThatThrownBy(() -> carService.initCars(wrongInput))
                .isInstanceOf(DuplicateCarNameException.class);
    }

}