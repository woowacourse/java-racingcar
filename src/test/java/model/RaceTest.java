package model;

import static org.assertj.core.api.Assertions.assertThatNoException;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class RaceTest {

    @Nested
    @DisplayName("중복된 자동차 이름이 존재하는지 테스트")
    class CarNameTest {
        @Test
        @DisplayName("자동차 이름이 모두 유니크하면 클래스가 정상 생성된다")
        void validateNotDuplicatedCarName() {
            assertThatNoException()
                    .isThrownBy(() -> new Race("호기,재즈,상돌,아루,폴라"));
        }

        @Test
        @DisplayName("중복된 자동차 이름이 존재하면 에러를 발생시킨다.")
        void validateDuplicatedCarName() {
            Assertions.assertThatThrownBy(() -> new Race("호기,재즈,호기,상돌"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("중복된 이름의 자동차는 사용할 수 없습니다.");
        }
    }

    @Nested
    @DisplayName("경주에 참여하는 자동차의 수를 테스트")
    class NumberOfCarsSizeTest {
        @Test
        @DisplayName("경주에 참여하는 자동차의 수가 2대 이상이라면 클래스가 정상 생성된다.")
        void validateNumberOfCarsIsOver2() {
            assertThatNoException()
                    .isThrownBy(() -> new Race("호기,재즈,상돌,아루,폴라"));
        }

        @Test
        @DisplayName("경주에 참여하는 자동차의 수가 2대 미만이라면 에러를 발생시킨다.")
        void validateNumberOfCarsIsLess2() {
            Assertions.assertThatThrownBy(() -> new Race("호기"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("레이스에 참여하는 자동차는 최소 2대 이상이어야 합니다.");
        }
    }

    @Nested
    @DisplayName("우승자가 단일일 경우와 여러명일 경우를 테스트")
    class ShowWinnerTest {
        @Test
        @DisplayName("우승자가 한 명일 경우 우승자 리스트 크기는 1을 반환한다.")
        void oneWinner() {
            Race race = new Race("호기,재즈,상돌,아루");
            List<Car> cars = race.getCars();
            Car car = cars.get(2);
            car.move();

            List<String> winners = race.selectWinners();
            Assertions.assertThat(winners).size().isEqualTo(1);
        }

        @Test
        @DisplayName("우승자가 한 명 이상일 경우 우승자 리스트 크기는 2이상을 반환한다.")
        void twoWinner() {
            Race race = new Race("호기,재즈,상돌,아루");
            List<Car> cars = race.getCars();
            Car car1 = cars.get(2);
            Car car2 = cars.get(1);
            car1.move();
            car2.move();

            List<String> winners = race.selectWinners();
            Assertions.assertThat(winners).size().isEqualTo(2);
        }
    }

}