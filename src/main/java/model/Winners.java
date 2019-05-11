package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Winners {
    private List<String> winners;

    Winners() {
        winners = new ArrayList<>();
    }

    Winners(List<String> winners) {
        this.winners = winners;
    }

    void addWinners(String name) {
        winners.add(name);
    }

    @Override
    public String toString() {
        return String.join(", ", winners);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Winners)) return false;
        Winners winners1 = (Winners) o;
        return Objects.equals(winners, winners1.winners);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winners);
    }
}
