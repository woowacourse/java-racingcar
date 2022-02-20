package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;
import org.junit.jupiter.api.Test;

class RoundResultTest {

    @Test
    public void addResult() {
        RoundResult roundResult = new RoundResult();
        Car car = new Car("Eden");
        roundResult.addResult(car);
    }

    @Test
    public void getParticipantsNames() {
        RoundResult roundResult = new RoundResult();
        Set<String> participantsNames = roundResult.getParticipantsNames();
        assertThat(participantsNames.size()).isEqualTo(0);
    }

    @Test
    public void findLocationBy() {
        RoundResult roundResult = new RoundResult();
        Car car = new Car("Eden");
        roundResult.addResult(car);
        assertThat(roundResult.findLocationBy("Eden")).isEqualTo(0);
    }
}