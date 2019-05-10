/*
 * @(#)Main.java
 *
 * v 1.0.0
 *
 * 2019.05.09
 *
 * Copyright (c) 2019 MrKwon, imkimheejoo.
 * WoowahanTechCamp, Seoul, KOREA
 * All right Reserved
 */

package racing;

import racing.controller.Controller;
import racing.view.RacingGame;

/**
 * 레이싱 게임의 Entry Point 가 있는 클래스
 *
 * @author imkimheejoo
 * @author MrKwon
 * @version 1.0.0
 * @see RacingGame
 */
public class Main {
    public static void main(String[] args) {
        Controller.start();
    }
}
