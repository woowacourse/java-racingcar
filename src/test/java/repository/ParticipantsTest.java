package repository;

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
        List<Car> cars = List.of(new Car(name1), new Car(name1), new Car(name2));
        //when
        participants.add(name1);
        participants.add(name1);
        participants.add(name2);
        //then
        List<Car> results = participants.findAll();
        Assertions.assertThat(results.size()).isEqualTo(3);
        Assertions.assertThat(results.get(1).getName()).isEqualTo(cars.get(1).getName());
        Assertions.assertThat(results.get(0).getName()).isEqualTo(cars.get(0).getName());
        Assertions.assertThat(results.get(2).getName()).isEqualTo(cars.get(2).getName());
    }
}
