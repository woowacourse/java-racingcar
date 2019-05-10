package model;

import java.util.ArrayList;
import java.util.List;

public class Winners {
    List<String> winners = new ArrayList<>();

    public void addWinners(String name) {
        winners.add(name);
    }

    @Override
    public String toString() {
        return String.join(", ", winners);
    }
}
