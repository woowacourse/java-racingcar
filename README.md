## 우아한테크코스 코드리뷰

* [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)

## Commit Message Convention

* ``Feat`` feature
* ``Fix`` bug fix
* ``Docs`` documentation
* ``Style`` formatting, missing semi colons...
* ``Refactor``
* ``Test`` when adding missing test

## Rule for TDD  

1. create fail test code
2. create test as much as possible
   - skip hard test

# 1.string-calculator

문자열 덧셈 계산기를 통한 TDD/리팩토링 실습

## 요구사항  

* 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 
  - (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
* 앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
  - 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
* 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.

## 입력

- null값을 입력할 경우 0을 반환한다.
- 빈 문자열을 입력할 경우 0을 반환한다.
- 숫자 이외의 값을 입력할 경우 RuntimeException을 throw 한다.
- 음수를 입력할 경우 RuntimeException을 throw 한다.
- 문자열 format이 잘못된 경우
  - 구분자가 ``//``와 ``\n``사이에 존재하지 않을 경우 (ex. //;1;2;3)
  - 구분자가 다를 경우 (ex. 1;2:3)

## 기능목록  

1. null 또는 빈 문자열에 대해 0을 반환한다.  
   - null이 들어올 때 테스트
   - 빈 문자열이 들어올 때 테스트

2. 기본 구분자(``,``,``:``)로 구성된 문자열에 대해 덧셈 결과를 반환한다.
   - ``,``를 구분자로 사용하는 경우의 테스트
   - ``:``를 구분자로 사용하는 경우의 테스트
   - ``,``, ``:``를 구분자로 같이 사용하는 경우의 테스트
3. 커스텀 구분자로 분리된 문자열에 대해 덧셈 결과를 반환한다. (ex. //;\n1;2;3)
   - 커스텀 구분자로 문자열을 분리하는 테스트

# 2.java-racingcar

자동차 경주 게임 미션
