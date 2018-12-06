# Exception 처리에 대해서
## 1. Exception
### 1.1 try-catch-finally
```
   try{
        // 예외 발생 가능 코드
        Class clazz = Class.forName("java.lang.String2");
    }catch(ClassNotFoundException e){   // 예외클래스 
        // 예외 처리
    }finally{
        // 항상 실행되야하는 내용
    }
```
### 1.2 다중 catch
```
    try{
        // 1. ArrayIndexOUtOfBoundsException 발생
        // 2. NumberFormatException 발생
        // 3. 다른 Exception 발생
    }catch(ArrayIndexOutOfBoundsException e){ 
        // 예외 처리1
    }catch(NumberFormatException e){   
        // 예외 처리2
    }catch(Exception e){    
        // 예외 처리3
    }finally{
        // 항상 실행되야하는 내용
    }
```
### 1.3 Multi catch
```
    try{
        // 1. ArrayIndexOUtOfBoundsException 발생
        // 2. NumberFormatException 발생
        // 3. 다른 Exception 발생
    }catch(ArrayIndexOutOfBoundsException | NumberFormatException e){ 
        // 예외 처리1, 예외 처리2
    }catch(Exception e){    
        // 예외 처리3
    }finally{
        // 항상 실행되야하는 내용
    }

```
### 1.4 try-catch-resources
```
    try(
        FileInputStream fis = new FileInputStream("file.txt")
        FileOutputStream fos = new FileOutputStream("file2.txt")
    ){
        // ...
    }catch(IOException e){
        // ...
    }
```
 - I/O등의 동작에서 명시적으로 close()를 호출하지 않아도 자동으로 처리된다.
 - 해당 리소스 객체가 java.lang.AutoCloseable 인터페이스를 구현하고 있어야 한다.

### 2. 참고
 - [eomdev's blog](https://www.journaldev.com/861/java-copy-file "eomdev's blog")