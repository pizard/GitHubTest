```
a = np.array([1, 2, 3]) : create a rank 1 array



```



- numpy.random.normal(loc=0.0, scale=1.0, size=None)
    - random samples from a normal distribution
    - parameters
        - loc : Mean of the distribution
        - scale : Standard deviation of the distribution
        - size : Output shape
    - example
        - `A=np.random.normal(mu,sig,(m,n))`

- numpy.linalg.norm(x, ord=None, axis=None, keepdims=False)
    - `ord`에 따라 8개의 matrix norms 중의 하나 or 무한 개의 vector norms 중의 하나를 반환한다.
    - parameters
        - x : 배열 입력
        - ord : norm의 방법
        - axis :  정수 인경우 vector norm을 계산할 x축 지정
        - keepdims : True 인경우 표준화된 축이 1의 크기로 남음
    - return
        - float or ndarray



- numpy.ones(shape=(a,b))
    - a * b 형태의 1행렬 생성
- numpy.zeros(shape=(a,b))
    - a * b 형태의 0행렬 생성
