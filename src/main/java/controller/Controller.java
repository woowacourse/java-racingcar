package controller;

import domain.Cars;
import view.InputView;

public class Controller {
    InputView inputView = new InputView();
    public void run() {
        askCars();

    }

    private Cars askCars() {
        try{
            return new Cars(inputView.askCars());
        } catch (IllegalArgumentException e){
            return askCars();
        }
    }
}
