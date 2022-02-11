package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ParticipantsTest {

    @Test
    public void participateInRacing() {
        Participants participants = new Participants();

        participants.participateInRacing(new Car("Eden"));

        assertThat(participants.participateSize()).isEqualTo(1);
    }

    @Test
    public void race() {
    }
}