# 자동차 경주 미션 기능목록

- [] 사용자가 잘못된 입력을 할 경우에는 그 부분부터 재입력을 받는다.

- 경주할 자동차 이름을 입력받는다.
    - [] 자동차 이름은 쉼표(,)로만 구분 가능하다.
    - [x] 2대 이상의 자동차가 참여해야 한다.
    - [x] 이름은 5자 이하만 가능하다.
    - [x] 자동차 이름은 문자로만 입력 가능하다. (영어, 한글)
    - [x] 중복된 자동차 이름을 입력할 수 없다.
    - [x] null 또는 빈 값을 입력할 수 없다.
    - [x] 자동차 이름 앞 뒤에 공백이 존재해선 안된다.
    - [x] 경주에 참여 가능한 자동차는 최대 20대까지이다.

- 시도할 횟수를 입력받는다.
    - [] 1이상의 횟수를 입력해야한다.
    - [] 숫자가 아닌 값을 입력할 수 없다.

- 랜덤한 숫자 추출
    - [] 0 ~ 9 범위의 수 이어야 한다.
    - [] 랜덤한 숫자가 4이상일 경우 해당 자동차는 전진하다.
    - [] 랜덤한 숫자가 3이하일 경우 해당 자동차는 움직이지 않는다.

- 실행 결과 출력
    - [] 아래 예시와 같이 각 자동차 별로 자동차의 움직임을 `-` 표시한다. `pobi가 두 번 움직였을경우 ex) pobi : --`
```angular2html
pobi : -
crong : -
honux : -

pobi : --
crong : -
honux : --
```

- 최종 우승자 출력
    - [] 경주가 끝난 시점에서 제일 많이 이동한 자동차가 최종 우승자가 된다. `ex) pobi가 최종 우승했습니다.`
    - [] 우승자는 한 명 이상일 수 있다.
    - [] 우승자가 한 명 이상일 경우 쉼표 (, )로 구분하여 출력한다. `ex) pobi, honux가 최종 우승했습니다.`