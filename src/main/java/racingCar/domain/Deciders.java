package racingCar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deciders {
    private static final int ZERO_INDEX = 0;
    private static final int BOUND = 4;
    private static final int TEN = 10;

    private List<Boolean> booleans;

    public Deciders(Players players) {
        this.booleans = getBooleansDecidingPlayerGoOrWait(players);
    }

    private List<Boolean> getBooleansDecidingPlayerGoOrWait(Players players) {
        List<Boolean> randomBooleans = new ArrayList<>();
        for (Player player: players.getUnmodifiableList()) {
            randomBooleans.add(decidePlayerGoOrWait());
        }
        return randomBooleans;
    }

    /**
     * use for test
     */
    public Deciders(Players players, List<Boolean> booleans) {
        checkAreSameSize(players, booleans);
        this.booleans = new ArrayList<>();
        this.booleans.addAll(booleans);
    }

    private void checkAreSameSize(Players players, List<Boolean> booleans) {
        if (players.isSizeNotEqual(booleans.size())) {
            throw new RuntimeException();
        }
    }

    public boolean decidePlayerGoOrWait() {
        int randomNumber = (int) (Math.random() * TEN);
        return randomNumber >= BOUND;
    }

    public boolean isNotEqualSize(Players players) {
        return booleans.size() != players.size();
    }

    public boolean get(int index) {
        return booleans.get(index);
    }

    public String toString() {
        return booleans.toString();
    }

    public List<Boolean> getUnmodifiableList() {
        return Collections.unmodifiableList(booleans);
    }
}
