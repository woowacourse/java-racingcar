package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {

    @Test
    @DisplayName("중복 이름이 있을 때 예외가 발생한다")
    void duplicateTest() {

        assertThatThrownBy(() -> new Cars("aa, aa"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복");
    }

    @Test
    @DisplayName("경기에 참여하는 차가 한대일때 예외가 발생한다")
    void oneCarTest() {

        assertThatThrownBy(() -> new Cars("aa"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("둘 이상");
    }
}