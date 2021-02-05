package car.view;

import car.domain.Score;
import car.domain.ScoreBoard;

public final class OutputView {
    
    private static final String MOVE_SYMBOL = "-";
    
    private static final String NULL_CHARACTER = "\0";
    
    private static final String FINAL_WINNERS = "가 최종 우승했습니다.";
    
    private static final String DELIMITER = ",";
    
    private static final String COLON = " : ";
    
    private static final String RESULT_TITLE = "\n실행 결과";
    
    public void printResultTitle() {
        System.out.println(RESULT_TITLE);
    }
    
    public void printRoundResult(ScoreBoard scoreBoard) {
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
