# LOG파일 만들기 추후 정리
```
public void createErrorLogFile(String log, String dateString) throws Exception {
		
		directoryCheck(rootSavePath+ "ERROR_LOG");

		//로그 파일이 저장 될 경로
        String errorLogSavePath = rootSavePath + "ERROR_LOG\\"+ dateString+".log";  
        String timeFormat = "HH:mm:ss";
//		java.text.SimpleDateFormat timeFormatter = new java.text.SimpleDateFormat("HH:mm:ss", Locale.KOREAN);
		SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm:ss", Locale.KOREAN);
        String stTime = timeFormatter.format(new Date());

        StringBuffer bufLogMsg = new StringBuffer();
            bufLogMsg.append("[");
            bufLogMsg.append(stTime);
            bufLogMsg.append("]\r\n");
            bufLogMsg.append(log);
            try{
            	  
                FileWriter objfile = new FileWriter(errorLogSavePath, true);
                objfile.write(bufLogMsg.toString());
                objfile.write("\r\n");
                objfile.close();
        }catch(IOException e){
            e.printStackTrace();
        }
	}
```