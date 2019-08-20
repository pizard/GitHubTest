VPC(Virtual Private Cloud)
a. 기능
 - 클라우드 내에서 private ip를 사용하는 일종의 가상 private network 구축
 - 하나의 VPC는 하나의 Region에서만 이용 가능
b. 목적
 - 여러 보안 정책, 세분화된 접근 제어, 하나의 EC2에 여러 IP, NIC를 할당하기 위해 사용

c. AWS의 제공 IP
 1. Elastic IP : 인스턴스에 공인 IP
 2. Public IP  : 무작위 할당, 재가동시 바뀔 수 있음
 3. Private IP : 고정 지정 가능, 유지




Subnet
a. 구성
 1.Public Subnet
  - Internet Gateway, ELB 그리고 Public IP / Elastic IP를 가진 인스턴스를 내부에 가지고 있음
  - Public Subnet 내에 있는 Nat Instance를 통하여 Private Subnet내에 있는 instances이 인터넷이 가능하게 함

 2. Private Subnet
  - 기본적으로 외부와 차단되어 있음
  - Private Subnet내의 인스턴스들은 private ip만을 갖고 있으며 internet inbound/outbound가 불가능하고 오직 다른 서브넷과의 연결만 가능함



Internet Gateway
a. 기능
 - VPC의 인스턴스와 인터넷 간에 통신을 가능하게 함
CIDR(Classless Inter Domain Routing
a. 기능
 - 서브네팅 할때 좀 더 편하게 알아볼 수 있게 하는 방법


Route Table
- IP Address에 Routing 경로를 정의하여 Subnet에서 밖으로 나가는 outbound traffic에 대한 routing 경로를 설정하는 것
