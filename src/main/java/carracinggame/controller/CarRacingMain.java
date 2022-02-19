package carracinggame.controller;


public class CarRacingMain {
    public static void main(String[] args) {

        CarNamesController carNamesController = new CarNamesController();
        final String[] carNames = carNamesController.getCarNames();

    }
}
