package domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class WinnerCars {
    private List<Car> winnerCars;

    public WinnerCars(List<Car> winnerCars) {
        this.winnerCars = winnerCars;
    }

    public List<Car> getWinnerCars() {
        return Collections.unmodifiableList(winnerCars);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinnerCars that = (WinnerCars) o;
        return Objects.equals(winnerCars, that.winnerCars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winnerCars);
    }
}
