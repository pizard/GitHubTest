# 접근하기
## iFrame -> Main
 - 앞에 parent를 붙여주면 됨
	 - var
	 	 - `parent.variableName...`
	 - id
	 	 - `parent.$("#idName")...`
	 - class
	 	 - `parent.$(".className")...`

## Main -> iFrame
 - iframe을 찾아가서 검색
 	 - var
 	 	 - `document.getElementById("iframeId").contentWindow.variableName...`;
 	 - id
 	 	 - `$("#iframeIdName").contents().find("#idName")...`
 	 - class
 	 	 - `$("#iframeIdName").contents().find("#className")...`


### 참고
 - [stackOverFlow](https://stackoverflow.com/questions/13757943/access-a-variable-of-iframe-from-parent "accessing variable in parent page from iframe")
	 - Main -> iFrame > var