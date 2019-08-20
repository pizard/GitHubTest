# Linear Regression의 cost 최소화 알고리즘 원리 설명
- cost가 최소가 되는 Y의 값 구하기
    - Gradient descent algorithm
        - 특징
            - 경사를 따라 내려가는 알고리즘
            - W를 계속 변경시키며 내려가는 방향으로 진행
        - 한계
            - 그래프가 양탄자의 형태라면..?
            - Convex function(뒤집은 밥그릇 모양)에서 유용
- Tensorflow
    - reduce_mean(X)
        - 특정 차원을 제거하고 평균을 구함
    - reduce_sum(X)
        - 특정 차원을 제거하고 합을 구함
## ML lab 03 - Linear Regression 의 cost 최소화의 TensorFlow 구현 (new)
