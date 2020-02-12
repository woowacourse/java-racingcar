package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

@DisplayName("자동차 객체 테스트")
public class CarTest {
    @ParameterizedTest
    @CsvFileSource(resources = "/racingtestcase/illegalCarNameTestcase.csv")
    @DisplayName("잘못된 이름으로 객체생성을 시도할 때 테스트")
    void illegalCarNameTest(String illegalName) {
        assertThatThrownBy(() -> new Car(illegalName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자 이하의 비어있지 않은 이름이어야 합니다.");
    }

    @Test
    @DisplayName("자동차의 위치가 예상 범위안에 있는지 테스트")
    void moveTest() {
        Car testCar = new Car("test");
        for (int i = 0; i < 10; i++) {
            assertThat(testCar.getDistance()).isBetween(0,i);
        }
    }
}



