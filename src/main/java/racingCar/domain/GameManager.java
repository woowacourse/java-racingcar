package racingCar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GameManager {
    private List<Player> players;

    public GameManager(String input) {
        try {
            List<PlayerName> nameList = NameParser.parse(input);
            players = nameList.stream()
                    .map(Player::new)
                    .collect(Collectors.toList());
        } catch (IllegalArgumentException e) {
            players = new ArrayList<>();
        }
    }

    public boolean isEmpty() {
        return players.isEmpty();
    }

    public void play() {
        players.forEach((t) -> t.play(RandomGenerator.decideGoOrStop()));
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

        List<Player> winnerList = players.stream()
                .filter((t) -> t.isWinner(max))
                .collect(Collectors.toList());

        StringBuilder stringBuilder = new StringBuilder();

        winnerList.stream()
                .peek((t) -> stringBuilder.append(t.getName()))
                .forEach((t) -> stringBuilder.append(", "));

        stringBuilder.delete(stringBuilder.length()-2, stringBuilder.length());

        return stringBuilder.toString();
    }

    private int getMax() {
        return players.stream()
                .max(Player::compare)
                .orElseThrow(RuntimeException::new)
                .getPosition();
    }
}
