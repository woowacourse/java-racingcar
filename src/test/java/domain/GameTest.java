package domain;


import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameTest {
    Game game = new Game();

    @DisplayName("자동차 객체 리스트가 올바르게 생성된다")
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

    @DisplayName("입력된 자동차 이름이 공백이면 예외가 발생한다")
    @Test
    void blankNameTest() {
        Assertions.assertThatThrownBy(() -> game.setCars("Ash,,Lily"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("빈 이름");
    }

    @DisplayName("최종 우승자를 올바르게 결정한다")
    @Test
    void getWinnerTest() {
        Car ash = new Car("ash");
        Car lily = new Car("lily");

        List<Car> cars = List.of(ash, lily);

        ash.incLocation();

        Assertions.assertThat(game.getWinner(cars)).isEqualTo(List.of("ash", ""));
    }
}
