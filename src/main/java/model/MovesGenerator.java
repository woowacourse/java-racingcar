package model;

import java.util.ArrayList;
import java.util.List;

public class MovesGenerator {

    private static final int MOVE_STANDARD = 4;
    private static final int MAX_NUMBER = 9;

    public boolean doMove() {
        return generateRandomMoveNumber() >= MOVE_STANDARD;
    }

    private int generateRandomMoveNumber() {
        return (int) (Math.random() * (MAX_NUMBER + 1));
    }

}
