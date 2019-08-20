# Efficient Backprop
## Introduction
- 저자 : Yann LeCun, Leon Bottou, Genevierve B. Orr, Klaus-Robert-Muller
- 출판년도 : 1988
- Introduction
    - (optional) 논문리뷰 하는 법
    - 선대 사전지식(hessian, jacobian etc)
    - 전반적인 내용이 어떻게 진행될지 결론 설명

## 논문 리뷰법
### 엄태웅(Feat. 연예인)
- 구조
    1. `Abstract` : 문제제기
    2. `Introduction` : 연구의 기원
    3. `Related works` : 기존의 접근법`
    4. `Method` : 새로운 접근법
    5. `Experiment` : 실험
    6. `Discussion` : 검증 및 한계
    7. `Colclusion` : 요약
- 순서
    - Abstract > Conclusion > Introduction > ...
- etc
    - ... blablablablabla~

### 태희님(Feat. 갓)
- 논문 검색 : 구글 검색 및 arxiv
- 논문 관리 : mendeley
    - 소셜 네트워크 기반의 서지관리 소프트웨어
- 좋은 논문 : CS231n or ICLR, ACL, EMNLP...의 학회에서 accepted 붙은 논문
- 논문 리뷰
    - `어떤 문제를 풀려고 하는지`
        - 논문의 문제 의식 in `introduction` or `abstract`
    - `지난 연구의 흐름`
        - 과거에는 어떤 방식을 취했었고 리뷰 논문 과의 차이 in `introduction`
    - `Task의 소개(Option)`
        - 보통 제목에 많이 나와 있음
        - architecture들의 용도와 input과 output
    - `Model, method`
        - Input - Output사이의 과정 + 의미
    - `논문에 대한 해석`

## 선형대수 사전 지식
### Gradient
- 각 변수로의 일차 편미분 값으로 구성되는 벡터
- f의 값이 가장 가파르게 증가하는 방향
- 벡터의 크기 : 가파른 정도
### Jacobian
- 어떤 다변수 벡터함수(vector-valued function of multiple variables)에 대한 일차 미분
### Hessian
- 함수의 곡률(curvature) 특성을 나타내는 행렬로 함수의 이차 미분
    - 어떤 함수의 critical point에서 계산한

## 전반적 내용 설명
### Abstract
- `지난 연구의 흐름`
    - 그동안 많은 저자들이 신경망의 훈련에 대한 2차 최적화 방법들을 제안해 왔으나 대부분의 고전적 방법들은 대형 신경 네트워크에 대해 실용적이지 못했으며 몇 몇의 방법만이 제한 없이 작동해 왔습니다.
        - ➔ 그동안은 대형 신경 네트워크에 대해서는 좀 구렸어!

- `어떤 문제를 풀려고 하는지?`
    - 실험에서 관찰된 일반적인 현상들을 설명하기 위해 back-prop들을 분석함
    - 이런 분석을 통해 back-prop의 수행 시 잘못된 행동들을 피하기 위한 방법들의 종류와 이것들이 대체 왜 작동 하는지!
        - ➔ 그니까 이런 제한이 없도록 최적화를 해 보아요!

### Introduction
- Backpropagation
    - 장점
        - 개념적으로 간단함
        - 효율적
        - 대부분 잘 동작함
    - 단점
        - 데이터에 의존적임
        - 여러 문제들이 섞여 명확한 근거를 찾기 힘듬
        - 하이퍼파라미터(노드&레이어의 유형과 갯수 / 학습율 / 훈련&시험 세트...etc)
    - 포인트
        - 과학(science, 이론 or 이성)보다는 예술(art, 감각)이 중요
        - 경험적이고 근본적인 이론 정립을 통해 실험자들이 더 나은 선택(Hyperparameter)을 할 수 있도록 해야 함
- 진행 순서
    1. backpropagation, 그리고 그동안 쌓인 수 많은 경험과 기술들에 대한 설명
    2. 고전적인 2차 비선형 최적화 기술들과 이들의 한계
    3. 특정 상황에서 학습을 가속하기 위한 몇 가지 2차 방법들

### Conclusion
- 앞 내용들의 요약
    - multi-layer 신경망 훈련 문제를 직면한 실무자들이 따라야 할 과정
    > 1. shuffle the examples <br>
    > 2. center the input variable by subtracting the mean <br>
    > 3. normalize the input variable to a standard deviation of 1 <br>
    > 4. if possible, decorrelate the input variables. <br>
    > 5. pick a network with the sigmoid function shown in figure 4 <br>
    > 6. set the target values within the range of the sigmoid, typically +1 and -1 <br>
    > 7. initialize the weights to random values as prescribed by 16 <br>

    - 훈련시 선호되는 방법들
    > 1. if the training set is large(more than a few hundred samples) and rebundant, and if the task is classification, use stochastic gradient with careful tuning, or use the stochastic diagonal Levenberg Marquardt method.
    > 2. if the training set is not too large, or if the task is regression, use conjugate gradient

- 개선사항
    - multi-layer 신경망에서의 stochastic gradient decsent의 비선형 동역학은 특히 일반화에 대해 잘 이해되지 않고 있기에 더 많은 이론과 시스템적 실험 작업들을 필요로 함

### 후기..?
- 와... 영어 진짜 헬파티다...
    - 내용들을 보면 다 배웠던 내용들이고 어려운 내용들도 아닌데...
        - 만약 내가 잘 모르는 내용의 논문들을 리뷰하게 된다면..?
    - 대학원을 갈 생각이 없었던 건 아닌데...
- 근데 이러니까 영미 국가들이 핫한 이유중 하나가 아닐까...
    - 한국어로 쓰면 한번만 읽으면 끝날 내용들을 3-4번씩 읽고 앉았으니...


인풋 / 엑티베이션 / 웨이트 / 트레이닝 메서드
