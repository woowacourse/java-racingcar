package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarsTest {
    @DisplayName("Cars 생성 메소드 - 리스트 인자의 최소 개수 미충족에 의한 예외 발생 테스트")
    @Test
    public void validSizeOfCarNamesExceptionTest() {
        List<String> cars = Arrays.asList("car");

        assertThatThrownBy(() -> Cars.of(cars)).isInstanceOf(IllegalArgumentException.class);
    }
}
