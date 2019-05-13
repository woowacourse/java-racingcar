package racing.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceTest {
    @Test
    void 자동차생성(){
        List<String> carNames = Arrays.asList(new String []{"a","b"});
        Race race = new Race(carNames);
        assertThat(race.getCars()).hasSize(2);
    }

    @Test
    void 자동차전진(){
        List<String> carNames = Arrays.asList(new String []{"a","b"});
        Race race = new Race(carNames,new Move());
        race.progressRace();
        for(int i = 0; i < carNames.size(); i++)
        assertThat(race.getCars().get(0).getPosition()).isEqualTo(1);
    }

    @Test
    void 자동차정지(){
        List<String> carNames = Arrays.asList(new String []{"a","b"});
        Race race = new Race(carNames,new Stop());
        race.progressRace();
        for(int i = 0; i < carNames.size(); i++) assertThat(race.getCars().get(0).getPosition()).isEqualTo(0);
    }

    @Test
    void 전체우승(){
        List<String> carNames = Arrays.asList(new String []{"a","b"});
        Race race = new Race(carNames,new Stop());
        race.progressRace();
        assertThat(race.getResult()).isEqualTo(carNames);
    }


}
