package racingCar.domain;

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

    public boolean isReady() {
        return !players.isEmpty();
    }

    public List<Player> play(Deciders deciders) {
        checkIsSameSize(deciders.size());

        int bound = players.size();
        for (int i = ZERO_INDEX; i < bound; i++) {
            players.get(i).goOrWait(deciders.getUnmodifiableList().get(i));
        }
        return Collections.unmodifiableList(players);
    }

    private void checkIsSameSize(int num) {
        if (isSizeNotEqual(num)) {
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
                .mapToInt(Player::getPosition)
                .max()
                .orElseThrow();
    }

    private boolean isSizeNotEqual(int size) {
        return players.size() != size;
    }

    public int size() {
        return players.size();
    }

    public List<Player> getUnmodifiableList() {
        return Collections.unmodifiableList(players);
    }
}
