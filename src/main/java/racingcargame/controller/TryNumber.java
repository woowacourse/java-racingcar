package racingcargame.controller;

import racingcargame.stringutil.Parser;

public class TryNumber {
    private int tryNumber;

    public TryNumber(String tryRound) {
        this.tryNumber = Parser.parseRound(tryRound);
    }

    public int getTryNumber() {
        return tryNumber;
    }
}
