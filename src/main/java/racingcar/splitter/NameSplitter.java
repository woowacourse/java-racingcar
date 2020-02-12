package racingcar.splitter;

import racingcar.message.Message;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/*
 * Copyright (c) 2020 by 또동페어
 * All rights reserved.
 *
 * NameSplitter.java
 * 이름분리를 담당하는 클래스
 *
 * @author      또동페어
 * @version     1.0
 * @date        12 Feb 2020
 *
 */
public class NameSplitter {
    public static final String DELIMITER = ",";
    public static final int MINIMUM_NUMBER_OF_NAMES = 2;
    public static final int MINIMUM_LENGTH_OF_NAME = 1;
    public static final int MAXIMUM_LENGTH_OF_NAME = 5;

    public static List<String> split(String nameValue) {
        List<String> names = Arrays.stream(nameValue.split(DELIMITER))
                .collect(Collectors.toList());
        if (names.size() < MINIMUM_NUMBER_OF_NAMES) {
            throw new IllegalArgumentException(Message.EXCEPTION_NOT_ENOUGH_CAR.getMessageText());
        }
        for (String name : names) {
            if (name.length() < MINIMUM_LENGTH_OF_NAME || name.length() > MAXIMUM_LENGTH_OF_NAME) {
                throw new IllegalArgumentException(Message.EXCEPTION_LENGTH_OF_NAME.getMessageText());
            }
        }
        Set<String> tmpNameSet = new HashSet<>(names);
        if (tmpNameSet.size() != names.size()) {
            throw new IllegalArgumentException(Message.EXCEPTION_DUPLICATED_NAME.getMessageText());
        }
        return names;
    }
}
