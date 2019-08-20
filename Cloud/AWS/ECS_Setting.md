Setting



ECS
a. Cluster : Team1-Test-C
 0. Fargate (Replica)
 a. Service : Team1-ECS-Service-Choi
  1. Service Setting
   1-a. Fargate(Replica)
  2. Network Setting
   2-1. VPC & Security
    a. VPC            : CTT_VPC
    b. Subnet         : CTT_INT_APP1, CTT_INT_APP2
    c. Security       : CTT_SVC_SG
    d. Auto allocate Public IP : False
   2-2. ELB
    a. Application Load Balancer : TEAM1-ALB-INTERNAL1-CHOI
   2-3. Container
    a. TEAM1_Task_Container_Choi : 3000
    b. Listener Port : 80:HTTP
    c. Group Name : TEAM-Route-To-App
  3. AutoScaling
    a. Min/Want/Max : 1/1/4
    b. Policy       : Team1-Autoscaling-Choi
     - ECSServiceAverageCPUUtilization / 50%

b-1. ELB : TEAM1-ALB-CHOI
 0. Application LoadBalancing B
 1. Network Setting
  a. VPC : CTT_VPC
  b. Subnet : CTT_EXT_DMZ1, CTT_EXT_DMZ2

b-2. ELB : TEAM1-ALB-INTERNAL1-CHOI
 0. Application LoadBalancing B
 1. Network Setting
  a. VPC : CTT_VPC
  b. Subnet : CTT_INT_ELB1, CTT_INT_ELB2
             10.20.12.0/24  10.20.112.0/24






VPC
1. Internet GateWay(IGW) : CTT_IGW
 a. 연결된 VPC : CTT_VPC, 10.20.0.0/16
2. Routing Table
 a. CTT_EXT_DMZ
  - Routing : 10.20.0.0/16
  - Subnet
   - CTT_EXT_DMZ1
   - CTT_EXT_DMZ2
 b. CTT_INT_ELB
 c. CTT_INT_APP
3. NAT Gateway : CTT_NAT_GW
 a. private IP : 10.20.15.87
 b. Elastic IP : 3.113.61.52
 c. subnet     : CTT_EXT_DMZ1
 d. VPC        : CTT_VPC
