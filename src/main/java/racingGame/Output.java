package racingGame;

public class Output {
    public static void makeCarLog(String name, int position){
        StringBuilder log = new StringBuilder(name);
        log.append(" : ");
        for(int i=0;i<position;i++){
            log.append("-");
        }
        OutputView.printLog(log.toString());
    }
}
