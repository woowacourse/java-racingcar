package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
class GameTest {

    @Test
    @DisplayName("자동차들이 중복된 이름을 가질 시 예외가 발생한다.")
    void validateDuplicate(){
        assertThatThrownBy(() -> new Game(List.of("포비", "포비"))).isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    @DisplayName("자동차들을 전진 혹은 정지시킨다.")
    void proceed(){
        List<Car> cars = new Game(List.of("포비", "왼손")).proceed(List.of(4,0));
        assertAll(
                () -> assertThat(cars.get(0).getStatuses()).isEqualTo(List.of(CarStatus.FORWARD)),
                () -> assertThat(cars.get(1).getStatuses()).isEqualTo(List.of(CarStatus.STOP))
        );

    }


    @Test
    @DisplayName("우승자를 알아 낼 수 있다.")
    void findWinners(){
        Game game = new Game(List.of("포비", "왼손"));
        game.proceed(List.of(4,0));
        assertThat(game.findWinners().get(0).getName()).isEqualTo("포비");
    }
}