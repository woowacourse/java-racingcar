package application.racingGame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RaceParticipantTest {

    private List<Car> cars;
    private Race race;
    private RaceParticipants raceParticipants;
    private RacingCarConsoleInput racingCarConsoleInput = mock(RacingCarConsoleInput.class);
    private Car pobi;
    private Car lavin;
    private Car ramen;

    @BeforeEach
    void setUp() {
        cars = new ArrayList<>();
        race = new Race();
        raceParticipants = new RaceParticipants(racingCarConsoleInput);
        pobi = new Car("pobi");
        lavin = new Car("lavin");
        ramen = new Car("ramen");
        cars.add(pobi);
        cars.add(lavin);
        cars.add(ramen);
    }

    @Test
    void init_중복된_이름이_입력되면_익셉션을_발생한다() {
        String carNames = "pobi,pobi";
        when(racingCarConsoleInput.getCarNames()).thenReturn(carNames);
        assertThatThrownBy(() -> {
            raceParticipants.init();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void init_Null이_입력되면_익셉션을_발생한다() {
        String carNames = null;
        when(racingCarConsoleInput.getCarNames()).thenReturn(carNames);
        assertThatThrownBy(() -> {
            raceParticipants.init();
        }).isInstanceOf(NullPointerException.class);
    }

    @Test
    void init_빈문자열이_입력되면_익셉션을_발생한다() {
        String carNames = "";
        when(racingCarConsoleInput.getCarNames()).thenReturn(carNames);
        assertThatThrownBy(() -> {
            raceParticipants.init();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void init_공백이_입력되면_익셉션을_발생한다() {
        String carNames = " ";
        when(racingCarConsoleInput.getCarNames()).thenReturn(carNames);
        assertThatThrownBy(() -> {
            raceParticipants.init();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void init_자동차_이름의길이가_5를_초과하면_익셉션을_발생한다() {
        String carNames = "overFive";
        when(racingCarConsoleInput.getCarNames()).thenReturn(carNames);
        assertThatThrownBy(() -> {
            raceParticipants.init();
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
