package racingCar.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameManager {
    private List<Player> players;

    public GameManager(String input) {
        List<String> nameList = NameParser.parse(input);
        players = nameList.stream()
                .map(Player::new)
                .collect(Collectors.toList());
    }

    public IntStream play(int num) {
        return IntStream.range(0, num).peek(this::play);
    }

    private void play() {
        players.forEach((t) -> t.play(RandomGenerator.decideGoOrStop()));
    }

    public Map<String, Integer> getState() {
        return players.stream()
                .collect(Collectors.toMap(Player::getName, Player::getPosition));
    }

    public List<Player> getWinners() {
        int max = getMax();

        return players.stream()
                .filter((t) -> t.isWinner(max))
                .collect(Collectors.toList());
    }

    private int getMax() {
        return players.stream()
                    .max(Player::compare)
                    .orElseThrow(RuntimeException::new).getPosition();
    }
}
