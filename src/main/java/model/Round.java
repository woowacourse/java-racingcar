package model;

public class Round {

    private int round;

    private Round(int round) {
        this.round = round;
    }

    public static Round from(String round) {
        return new Round(Integer.parseInt(round));
    }

}