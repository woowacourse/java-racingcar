package racingCar.domain;

import java.util.*;
import java.util.stream.Collectors;

public class GameManager {
    private List<Player> players;

    public GameManager(String input) {
        players = new ArrayList<>();
        try {
            List<PlayerName> nameList = NameParser.parse(input);
            nameList.stream()
                    .map(Player::new)
                    .forEach((t) -> players.add(t));
            checkDuplication();
        } catch (IllegalArgumentException e) {
            players.clear();
        }
    }

    public void playersPlay() {
        players.forEach((t) -> t.play(new RandomNumberGenerator()));
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        players.forEach(
                (t) -> stringBuilder.append(t)
                        .append("\n")
        );

        return stringBuilder.toString();
    }

    public List<Player> getState() {
        return new ArrayList<>(players);
    }

    public String getWinners() {
        int max = getMax();

        return players.stream()
                .filter((t) -> t.isLocatedAt(max))
                .map((t) -> t.getName().toString())
                .collect(Collectors.joining(", "));
    }

    private int getMax() {
        return players.stream()
                .max(Player::compare)
                .orElseThrow(RuntimeException::new).getPosition();
    }

    public boolean isCreated() {
        return !players.isEmpty();
    }

    private void checkDuplication() throws IllegalArgumentException {
        Set<String> set = new HashSet<String>();

        players.forEach(
                (t) -> set.add(t.toString())
        );
        if (players.size() != set.size()) {
            throw new IllegalArgumentException();
        }
    }
}
