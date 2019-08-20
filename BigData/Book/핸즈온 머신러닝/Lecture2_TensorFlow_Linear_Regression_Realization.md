0. Reference
     - https://github.com/hunkim/DeepLearningZeroToAll/
1. Hypothesis and cost function
    - 주어진 값에 대해 어떻게 예측할 것 인가?
        - H(x) = Wx + b
        - 실제 값과 차이의 제곱을 평균하여 수치화
2. TensorFlow Mechanics
    1. Building graph using TensorFlow
        - H(x) = Wx + b
            - W = tf.Variable(tf.random_normal([1]), name='weight')
            - b = tf.Variable(tf.random_normal([1]), name='bias')
                - Variable: Tensorflow가 사용하는 변수(Trainable)
                - [1] : 값이 하나인 1차원 Lable
            → Hypothesis = x_train * W + b
            → cost = tf.reduce_mean(tf.square(hypothesis - y_train))
                - reduce_mean : tensor가 제공되었을때 평균치
        - 어떻게 해결할 것인가?
            - GradientDescent
                ```
                # Minimize
                optimizer = tf.train.GradientDescentOptimizer(learning_rate=0.01)
                train = optimizer.minimize(cost)
                ```
    2. feed data and run graph
    3. update variable in the graph
    ```
    # X and Y data
    x_train = [1, 2, 3]
    y_train = [1, 2, 3]

    W = tf.Variable(tf.random_normal([1]), name='weight')
    b = tf.Variable(tf.random_normal([1]), name='bias')

    # Our hypothesis XW+b
    hypothesis = x_train * W+b

    # cost/loss function
    cost = tf.reduce_mean(tf.square(hypothesis - y_train))

    #Minimize
    optimizer = tf.train.GradientDescentOptimizer(learning_rate=0.01)
    train = optimizer.minimize(cost)

    # Launch the graph in a session
    sess = tf.Session()
    # Initializes global variables in the graph
    sess.run(tf.global_variables_initializer())

    # Fit the line
    for step in range(2001):
        sess.run(train)
        if step % 20 == 0:
            print(step, sess.run(cost), sess.run(W), sess.run(b))
    ```

3. Placeholders
    ```
    # X and Y data
    # x_train = [1, 2, 3]
    # y_train = [1, 2, 3]

    W = tf.Variable(tf.random_normal([1]), name='weight')
    b = tf.Variable(tf.random_normal([1]), name='bias')
    X = tf.placeholder(tf.float32, shape = [None]) # [None] : 1차원 Array안에서 마음대로 줄 수 있음
    Y = tf.placeholder(tf.float32, shape = [None])

    # Our hypothesis XW+b
    hypothesis = X * W + b

    # cost/loss function
    cost = tf.reduce_mean(tf.square(hypothesis - Y))

    #Minimize
    optimizer = tf.train.GradientDescentOptimizer(learning_rate=0.01)
    train = optimizer.minimize(cost)

    # Launch the graph in a session
    sess = tf.Session()
    # Initializes global variables in the graph
    sess.run(tf.global_variables_initializer())

    # Fit the line
    # for step in range(2001):
    #     sess.run(train)
    #     if step % 20 == 0:
    #         print(step, sess.run(cost), sess.run(W), sess.run(b))

    for step in range(2001):
        cost_val, W_val, b_val, _ = sess.run([cost, W, b, train],
                    feed_dict={ X: [1, 2, 3, 4, 5],
                                Y: [2.1, 3.1, 4.1, 5.1, 6.1]})
        if step % 20 == 0:
            print(step, cost_val, W_val, b_val)
    ```
