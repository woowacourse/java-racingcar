package model;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class RaceTest {

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