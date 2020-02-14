package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarFactoryTest {

    @Test
    @DisplayName("차를 한 대만 입력할 경우")
    void oneCarExceptionTest() {
        assertThatThrownBy(() -> {
            CarFactory carFactory = new CarFactory("hiro");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1대만 있으면 경기를 진행할 수 없습니다");
    }

    @Test
    @DisplayName("중복된 이름이 있을 경우")
    void duplicateNameTest() {
        assertThatThrownBy(() -> {
            CarFactory carFactory = new CarFactory("hiro, hiro");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 이름");
    }
}