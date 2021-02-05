package car;

public class OutputView {
    
    private static final String MOVE_SYMBOL = "-";
    
    private static final String NULL_CHARACTER = "\0";
    
    private static final String FINAL_WINNERS = "가 최종 우승했습니다.";
    
    private static final String DELIMITER = ",";
    
    private static final String COLON = " : ";
    
    private static final String ROUND_RESULT = "\n실행 결과";
    
    public void printResult(ScoreBoard scoreBoard) {
        System.out.println(ROUND_RESULT);

        for (Score score : scoreBoard.getScores()) {
            String movedDistance = repeatSymbol(score.getPosition());
            System.out.println(score.getName() + COLON + movedDistance);
        }

        System.out.println();
    }
    
    private String repeatSymbol(int times) {
        return new String(new char[times]).replace(NULL_CHARACTER, MOVE_SYMBOL);
    }
    
    public void printWinners(ScoreBoard scoreBoard) {
        String winners = String.join(DELIMITER, scoreBoard.findWinners());
        
        System.out.println(winners + FINAL_WINNERS);
    }
}
