# JWT(JSON Web Token)
 - 용도
	 - 웹표준으로서 두 개체에서 JSON 객체를 사용하여 가볍고 자가수용적인 방식으로 정보를 안전성있게 전달
 - 특징
 	 - 다양한 프로그래밍 언어에서 지원
 	 	 - C/JAVA/Python/C++/Perl/PHP/JavaScript/Ruby/Go/Swift
 	 - 자가수용적
 	 	 - 필요한 정보를 자체적으로 지니고 있음
 	 	 - JWT에서 발급된 토큰은 토큰에 대한 기본정보 전달 할 정보 그리고 토큰이 검증됐다는 것을 증명해주는 signature를 포함
 	 - 쉽게 전달할 수 있음
 	 	 - 웹서버의 경우 HTTP헤더에 넣어서 전달하거나 URL의 파라미터로 전달하는 등 사용이 쉬움
 - 사용 예시
 	 - 회원 인증
 	 - 정보 교류
 - JWT의 생김새
 	`aaaaaa.bbbbbb.cccccc`
 	 - a: 헤더(header)
 	 	 - typ
 	 	 	 - 토큰의 타입지정(JWT)
 	 	 - alg
 	 	 	 - 해싱 알고리즘(HMAC SHA256 혹은 RSA.. etc)
 	 	 	 - 토큰을 검증할 때 사용되는 signature부분에서 사용
 	 	 - ex.
 	 	 	```
 	 	 	{
				"typ": "JWT",
				"alg": "HS256"
			}
 	 	 	```
 	 	 		 - `eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9`
 	 - b: 정보(payload)
 	 	 - 토큰에 담을 정보들
 	 	 - 클레임(claim): 정보의 한 '조각'
	 	 	 - name / value의 쌍으로 이루어져 있음
	 	 	 - registed claim(등록된 클레임)
	 	 	 	 - 서비스에서 필요한 정보들이 아닌 토큰에 대한 정보들을 담기위하여 이름이 이미 정해진 클레임
	 	 	 	 - iss: 토큰 발급자(issuer)
	 	 	 	 - sub: 토큰 제목(subject)
	 	 	 	 - aud: 토큰 대상자(audience)
	 	 	 	 - exp: 토큰의 만료 시간(expiration)
	 	 	 	 - nbf: Not Before, 토큰의 활성 날짜
	 	 	 	 - iat: 토큰이 발급된 시간(issued at), 토큰의 age 판단
	 	 	 	 - jti: JWT의 고유 식별자, 중복적인 처리 방지
	 	 	 - public claim(공개 클레임)
	 	 	 	 - 충돌이 방지된(collision-resistant) 이름을 갖고 있어야 함
	 	 	 	 - 충돌을 방지하기 위해서는 클레임 이름을 URI형식으로 지음
	 	 	 - private claim(비공개 클레임)
	 	 	 	 - 양측간에(클라이언트 <-> 서버) 협의하에 사용되는 클레임 이름들.
	 	 	 	 - 공개 클레임과 달리 이름이 중복되어 충돌이 될 수 있으니 유의해야 함
	 	 - ex.
	 	 	```
	 	 	{
				// registered claim
				"iss": "velopert.com",
				"exp": "1485270000000",
				// public claim
				"https://velopert.com/jwt_claims/is_admin": true,
				// private claim
				"userId": "11028373727102",
				"username": "velopert"
			}
	 	 	```
	 	 		 - `eyJpc3MiOiJ2ZWxvcGVydC5jb20iLCJleHAiOiIxNDg1MjcwMDAwMDAwIiwiaHR0cHM6Ly92ZWxvcGVydC5jb20vand0X2NsYWltcy9pc19hZG1pbiI6dHJ1ZSwidXNlcklkIjoiMTEwMjgzNzM3MjcxMDIiLCJ1c2VybmFtZSI6InZlbG9wZXJ0In0`
 	 - c: 서명(signature)
 	 	 - 헤더의 인코딩값, 정보의 인코딩값을 합친 후 주어진 비밀키로 해쉬를 하여 생성
 	 	 - 순서
 	 	 	1. 헤더와 정보의 인코딩 값 사이에 .을 넣어주고 합침
 	 	 	`eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ2ZWxvcGVydC5jb20iLCJleHAiOiIxNDg1MjcwMDAwMDAwIiwiaHR0cHM6Ly92ZWxvcGVydC5jb20vand0X2NsYWltcy9pc19hZG1pbiI6dHJ1ZSwidXNlcklkIjoiMTEwMjgzNzM3MjcxMDIiLCJ1c2VybmFtZSI6InZlbG9wZXJ0In0`
 	 	 	2. 비밀키의 값을 secret으로 해싱하고 base64로 인코딩