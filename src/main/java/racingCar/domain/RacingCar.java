package racingCar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCar {
    private static Players players;

    private RacingCar() {
    }

    public static boolean init(String userNames) {
        List<Name> names = StringParser.parseToNameList(userNames);
        players = new Players(names);

        return players.isReady();
    }

    public static void playWithRandoms() {
        players.getUnmodifiableList().forEach((t) -> {
            t.goOrWait(DeciderFactory.createRandomDecider());
        });
    }

    public static List<String> getWinners() {
        return players.getWinners().stream()
                .map(Player::getName)
                .map(Name::toString)
                .collect(Collectors.toUnmodifiableList());
    }

    public static List<String> getPlayerNames() {
        return players.getUnmodifiableList().stream()
                .map(Player::getName)
                .map(Name::toString)
                .collect(Collectors.toUnmodifiableList());
    }

    public static List<Integer> getPlayerPositions() {
        return players.getUnmodifiableList().stream()
                .map(Player::getPosition)
                .collect(Collectors.toUnmodifiableList());
    }
}
