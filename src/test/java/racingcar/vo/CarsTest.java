package racingcar.vo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.view.ErrorMessage;

public class CarsTest {

    @DisplayName("add() 테스트")
    @Test
    public void add_test() throws Exception {
        String name = "name1";
        String[] names = {name};
        Cars cars = new Cars(names);
        assertThat(cars.isSameSize(1)).isTrue();
    }

    @DisplayName("repeatRaceBy() 테스트")
    @Test
    public void repeatRaceBy_test() throws Exception {
        String name = "name1";
        String[] names = {name};
        Cars cars = new Cars(names);
        Attempt attempt = new Attempt("5");
        Cars afterRaceCars = cars.repeatRaceBy(attempt);
        RaceResult raceResult = afterRaceCars.getRaceResult();
        Matcher matcher = Pattern.compile(name).matcher(raceResult.getResult());
        int nameCount = 0;
        while (matcher.find()) {
            nameCount++;
        }
        assertThat(nameCount).isEqualTo(5);
    }

    @DisplayName("judgeWinners() 단독, 공동우승 테스트")
    @ParameterizedTest()
    @ValueSource(strings = {"name1", "name1,name2"})
    public void judgeWinners_test(String inputNames) throws Exception {
        String[] names = inputNames.split(",");
        Cars cars = new Cars(names);
        String winners = cars.judgeWinners().toString();
        for (String name : names) {
            assertThat(winners.contains(name)).isTrue();
        }
    }

    @DisplayName("add() 중복된 이름이 입력되었을 때 예외 테스트")
    @Test
    public void add_duplicate_name_exception_test() throws Exception {
        String name = "name1";
        String[] names = {name, name};
        assertThatThrownBy(() -> new Cars(names))
                .hasMessageContaining(ErrorMessage.CAR_NAME_DUPLICATE.getMessage());
    }
}
