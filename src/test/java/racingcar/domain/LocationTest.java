package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Location;

public class LocationTest {
    @Test
    void location_값이_큰_경우_양수를_반환() {
        Location greaterLocation = new Location(4);
        Location lessLocation = new Location(1);

        assertThat(greaterLocation.compareTo(lessLocation)).isGreaterThan(0);
    }

    @Test
    void location_값이_작은_경우_음수를_반환() {
        Location greaterLocation = new Location(4);
        Location lessLocation = new Location(1);

        assertThat(lessLocation.compareTo(greaterLocation)).isLessThan(0);
    }

    @Test
    void location_값이_같을_경우_0를_반환() {
        Location location1 = new Location(1);
        Location location2 = new Location(1);

        assertThat(location1.compareTo(location2)).isEqualTo(0);
    }
}
