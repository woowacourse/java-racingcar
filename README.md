# 🚀 미션 - 자동차 경주 구현

# 📈 기능 목록

## 입력
- [x] 경주 할 자동차의 이름을 입력받는다. 
- [x] 이름을 쉼표 기준으로 분리한다. 
- [x] 사용자가 잘못된 값을 입력할 경우 Exception를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 입력을 다시 받는다.

- [예외처리]
  - [x] 빈 문자열(null)이 입력된 경우 예외 처리를 한다.
  - [x] 이름이 5자 보다 클 경우 예외 처리를 한다.
  - [x] 이름이 중복된 경우 예외 처리를 한다.
  - [x] 입력된 이름이 하나일 경우 예외 처리를 한다.
  - [x] 공백(들) 혹은 ','로만 이루어진 문자열이 입력된 경우 예외 처리를 한다.
  - [x] 이름에 특수문자가 들어간 경우 예외처리를 한다. (다만, '_' 제외)
  
- [x] 시도할 횟수를 입력받는다.
- [x] 사용자가 잘못된 값을 입력할 경우 Exception를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 입력을 다시 받는다.
  - [예외처리]
  - [x] 빈 문자열(null)이 입력된 경우 예외 처리를 한다.
  - [x] 숫자가 아닐 경우 예외 처리를 한다.
  - [x] 0 이하의 값이 입력된 경우 예외 처리를 한다.

## 경기진행
- [x] 입력 받은 횟수만큼 라운드을 반복한다.
  - [x] 각 자동차마다 0~9 사이의 랜덤 값을 구해 4 이상인 경우 전진한다.
  - [x] 각 자동차마다 0~9 사이의 랜덤 값을 구해 3 이하인 경우 정지한다.
  - [x] 각 라운드마다 결과를 출력한다.

## 경기종료
- [ ] 게임이 끝난 후 가장 많이 전진한 위치를 구한다.
- [ ] 최대 위치 값에 해당하는 우승한 자동차 목록을 구한다.
- [ ] 우승자(들)를 출력한다.

---

# TODO


---
---
# 🚀 미션 - TDD 문자열 덧셈 계산기

# 📈 기능 목록

- [X]  구분자를 기준으로 구분한다
- 쉼표(,), 콜론(:)
  - 커스텀 구분자("//","\n") -> 사이에 문자 하나 옴
- [X]  파라미터가 숫자 이외의 값, 음수이면 예외처리
  - [예외] 숫자아님
  - [예외] 구분자 앞뒤에 아무것도 없을 때
  - RuntimeException
- [X]  파라미터들을 더한 값을 리턴한다
- [X] [요구사항] 빈 문자열 또는 null이 입력된 경우 0을 출력
---

# TODO

- [X] 예외처리 테스트코드 작성

## 🔍구현 로직

- ### Main diagram
- ### Util diagram
- ### View diagram

---
