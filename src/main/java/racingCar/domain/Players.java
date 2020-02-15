package racingCar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Players {
    private static final int ZERO_INDEX = 0;

    private final List<Player> players;

    public Players(List<Name> names) {
        players = names.stream()
            .map(Player::new)
            .collect(Collectors.toList());
        handleDuplication();
    }

    private void handleDuplication() {
        try {
            checkDuplication();
        } catch (IllegalArgumentException e) {
            players.clear();
        }
    }

    private void checkDuplication() throws IllegalArgumentException {
        Set<String> set = players.stream()
                .map(Player::getName)
                .map(Name::toString)
                .collect(Collectors.toSet());

        if (isSizeNotEqual(set.size())) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isEmpty() {
        return players.isEmpty();
    }

    public List<Player> play(Deciders deciders) {
        checkSameNum(deciders);

        int bound = players.size();
        for (int i = ZERO_INDEX; i < bound; i++) {
            players.get(i).goOrWait(deciders.get(i));
        }
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
