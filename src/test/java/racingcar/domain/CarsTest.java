package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {

    private List<Name> names;
    private List<Position> positions;

    @BeforeEach
    public void setUp() {
        names = Arrays.asList(new Name("test1"), new Name("test2"), new Name("test3"));
        positions = Arrays.asList(new Position(7), new Position(11), new Position(4));
    }

    @Test
    @DisplayName("우승자 선정이 잘 되는지 테스트")
    public void check_get_winners() {
        Cars cars = new Cars(names, positions);
        assertThat(cars.getWinners().get(0).getName()).isEqualTo("test2");
    }

}