package domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarGroupTest {

    @DisplayName("자동차 대수가 1대인 경우 예외가 발생한다.")
    @Test
    void throwExceptionWhenNumberOfCarsIsOne() {
        List<String> names = List.of("1");

        assertThatThrownBy(()-> new CarGroup(names))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 대수가 50대를 초과한 경우 예외가 발생한다.")
    @Test
    void throwExceptionWhenNumberOfCarsIsOverFifty() {
        List<String> names = new ArrayList<>();

        for (int i = 0; i < 51; i++) {
            names.add(i+"");
        }

        assertThatThrownBy(()-> new CarGroup(names))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복된 자동차 이름이 존재하는 경우 예외가 발생한다.")
    @Test
    void throwExceptionWhenNameOfCarsIsDuplicate() {
        List<String> names= List.of("1","1","3");

        assertThatThrownBy(()-> new CarGroup(names))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이름이 정상적으로 입력된 경우는 예외가 발생하지 않는다.")
    @Test
    void createCarGroup() {
        List<String> names= List.of("1","2","3");
        assertDoesNotThrow(() -> new CarGroup(names));
    }
}