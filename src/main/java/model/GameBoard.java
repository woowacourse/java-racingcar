package model;

public class GameBoard {
    private LapRecord lapRecord;
    private Winners winners;

    public GameBoard(LapRecord lapRecord, Winners winners) {
        this.lapRecord = lapRecord;
        this.winners = winners;
    }

    public LapRecord getLapRecord() {
        return lapRecord;
    }

    public Winners getWinners() {
        return winners;
    }
}
