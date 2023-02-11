package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CarsTest {

    @DisplayName("중복된 이름이 있으면 예외 발생")
    @Test
    void duplicateTest() {
        assertThatThrownBy(() -> Cars.from(List.of("hihi", "hihi")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("차 이름은 중복될 수 없습니다");
    }
}