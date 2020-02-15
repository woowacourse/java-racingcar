package racingCar.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Players {
    private static final int ZERO_INDEX = 0;

    private final List<Player> players;

    public Players(List<Name> names) {
        players = new ArrayList<>();
        for (Name name : names) {
            players.add(new Player(name));
        }
        try {
            checkDuplication();
        } catch (IllegalArgumentException e) {
            players.clear();
        }
    }

    private void checkDuplication() throws IllegalArgumentException {
        Set<String> set = new HashSet<>();
        for (Player player : players) {
            set.add(player.getName().toString());
        }
        if (players.size() != set.size()) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isEmpty() {
        return players.isEmpty();
    }

    public List<Player> play(Deciders deciders) {
        checkSameNum(deciders);
        IntStream.range(ZERO_INDEX, players.size())
                .forEach((t) -> players.get(t).goOrWait(deciders.get(t)));
        return Collections.unmodifiableList(players);
    }

    private void checkSameNum(Deciders deciders) {
        if (deciders.isNotEqualSize(this)) {
            throw new RuntimeException();
        }
    }

    public List<Player> getWinners() {
        int max = getMax();

        return players.stream()
                .filter((t) -> t.isWinner(max))
                .collect(Collectors.toUnmodifiableList());
    }

    private int getMax() {
        return players.stream()
                .max(Player::compare)
                .orElseThrow(RuntimeException::new)
                .getPosition();
    }

    public int size() {
        return players.size();
    }

    public boolean isSizeNotEqual(int size) {
        return players.size() != size;
    }

    public List<Player> getUnmodifiableList() {
        return Collections.unmodifiableList(players);
    }
}
