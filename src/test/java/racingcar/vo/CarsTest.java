package racingcar.vo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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
        String result = afterRaceCars.getRaceAllResult();
        Matcher matcher = Pattern.compile(name).matcher(result);
        int nameCount = 0;
        while (matcher.find()) {
            nameCount++;
        }
        assertThat(nameCount).isEqualTo(5);
    }

    @DisplayName("judgeWinners() 단독우승 테스트")
    @Test
    public void judgeWinners_solo_win_test() throws Exception {
        String winnerName = "name1";
        String[] names = {winnerName};
        Cars cars = new Cars(names);
        Winners winners = cars.judgeWinners();
        assertThat(winners.toString().contains(winnerName)).isTrue();
    }

    @DisplayName("judgeWinners() 공동우승 테스트")
    @Test
    public void judgeWinners_joint_win_test() throws Exception {
        String firstName = "name1";
        String secondName = "name2";
        String[] names = {firstName, secondName};
        Cars cars = new Cars(names);
        Winners winners = cars.judgeWinners();
        assertThat(winners.toString().contains(firstName)).isTrue();
        assertThat(winners.toString().contains(secondName)).isTrue();
    }

    @DisplayName("add() 중복된 이름이 입력되었을 때 예외 테스트")
    @Test
    public void add_duplicate_name_exception_test() throws Exception {
        String name = "name1";
        String[] names = {name, name};
        assertThatThrownBy(() -> new Cars(names))
                .hasMessageContaining(ErrorMessage.CAR_NAME_DUPLICATE.toString());
    }
}
