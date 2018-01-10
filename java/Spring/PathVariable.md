# PathVariable
 - 경로의 특정부분에 고정되어 있지 않고 달라지는 값을 받아올 때 사용
 - ex.
	```
	@RequestMapping("/test/__**<b>{variable}</b>**__")
	public String testController(@PathVariable String variable, Model model){
		
		...

		return "returnPage";
	}
	``` 
	 - 해당 함수 내에서 variable이란 변수를 사용할 수 있음