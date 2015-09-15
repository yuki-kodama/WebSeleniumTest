# WebSeleniumTest

### Requirements
+    [Oracle JDK](http://www.oracle.com/technetwork/java/javase/overview/index.html)
+    [Maven](https://maven.apache.org/)
or
 [Gradle](https://gradle.org/)
 
 
### Installation & Execute 
    
    # git clone https://github.com/yuki-kodama/WebSeleniumTest.git  
    # cd /path/to/WebSeleniumTest  
    # mvn clean pakcage  // Maven download jar and compile.  
    # mvn exec:java      // Maven execute Main Class.  
    # gradle run         // Gradle download jar, compile and run Main Class.  
    
###  
change "telNO".
    
    new WebSeleniumTest().execute("0904961xxxx"); <- change here.

use proxy.
    
    private static final boolean PROXY_USE = true;            <- change here.
    private static final String PROXY = "proxy.xxxx.jp:8080"; <- change here.
    