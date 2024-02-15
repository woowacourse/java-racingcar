package model;

import java.util.ArrayList;
import java.util.List;

public class MovesGenerator {

    private static final int MOVE_STANDARD = 4;
    private static final int MAX_NUMBER = 9;

    public List<Boolean> generate(int carNumbers) {
        List<Boolean> moves = new ArrayList<>();
        for (int i = 0; i < carNumbers; i++) {
            moves.add(doMove());
        }
        return moves;
    }

    private int generateRandomMoveNumber() {
        return (int) (Math.random() * (MAX_NUMBER + 1));
    }

    private boolean doMove() {
        return generateRandomMoveNumber() >= MOVE_STANDARD;
    }
}
