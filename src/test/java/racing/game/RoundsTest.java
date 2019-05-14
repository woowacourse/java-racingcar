package racing.game;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static racing.game.Rounds.*;

class RoundsTest {
    private static int DEFAULT_NAMES_SIZE = 0;
    private static int ROUND_MIN_LIMIT = 1;

    @Test
    void 기준값보다_적은수의_이름을_입력한_경우_에러확인() {
        String names = "pobi";
        assertThrows(Exception.class, () -> splitNamesWithComma(names));
    }

    @Test
    void 이름에대한_입력으로_빈칸을_입력한_경우() {
        String names = "";
        assertThat(convertNamesToCars(names).size()).isEqualTo(DEFAULT_NAMES_SIZE);
    }

    @Test
    void 이름에대한_입력으로_중복된_이름을_입력한_경우() {
        String names = "aaaa,bbbb,cccc,dddd,aaaa";
        assertThat(convertNamesToCars(names).size()).isEqualTo(DEFAULT_NAMES_SIZE);
    }

    @Test
    void 이름에대한_입력으로_제한값_이상의_길이의_이름을_입력한_경우() {
        String names = "aaaa,bbbb,cccc,dddddd";
        assertThat(convertNamesToCars(names).size()).isEqualTo(DEFAULT_NAMES_SIZE);
    }

    @Test
    void 이름에대한_입력으로_빈칸을_포함한_이름을_입력한_경우() {
        String names = "aaaa,bbbb,,cccc";
        assertThat(convertNamesToCars(names).size()).isEqualTo(DEFAULT_NAMES_SIZE);
    }

    @Test
    void 라운드에대한_입력으로_문자를_입력한_경우() {
        String round = "aaaa";
        assertThat(checkRoundNum(round)).isLessThan(ROUND_MIN_LIMIT);
    }

    @Test
    void 라운드에대한_입력으로_1미만의_정수를_입력한_경우() {
        String round = "0";
        assertThat(checkRoundNum(round)).isLessThan(ROUND_MIN_LIMIT);
    }

    @Test
    void 같은이름이있는_리스트와_이름의중복을_비교하는_경우() {
        try {
            String pobi = "pobi";
            Car car = new Car(pobi);
            List<Car> cars = Arrays.asList(new Car[]{new Car(pobi), new Car("crong")});
            assertThrows(Exception.class, () -> checkRepetition(cars, pobi));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void 챔피언이_하나일때_챔피언계산() {
        List<Car> cars;
        try {
            cars = Arrays.asList(new Car[]{new Car("pobi", 2), new Car("jihoo"), new Car("jinwo")});
            List<Car> winners = new ArrayList<>();
            winners.add(cars.get(0));
            assertThat(Rounds.calculateChampions(cars)).isEqualTo(winners);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void 챔피언이_여러명일때_챔피언계산() throws Exception {
        List<Car> cars;
        cars = Arrays.asList(new Car[]{new Car("pobi", 1), new Car("jihoo", 1), new Car("jinwo")});
        List<Car> winners = new ArrayList<>();
        winners.add(cars.get(1));
        winners.add(cars.get(0));
        HashSet<Car> winnerSet = new HashSet<>(winners);
        assertThat(new HashSet(Rounds.calculateChampions(cars))).isEqualTo(winnerSet);
    }
}
