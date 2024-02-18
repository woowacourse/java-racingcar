package domain;


import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameTest {
    Game game = new Game();

    @DisplayName("입력된 시도 횟수가 정수인 숫자 형태가 아니라면 예외가 발생한다")
    @Test
    void attemptLimitFormatTest() {
        Assertions.assertThatThrownBy(() -> game.setAttemptLimit("r"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("정수");
    }

    @DisplayName("입력된 시도 횟수가 양수가 아니라면 예외가 발생한다")
    @Test
    void attemptLimitRangeTest() {
        Assertions.assertThatThrownBy(() -> game.setAttemptLimit("-1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("양수");
    }

    @DisplayName("입력된 자동차 이름이 쉼표를 기준으로 분리되어 각각의 자동차 객체로 생성된다")
    @Test
    void setCarTest() {
        List<Car> cars = game.setCars("ash,lily,ella");
        System.out.println(cars.get(0).getCarName());
        Assertions.assertThat(cars.get(0).getCarName()).isEqualTo("ash");
        Assertions.assertThat(cars.get(0).getLocation()).isEqualTo(0);
    }

    @DisplayName("입력된 자동차 이름이 한 개라면 예외가 발생한다")
    @Test
    void amountTest() {
        Assertions.assertThatThrownBy(() -> game.setCars("Ash"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("두 대 이상");
    }

    @DisplayName("입력된 자동차 이름 중에 중복되는 이름이 존재하면 예외가 발생한다")
    @Test
    void duplicationTest() {
        Assertions.assertThatThrownBy(() -> game.setCars("Ash,Ash,Ella"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복");
    }

    @DisplayName("최종 우승자가 한 명이다")
    @Test
    void getOneWinnerTest() {
        Car ash = new Car("ash");
        Car lily = new Car("lily");

        List<Car> cars = List.of(ash, lily);

        ash.incLocation();
        game.getWinner(cars);

        Assertions.assertThat(ash.isWinner).isTrue();
        Assertions.assertThat(lily.isWinner).isFalse();
    }

    @DisplayName("최종 우승자가 두 명 이상이다")
    @Test
    void getTwoWinnerTest() {
        Car ash = new Car("ash");
        Car lily = new Car("lily");
        Car ella = new Car("ella");

        List<Car> cars = List.of(ash, lily, ella);

        ash.incLocation();
        lily.incLocation();
        ella.incLocation();
        game.getWinner(cars);

        Assertions.assertThat(ash.isWinner).isTrue();
        Assertions.assertThat(lily.isWinner).isTrue();
        Assertions.assertThat(ella.isWinner).isTrue();
    }
}
