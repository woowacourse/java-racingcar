package model.car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import model.manager.ThresholdCarMoveManager;
import org.junit.jupiter.api.*;
import util.CarNameValidator;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @Test
    @DisplayName("더 많이 이동한 차량이 우승자로 판단되는지 검사한다.")
    void winnerTest() {
        Car gitJjang = new Car("깃짱");
        Car irene = new Car("이리내");
        Cars cars = new Cars(Arrays.asList(gitJjang, irene));

        gitJjang.move(true);
        irene.move(true);
        gitJjang.move(true);
        irene.move(false);

        assertThat(cars.getWinners().contains("깃짱"));
    }

    @Test
    @DisplayName("우승자가 이동한 칸수가 경기에 참여한 차량들이 이동한 칸수 중 최대 칸수와 일치하는지 검사한다.")
    void maxPositionTest() {
        Car gitJjang = new Car("깃짱");
        Car irene = new Car("이리내");
        Cars cars = new Cars(Arrays.asList(gitJjang, irene));

        gitJjang.move(true);
        irene.move(true);
        gitJjang.move(true);
        irene.move(false);
        gitJjang.move(true);
        irene.move(false);

        assertThat(cars.getWinners().contains("깃짱"));
        assertThat(gitJjang.getPosition()).isEqualTo(3);
    }

    @RepeatedTest(100)
    @DisplayName("자동차가 한번 이동한 칸수가 0칸 또는 1칸인지 검사한다")
    void carMoveTest() {
        Car gitJjang = new Car("깃짱");
        Car secondGitJjang = new Car("깃짱부캐");
        Car irene = new Car("이리내");
        Car secondIrene = new Car("이리내부캐");
        Cars cars = new Cars(Arrays.asList(gitJjang, secondGitJjang, irene, secondIrene));

        cars.moveAllCarsOnce(new ThresholdCarMoveManager());
        List<Car> carsAfterMove = cars.getCurrentResult();
        assertThat(carsAfterMove.stream().dropWhile(car -> car.getPosition() > 1).collect(Collectors.toList()).equals(carsAfterMove));
    }

}
