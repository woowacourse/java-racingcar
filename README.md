# 문자열 계산기
1. 문자열 입력받기
2. 문자열 나누기
3. 부분 계산 하기
4. 전체 계산하기
5. 계산결과 출력하기


# java-racingcar 기능 구현 목록
### Model
1. Car
    - 자동차의 이름과 위치 저장
    - 자동차의 이름에 null이 들어온 경우 검사
    - 자동차의 이름에 공백이 들어온 경우 검사
    - 자동차의 이름이 5자 이상인 경우 검사
    - 자동차의 위치 증가
    - 다른 자동차와 위치 비교
2. CarNameSpliter
    - 입력받은 String 형태의 자동차의 이름을 ,를 기준으로 분리하여 String[]반환
    - ",,"형태의 연속된 콤마가 들어온 경우 검사
3. RacingCars
    - 차들을 저장
    - 최소 등록 자동차 검사
    - 모든 차들을 한번씩 Rule에 따라 이동
    - 차들중에서 우승자들을 찾아 반환
4. RacingGame
    - 입력받은 RacingCars와 시도 횟수와 규칙으로 race진행 후 각 시도마다의 결과를 저장한 RacingCars 목록 반환
    - 최소 차동차 수 판단
    - 최소 시도 횟수 판단
5. RandomNumberGenerator
    - 지정한 범위 내에서 난수 생성
6. Rule
    - 레이싱 게임의 이동 규칙
7. MoveRule
    - 4이상의 수가 입력될 경우에만 이동 가능
    - 특정한 입력값이 없는 경우 1 ~ 9사이의 랜덤한 값을 적용


### View
1. InputView
   - 사용자로부터 자동차 목록 입력받아 컨트롤러에 전달
   - 사용자로부터 시도할 횟수를 입력받아 컨트롤러에 전달
2. OutputView
   - 컨트롤러로 부터 받은 자동차들의 이름과 위치 출력
   - 컨트롤러로 부터 받은 우승자들의 이름 목록 출력
   
### Controller
- InputView에 자동차 목록 요청
- InputView에 시도 횟수 요청
- Racing게임에 적용할 Rule 결정
 
- 자동차 목록, 시도 횟수, Rule을 RacingGame에 전달해 게임 진행
- 게임진행 결과를 OuptView에 전달
- 우승자를 출력하기 위한 마지막 게임 진행 결과를 OutputView에 전달

## 우아한테크코스 코드리뷰
* [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)
