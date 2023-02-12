package model.car;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.*;
import util.CarNameValidator;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarsTest {

    @Nested
    @DisplayName("비정상 입력값이 들어온 케이스")
    class invalidInputTest {

        @Test
        @DisplayName("경주에 참여하는 자동차가 1대 이하면 예외처리 한다.")
        void carNumberTest() {
            Car gitJjang = new Car("깃짱");
            List<Car> cars = new ArrayList<>(List.of(gitJjang));

            assertThatIllegalArgumentException()
                    .isThrownBy(() -> new Cars(cars))
                    .withMessage(CarNameValidator.Message.EXCEPTION_CAR_NUMBER.getMessage());
        }

        @Test
        @DisplayName("6글자 이상의 이름은 예외 처리한다.")
        void carNameLengthTest() {
            Car gitJjang = new Car("깃짱");
            Car irene = new Car("이리내이리내");
            List<Car> cars = new ArrayList<>(List.of(gitJjang, irene));

            assertThatIllegalArgumentException()
                    .isThrownBy(() -> new Cars(cars))
                    .withMessage(CarNameValidator.Message.EXCEPTION_CAR_NAME_LENGTH.getMessage());
        }

    }

    @Nested
    @DisplayName("정상 입력값이 들어온 케이스")
    class validInputTest {

        @Test
        @DisplayName("자동차 이름들이 올바른 경우 잘 추가되는지 검사한다.")
        void 정상_입력() {
            Car gitJjang = new Car("깃짱");
            Car irene = new Car("이리내");
            List<Car> cars = new ArrayList<>(List.of(gitJjang, irene));

            assertThatCode(() -> new Cars(cars)).doesNotThrowAnyException();
        }

    }

}
