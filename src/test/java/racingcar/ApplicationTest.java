package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import racingcar.domain.Car;
import racingcar.domain.Cars;

public class ApplicationTest {

    @Test
    void 이름_입력_예외_테스트() {
        assertThatThrownBy(() -> {
            Parser.split("abcdef,a,b");
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            Parser.split(",,");
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            Parser.split("");
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            Parser.split(null);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
