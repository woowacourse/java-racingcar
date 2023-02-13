package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.NumberGenerator;
import utils.RandomNumberGenerator;

class ParticipantsTest {

    @Test
    void 참가자_등록_테스트() {
        //given
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        final Car car1 = new Car("test1", numberGenerator);
        final Car car2 = new Car("test2", numberGenerator);
        //when
        //then
        Participants participants = new Participants(List.of(car1, car2), new RandomNumberGenerator());
        List<Car> cars = participants.getCars();

        Assertions.assertThat(cars.size()).isEqualTo(2);
        Assertions.assertThat(cars.get(0).getName()).isEqualTo("test1");
        Assertions.assertThat(cars.get(1).getName()).isEqualTo("test2");
    }

    @Test
    void 참가자_이름은_중복될_수_없다() {
        //given
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        final Car car1 = new Car("test1", numberGenerator);
        final Car car2 = new Car("test1", numberGenerator);
        //when then
        assertThatThrownBy(() -> {
            new Participants(List.of(car1, car2), new RandomNumberGenerator());
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] ")
            .hasMessageContaining("자동차 이름은 중복될 수 없습니다.");
    }

    @Test
    void 승리차량_판별_테스트() {

    }
}
