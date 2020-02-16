package racingcar.message;

/*
 * Copyright (c) 2020 by 또동페어
 * All rights reserved.
 *
 * Message.java
 * 메지시를 저장하는 enum
 *
 * @author      또동페어
 * @version     1.0
 * @date        12 Feb 2020
 *
 */
public enum RacingCarMessage {
	INPUT_CAR_NAMES("자동차 이름을 입력하세요 (1 - 5글자) :"),
	INPUT_NUMBER_OF_ROUND("게임라운드를 입력하세요 :"),
	EXCEPTION_CAR_IS_NULL("max position car is null"),
	EXCEPTION_ROUND_IS_NOT_POSITIVE("round number must be positive"),
	EXCEPTION_NOT_ENOUGH_CAR("car must be at least one"),
	EXCEPTION_LENGTH_OF_NAME("name must be between 1-5"),
	EXCEPTION_DUPLICATED_NAME("name can not be duplicated"),
	ROUND_START("실행 결과"),
	EXCEPTION_NAME_NULL_OR_BLANK("name can not be null or blank"),
	ILLEGAL_CAR_POSITION("position can not be negative"),
	ILLEGAL_ENGINE_LEVEL("illegal engine level detected");

	private final String messageText;

	RacingCarMessage(String messageText) {
		this.messageText = messageText;
	}

	public String getMessageText() {
		return messageText;
	}
}
