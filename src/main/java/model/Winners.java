package model;

import java.util.ArrayList;
import java.util.List;

public class Winners {
    private List<String> winners = new ArrayList<>();

    void addWinners(String name) {
        winners.add(name);
    }

    @Override
    public String toString() {
        return String.join(", ", winners);
    }
}
