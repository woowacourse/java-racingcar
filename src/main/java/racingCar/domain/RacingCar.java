package racingCar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingCar {
    private static final int ZERO_INDEX = 0;
    private static final int ONE_FOR_RANDOM = 1;

    public static Players players;

    private RacingCar() {
    }

    public static boolean init(String userNames) {
        List<Name> names = StringParser.parseToNameList(userNames);
        players = new Players(names);

        return players.isReady();
    }

    public static void playWithRandoms() {
        players.play(getRandomDeciders());
    }

    private static Deciders getRandomDeciders() {
        List<Integer> randoms = new ArrayList<>();
        for (int i = ZERO_INDEX; i < players.size(); i++) {
            randoms.add((int) (Math.random() * (Decider.MAX + ONE_FOR_RANDOM)));
        }
        return new Deciders(randoms);
    }
}
