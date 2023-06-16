//어플리케이션을 시작 및 제어하는 main 클래스
public class GameStarter {

    //어플리케이션 시작
    public static void main(String[] args) {
        GameStarter gameStarter = new GameStarter();
        gameStarter.run();
    }

    //어플리케이션 흐름 제어
    private void run() {
        InputView inputView = new InputView();
        int carNum = inputView.getCarNumber();
    }
}
