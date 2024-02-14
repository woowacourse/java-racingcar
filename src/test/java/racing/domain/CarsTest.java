package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CarsTest {

    @Test
    @DisplayName("정상적인 Cars 객체 생성")
    void createCars(){
        assertDoesNotThrow(()->new Cars("pobi,crong,honux"));
    }

    @Test
    @DisplayName("겹치는 자동차 이름이 존재하면 예외")
    void createCarsWithDuplicateName(){
        assertThatThrownBy(()->new Cars("pobi, pobi"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}