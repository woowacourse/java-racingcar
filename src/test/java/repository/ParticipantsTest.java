package repository;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import domain.Car;
import domain.Participants;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ParticipantsTest {

    private Participants participants;

    @BeforeEach
    void before() {
        participants = new Participants();
    }

    @Test
    void 참가자_등록_테스트() {
        //given
        final String name1 = "asd";
        final String name2 = "asdf";
        //when
        participants.add(List.of(name1, name2));
        //then
        List<Car> results = participants.findAll();
        Assertions.assertThat(results.size()).isEqualTo(2);
        Assertions.assertThat(results.get(0).getName()).isEqualTo(name1);
        Assertions.assertThat(results.get(1).getName()).isEqualTo(name2);
    }

    @Test
    void 참가자_이름은_중복될_수_없다() {
        //given
        final String name1 = "asd";
        final String name2 = "asdf";
        Participants participants = new Participants();
        //when then
        assertThatThrownBy(() -> {
            participants.add(List.of(name1, name1, name2));
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] ")
            .hasMessageContaining("자동차 이름은 중복될 수 없습니다.");
    }
}
