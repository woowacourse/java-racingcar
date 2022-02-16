# java-racingcar

<details>
<summary>알파와 작성한 기능 요구사항</summary>
<div markdown="1">

1. Model
    - Car
        - [x] 이름을 가져오는 기능 (getter)
        - [x] 위치 가져오는 기능 (getter)
        - [x] 전진하는 기능 (setter)
        - [x] 특정 위치와 비교하는 기능
2. View
    - InputView
        - [X] 자동차 이름
        - [x] 움직일 횟수
    - OutputView
        - [X] 각 턴마다 자동차의 이름, 위치
        - [x] 최종 우승한 자동차들의 이름
3. Controller
    - CarListController
        - [x] 난수 생성
        - [x] CarList 움직이는 기능
    - OutputViewController
        - [x] OutputView에 LinkedHashMap 형태로 CarList 넘겨주기
        - [x] 최종 우승한 자동차 명단 ArrayList<String> 형태로 넘겨주기
    - GameController
        - [x] 전반적인 게임 실행
        - [x] car 리스트 생성
        - [x] car 리스트의 최대 위치 가져오는 기능
4. Utility
    - Const
        - Integer Const
            - [x] 전진 조건(3)
            - [X] 랜덤 범위(10)
            - [x] 이름 조건(5)
            - [x] 양수, 인덱스 조건(0)
        - String Const
            - [x] 에러 메세지
            - [x] OutputView 안내 메세지
            - [x] 위치 안내(-)
            - [x] 구분자(, :)
            - [x] 특수문자 구분용 정규식
    - Error
        - [x] 차 이름이 5글자 이상일 경우
        - [x] 주어진 횟수가 1보다 작은 경우
        - [x] 입력이 공백 / null
        - [x] 차의 개수가 0개인 경우
        - [x] 차 이름에 특수기호가 들어간 경우
        - [x] 차 이름에 중복이 있는 경우
        - [x] 횟수가 숫자형 문자열이 아닌 경우
5. Test Code
    - [x] 이름 입력 예외 테스트
    - [x] 횟수 입력 예외 테스트
    - Car TEST
        - [x] 전진하는지
        - [x] 특정 위치와 비교하기
    - Controller TEST
        - [x] 생성된 자동차 개수가 입력된 이름의 개수와 동일한지
        - [x] 최대 위치가 정확한지 // 우승자가 정확한지
        - [x] 이름과 거리 LinkedHashMap 정확한지

 </div>
</details>

<details>
<summary>닉의 첫번째 리뷰에 따른 수정사항</summary>

1. 자동차 리스트가 필드에서 관리되고 있는 문제점 수정
    - [X] 자동차 리스트를 객체로 묶기
    - [X] GameController 클래스의 getMaxPosition 메서드 이동
2. MVC 구조에 대해 다시 생각해보기
    - [X] Controller 단일화 시키기
    - [X] View를 나눈 의미를 생각해 본 후 리팩토링
3. 유틸성 클래스를 지양하고 도메인 로직을 도메인 객체 내에서 처리
    - [X] 에러 체크 로직들을 적절한 객체로 이동하여 리팩토링
    - [X] 예외에 대한 단위 테스트 진행
4. 테스트 클래스 리팩토링
    - [X] 프로덕션 코드와 동일하게 패키지와 클래스를 생성해 테스트 진행
    - [X] TDD를 진행하지 않으므로써 놓친 테스트 케이스 점검
    - [X] private 메서드에 대한 테스트는 상위 public 메서드를 통해 진행 (또는 객체의 책임 분리 고려)
    - [X] 이름에 대한 예외 처리 테스트를 최소 단위 기능별로 분리하여 추가
5. 전체적 스타일 리팩토링
    - [X] 문맥에 맞게 공백 라인으로 구분해보기
    - [X] 각각의 상수를 문맥에 맞게 적절한 위치로 분리해보기

<div markdown="1">
 </div>
</details>

<details>
<summary>닉의 두번째 리뷰에 따른 수정사항</summary>

1. 객체의 이름이 자료형에 종속되는 문제
    - [ ] CarList -> Cars로 수정하기
    - [ ] 자료형에 종속되는 다른 이름은 없는지 확인하기
2. 필드에서 관리되는 정보
    - [ ] CarList와 numberOfTurn을 필드에서 캐싱하지 않고 메서드 내에서 생성하기
3. 불필요한 메서드 생략
    - [ ] generateRandNumArray() 메서드 생략시키기
4. 테스트 추가/수정
    - [ ] movePosition 메서드에 대한 단위 테스트 진행
    - [ ] CarTest에서 Car를 공통 필드로 사용함에 따른 의존 가능성 제거
5. 반복되는 사용 상수화
    - [ ] 매번 만들어질 수 있는 Scanner 객체 상수화
    - [ ] (개인 고민) 상수화 기준 만들어 보기

<div markdown="1">
 </div>
</details>

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)

