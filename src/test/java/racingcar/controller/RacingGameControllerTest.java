package racingcar.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static racingcar.view.InputViewTest.generateUserInput;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RacingGameControllerTest {
    private Scanner scanner;

    @DisplayName("올바른 인풋이 주어졌을 떄 controller가 문제없이 잘 도는지")
    @Test
    void startRacingGameController_properNameAndNumberOfRoundsInput_noError() {
        String nameInput = "포비,웨지,삭정\n";
        String numberOfRoundsInput = "4";
        InputStream in = createInputStream(nameInput, numberOfRoundsInput);
        System.setIn(in);
        scanner = new Scanner(System.in);

        assertThat(isControllerRunningSuccessfully(new RacingGameController())).isTrue();
    }

    @DisplayName("잘못된 인풋이 주어 졌을 때 에러를 반환하는지")
    @ParameterizedTest
    @MethodSource("provideNameAndNumberOfRoundsInput")
    void startRacingGameController_wrongNameAndNumberOfRoundsInput_validateInputsCorrectly(String nameInput, String numberOfRounds) {
        InputStream in = createInputStream(nameInput, numberOfRounds);
        System.setIn(in);
        scanner = new Scanner(System.in);

        assertThat(isControllerRunningSuccessfully(new RacingGameController())).isFalse();
    }

    private static Stream<Arguments> provideNameAndNumberOfRoundsInput() {
        return Stream.of(
                Arguments.of("포비,웨지,삭정 \n", "4"), // when blank is in the name input
                Arguments.of("포비,웨지\n", "0"), // when number of rounds is out of bounds
                Arguments.of("포비,삭정,삭정\n", "2") // when names are duplicate
        );
    }

    private InputStream createInputStream(String nameInput, String numberOfRoundsInput) {
        List<InputStream> streams = Arrays.asList(
                generateUserInput(nameInput),
                generateUserInput(numberOfRoundsInput));
        return new SequenceInputStream(Collections.enumeration(streams));
    }

    private boolean isControllerRunningSuccessfully(RacingGameController racingGameController) {
        try {
            racingGameController.start(scanner);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @AfterEach
    void closeScanner() {
        scanner.close();
    }
}