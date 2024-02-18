package model;

import static org.assertj.core.api.Assertions.assertThatNoException;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Nested
    @DisplayName("중복된 자동차 이름이 존재하는지 테스트")
    class CarNameTest {

        @Test
        @DisplayName("자동차 이름이 모두 유니크하면 클래스가 정상 생성된다")
        void validateNotDuplicatedCarName() {
            assertThatNoException().isThrownBy(() -> new Cars("호기,재즈,상돌,아루"));
        }

        @Test
        @DisplayName("중복된 자동차 이름이 존재하면 에러를 발생시킨다.")
        void validateDuplicatedCarName() {
            Assertions.assertThatThrownBy(() -> new Cars("호기,재즈,상돌,아루,상돌"))
                    .isInstanceOf(IllegalArgumentException.class).hasMessage("중복된 이름의 자동차는 사용할 수 없습니다.");
        }
    }

    @Nested
    @DisplayName("경주에 참여하는 자동차의 수를 테스트")
    class NumberOfCarsSizeTest {
        @Test
        @DisplayName("경주에 참여하는 자동차의 수가 2대 이상이라면 클래스가 정상 생성된다.")
        void validateNumberOfCarsIsOver2() {
            assertThatNoException().isThrownBy(() -> new Cars("호기,재즈,상돌,아루"));
        }

        @Test
        @DisplayName("경주에 참여하는 자동차의 수가 2대 미만이라면 에러를 발생시킨다.")
        void validateNumberOfCarsIsLess2() {
            Assertions.assertThatThrownBy(() -> new Cars("호기"))
                    .isInstanceOf(IllegalArgumentException.class).hasMessage("레이스에 참여하는 자동차는 최소 2대 이상이어야 합니다.");
        }
    }
}
