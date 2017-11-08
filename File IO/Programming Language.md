# 프로그래밍 언어
<img src="../image/File IO\D.D\Programming Language.png"></img> 	 
## 저급언어
 - 어렵고 사용하기에 불편하지만 컴퓨터가 처리하기엔 용이한 컴퓨터 중심의 언어

### 기계어(Machine Code)
 - 정의
 	 - 0,1로 이루어진 언어
 - 특징
 	 - CPU의 종류에 따라 다르기 때문에 통일된 규격이 없음

### 어셈블리어(Assembly Language)
 - 정의
 	 - 하드웨어와 소프트웨어의 가장 밑바닥에 있는 언어, 기계어와 명령어가 1:1로 대응되어 구성된다.
 - 특징
 	 - CPU의 종류에 따라 다르기 때문에 통일된 규격이 없음
 	 - 명령 실행 속도가 가장 빠름
 	 - 매우 세밀하게 프로그램 해야함
 	 - 하드웨어의 특성을 받아옴

## 고급 언어
 - 기종에 관계 없이 사용 가능한 사용자 중심의 언어

### 컴파일 언어(Compiled Language)
 - 정의
 	 - 기계어로 ‘컴파일’되는 언어
 - 특징
 	 - 컴퓨터 프로세서에 따라 독자적인 특징을 갖고 있음
 	 - 컴파일하게 되면 실행 가능한 프로그램(Binary File)이 생성됨
 	 - 번역과 실행이 따로 수행 됨
 - 종류
	 - C, C++, C#, JAVA, Pascal, Fortran …

### pCode(Bytecode)
 - 정의
 	 - 컴퓨터가 ‘interpret’ (Compiled)해 놓은 구문은 축약된 형태로 변형되는데, 기계어도 아니고 사용자의 고급언어도 아닌 중간자적 형태(Java의 .class)
 - 생성 과정
 	 1. 어셈블리는 하드웨어 종속적임
 	 2. CPU마다 기계어가 다르고 따라서 기계어에 대응하는 어셈블리도 CPU마다 달라진다.
 	 3. 즉 컴파일러를 만든다는 것은 CPU 종류별로 대응해야 한다는 것을 의미한다. 
 	 4. 당연히 이건 매우 귀찮고 오랜 시간이 필요한 일이다. 
 	 5. 그래서 등장한 것이 어셈블리와 소스코드의 중간 코드인 바이트 코드이다.
	 6. 바이트 코드는 인터프리터 언어다. 그리고 소스코드에서 바이트 코드로 변환하는 과정은 컴파일이다.
 - 종류
 	 - Hello. java  –(compiler)–  Hello.class  –(JVM)–  Hello동작

## 인터프리터 언어(Interpreted Language)
 - 정의
 	 - 컴파일 언어처럼 몽땅 기계어로 미리 변환되는 것이 아니고 실행 중에 ‘interpreted’하는 언어
 - 특징
 	 - 속도면에서 컴파일 언어에 비해 느리지만 전체를 recompile할 필요가 없음
 	 - 적절한 interpreter만 있다면 어떤 기종에서도 잘 실행
 - 종류
 	 - JavaScript(=JScript, ECMAScript), ActionScript, VBScript, SQL, HTML… (Script, Mark-UP언어)


## 스크립트 언어(Script Language)
 - 정의
 	 - 소스 코드를 컴파일(Compile)하지 않고도 실행 할 수 있는 언어
 	 - <del>인터프리터 언어 중 “프로그래밍 언어”라 붙이기에는 다소 단순한 기능만을 수행해 주는 것들(?)</del>
 	 - 인터프리티드 언어 중 script에 중점을 둔 언어, 기존의 어플리케이션을 부름으로써 빠르게 작업을 완료함
 	 - 클래스나 함수를 모듈화 시키는 프로그램과 다르게 편리하고 효울적으로 덜 신경쓸 수 있는 언어..?
 - non-scripting interpreted Language
 	 - 인터프리티드 언어 중 언어의 완성도, 구문의 확장에 중점을 둔 언어
 - 특징
 	 - 하나의 응용 소프트웨어(Application)을 제어하기 위한 용도로 쓰이는 언어
 	 - 컴파일 과정을 거치지 않고 실시간으로 텍스트를 분석하며 동작
 	 - 어플리케이션에 명령을 전달하기 위한 것
 	 - 단일 프로그램으로 사용되기 보다는 응용프로그램 내에서 특정 역할을 수행하는 경우가 많음
 - 용도
 	 - 시스템
 	 - 서버 사이드 스크립트(ASP, PHP, JSP, PYTHON, PERL, RUBY)
 	 - 클라이언트 사이드 스크립트(JavaScript, VBScript, JScript)
 - 종류
 	 - JavaScript, ActionScript, Perl, PHP, Python, Luna, Ruby




### 참고
 - [khanrc's blog](http://khanrc.tistory.com/entry/인터프리터와-바이트코드 "khanrc's blog")
 	 - ByteCode 생성과정
 	 - 스크립트 언어
 - [홍씨IT](http://hongci.tistory.com/18 "홍씨IT")
 	 - 어셈블리 언어
 - [Gun's Knowledge Base](http://jokergt.tistory.com/81 "Gun's Knowledge Base")
 	 - 스크립트 언어
 - [ubuntu forums](https://ubuntuforums.org/showthread.php?t=2073273 "ubuntu forums")
 	 - difference between scripting language and interpreted language
 - [Quora](https://www.quora.com/What-is-the-difference-between-interpreted-languages-and-scripting-languages "Quora")
 	 - difference between scripting language and interpreted language
 - 아따 잘 모르겠구마......ㅜㅜㅜㅜㅜㅜ


 - 다른 참고한 곳 들도 많은데 예전에 적어놓은거라 어디서 썻느지 모르겠네요ㅜㅜ 아직 진행중...ㅜ

