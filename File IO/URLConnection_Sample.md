# URLConnection Sample
## 1.BufferedOutputStream
```java
	OutputStream outStream = null;
	InputStream is = null;
	FileOutputStream fos = null;
	URLConnection uCon = null;
	URL url = null;
	
	try{
	    url = new URL(Scraping_url);
	}catch(MalformedURLException me){
		me.printStackTrace();
	}

	try{    
		uCon = url.openConnection(); 
	}catch(IOException io){
		io.printStackTrace();
	}

	try {
		
		outStream = new BufferedOutputStream(new FileOutputStream(*저장할 디렉토리 + 파일명*));
		is = uCon.getInputStream();
		byte[] buf;
		int byteRead;
		buf = new byte[is.available()];
		
		// 여기서 자꾸 돈다... buf로 받아오지를 못하는데 이유가 뭔지ㅜㅜ
		while ((byteRead = is.read(buf)) != -1) {
			outStream.write(buf, 0, byteRead);
		}
	}catch (IOException e) {
		e.printStackTrace();
	} finally {
		try {
			is.close();
			outStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
```

## 2.Files.copy
```java
	try(InputStream in = new URL(*URL*).openStream()){
		Files.copy(in, Paths.get(*저장할 디렉토리 + 파일명*), StandardCopyOption.REPLACE_EXISTING);
	}
```