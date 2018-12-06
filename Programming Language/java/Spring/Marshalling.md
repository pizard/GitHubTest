# 마샬링(Marshalling)
 - 


	```
	package com.tistory.redtrain.SampleDTO;

	import javax.xml.bind.annotation.XmlAccessType;
	import javax.xml.bind.annotation.XmlAccessorType;
	import javax.xml.bind.annotation.Xml
	import javax.xml.bind.annotation.XmlRootElement;Element;
	import javax.xml.bind.annotation.XmlType;

	@XmlType
	@XmlRootElement(name="users")
	@XmlAccessorType(XmlAccessType.FIELD)
	public class SampleDTO {

		//생성자는 필수로 선언
		public SampleDTO() {
		}

		@XmlElement
		public String userId 	= "";
		
		@XmlElement
		public String userNm 	= "";
		
		@XmlElement
		public String userPw 	= "";

		
		...
		//setter and getter
		...
	}
	```