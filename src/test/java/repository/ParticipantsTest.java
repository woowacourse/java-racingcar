package repository;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import domain.Car;
import domain.Participants;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ParticipantsTest {

    @Test
    void 참가자_등록_테스트() {
        //given
        final String name1 = "asd";
        final String name2 = "asdf";
        //when
        //then
        Participants participants = new Participants(List.of(name1, name2));
        List<Car> cars = participants.findAll();

        Assertions.assertThat(cars.size()).isEqualTo(2);
        Assertions.assertThat(cars.get(0).getName()).isEqualTo(name1);
        Assertions.assertThat(cars.get(1).getName()).isEqualTo(name2);
    }

    @Test
    void 참가자_이름은_중복될_수_없다() {
        //given
        final String name1 = "asd";
        final String name2 = "asdf";

        //when then
        assertThatThrownBy(() -> {
            new Participants(List.of(name1, name1, name2));
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] ")
            .hasMessageContaining("자동차 이름은 중복될 수 없습니다.");
    }
}
