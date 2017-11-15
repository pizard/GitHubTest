# **URLConnection**
### URLConnection
 - URL 내용을 읽어오거나, URL 주소에 GET / POST로 데이터를 전달할 때 사용함
 - 웹 페이지나 서블릿에 데이터를 전달할 수 있음
 - URL -> openConnection() -> URLConnection() -> getInputStream -> Inpustream
 - URL의 OpenStream(): URL의 입력 스트림만 개설
 - URLConnection: URL의 입력, 출력 스트림 개설

### Construct
 - protested URLConnection(URL): 직접 생성 불가능, OpenConnection으로 연결

### Method
 - addRequestProperty(String a, String b): 특정 키 값을 가지고 읽을 수 있도록 함
 - connect(): 연결된 곳에 접속 할때 이것을 호출해야 실제 통신이 가능함
 - getAllowUserInteraction() : 연결된 곳에 사용자가 서버와 통신할 수 있는 환경 확인
 - getContent() : content 값을 리턴 받음(inputStream)
 - getContentEncoding() : 인코딩 타입을 String으로 리턴함
 - getContentLength() : content 길이(-1이면 오류)
 - getInputStream() : InputStrema 값을 뽑아냄
 - getOutputStream() : OutputStream 값을 뽑아냄

# **Java File Copy**
### 1. Stream
 - InputStream으로 파일을 받아 OutputStream을 이용하여 목적지에 파일을 쓰는 방식
```
 private static void copyFileUsingStream(File source, File dest) throws IOException {
    InputStream is = null;
    OutputStream os = null;
    try {
        is = new FileInputStream(source);
        os = new FileOutputStream(dest);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = is.read(buffer)) > 0) {
            os.write(buffer, 0, length);
        }
    } finally {
        is.close();
        os.close();
    }
}
```

### 2. Channel(java.nio.channels.FileChannel)
 - 1.4버전에서 소개된 Java NIO 클래스를 파일 복사에 사용할 수 있음.
 - transferFrom() method javadoc에 따르면 streams을 이용하는 것보다 속도가 빠름
```
private static void copyFileUsingChannel(File source, File dest) throws IOException {
    FileChannel sourceChannel = null;
    FileChannel destChannel = null;
    try {
        sourceChannel = new FileInputStream(source).getChannel();
        destChannel = new FileOutputStream(dest).getChannel();
        destChannel.transferFrom(sourceChannel, 0, sourceChannel.size());
       }finally{
           sourceChannel.close();
           destChannel.close();
   }
}
```

### 3. Apache Commons IO FileUtils
 - Apache Commons IO FileUtils.copyFile(File src, File dest)를 통해 복사할 수 있음
 - 내부적으로 NIO FileChannels를 이용하기 때문에 다른 fuction을 wrapper되는 것을 피할 수 있음
```
private static void copyFileUsingApacheCommonsIO(File source, File dest) throws IOException {
    FileUtils.copyFile(source, dest);
}
```

### 4. File class
 - 자바 7 이상에서는 Files class의 copy()를 사용 가능
```
private static void copyFileUsingJava7Files(File source, File dest) throws IOException {
    Files.copy(source.toPath(), dest.toPath());
}
```

### 5. 속도 비교
 - Stream > Files > Channel Apacke
	 - Time taken by Stream Copy = 44,582,575,000
	 - Time taken by Channel Copy = 104,138,195,000
	 - Time taken by Apache Commons IO Copy = 108,396,714,000
	 - Time taken by Java7 Files Copy = 89,061,578,000

### 6. 참고
 - [JournalDev](https://www.journaldev.com/861/java-copy-file "JournalDev")