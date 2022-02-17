package racingcar.model.car;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import racingcar.dto.CarDto;

public class CarsTest {
    @DisplayName("add 메소드는")
    @Nested
    class Add {
        @Nested
        @DisplayName("중복 이름을 가진 차가 주어진다면")
        class Context_with_duplicate_name_of_car {
            @Test
            @DisplayName("예외를 발생시킨다.")
            void it_throw_exception() {
                Cars cars = new Cars();
                cars.add(new Car(new Name("car1")));
                assertThatThrownBy(() -> cars.add(new Car(new Name("car1"))))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("이미 존재하는 자동차 이름입니다.");
            }
        }

        @Nested
        @DisplayName("중복되지 않는 이름을 가진 차가 주어진다면")
        class Context_with_not_duplicate_name_of_car {
            @Test
            @DisplayName("추가 시키고 예외를 발생시키지 않는다.")
            void it_throw_exception() {
                Cars cars = new Cars();
                cars.add(new Car(new Name("car1")));

                assertDoesNotThrow(() -> cars.add(new Car(new Name("car2"))));
            }
        }
    }

    @Nested
    @DisplayName("race 메소드는")
    class Describe_race {
        @Nested
        @DisplayName("만약 모든 차에게 true 값을 주면")
        class Context_Number_of_4_or_more {
            @Test
            @DisplayName("모든 차의 위치는 1 증가한다.")
            void it_increase_position_of_cars() {
                Cars cars = new Cars();
                cars.add(new Car(new Name("car1")));
                cars.add(new Car(new Name("car2")));
                cars.add(new Car(new Name("car3")));
                cars.race(() -> true);
                for (CarDto carInformation : cars.getCarsDto()) {
                    assertThat(carInformation.getPosition()).isEqualTo(1);
                }
            }
        }
    }

    @Nested
    @DisplayName("getWinnerNames 메소드는")
    class GetWinnerNames {
        @Test
        @DisplayName("가장 멀린 간 위치에 있는 차들의 이름 리스트로 리턴한다.")
        void it_returns_car_name_list() {
            Cars cars = new Cars();
            cars.add(new Car(new Name("car1"), new Position(10)));
            cars.add(new Car(new Name("car2"), new Position(1)));
            cars.add(new Car(new Name("car3"), new Position(10)));

            assertThat(cars.getWinnersNames()).containsExactly("car1", "car3");
        }
    }

    @Nested
    @DisplayName("getFirstPosition 메소드는")
    class GetFirstPosition {
        @Test
        @DisplayName("가장 멀리간 차의 위치를 가져온다")
        void it_returns_farthest_position() {
            Cars cars = new Cars();
            cars.add(new Car(new Name("car1"), new Position(10)));
            cars.add(new Car(new Name("car2"), new Position(1)));
            cars.add(new Car(new Name("car3"), new Position(5)));

            assertThat(cars.getFirstPosition())
                .isEqualTo(new Position(10));
        }

        @Nested
        @DisplayName("아무 차가 없다면")
        class Context_empty_cars {
            @Test
            @DisplayName("예외를 발생시킨다.")
            void it_throw_exception() {
                Cars cars = new Cars();
                assertThatThrownBy(cars::getFirstPosition)
                    .isInstanceOf(IllegalArgumentException.class);
            }

        }
    }

    @Nested
    @DisplayName("getCarsByPosition 메소드는")
    class GetCarsByposition {
        @Test
        @DisplayName("위치와_일치하는_자동차의_리스트를_가져온다")
        void it_returns_car_list() {
            Cars cars = new Cars();
            cars.add(new Car(new Name("car1"), new Position(10)));
            cars.add(new Car(new Name("car2"), new Position(1)));
            cars.add(new Car(new Name("car3"), new Position(10)));

            assertThat(cars.getCarsByPosition(new Position(10)))
                .contains(new Car(new Name("car1")), new Car(new Name("car3")));
        }
    }
}
