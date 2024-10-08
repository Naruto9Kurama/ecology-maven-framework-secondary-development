# 将class文件打包成jar包
```bash
# 进入ecology/classbean目录
jar -cvf ecology-[版本号].jar .
```

# 将打包后的jar包安装到maven
```bash
# 进入创建好的maven项目中，包含pom.xml文件的目录执行命令（执行命令前，需要配置JAVA_HOME环境）
E:\maven3\bin\mvn.cmd -s "E:\.m2\settings.xml" install:install-file -DgroupId="com.weaver" -DartifactId=ecology -Dversion="[版本号]" -Dpackaging=jar -Dfile="E:\libs\ecology-[版本号].jar"

# web-inf中还有泛微的jar包，需要使用maven安装
# rpa-sso-sdk-1.0.jar
E:\maven3\bin\mvn.cmd -s "E:\.m2\settings.xml" install:install-file -DgroupId="com.weaver.rpa.sdk" -DartifactId=saas-integratesdk -Dversion="1.0-SNAPSHOT" -Dpackaging=jar -Dfile="E:\libs\rpa-sso-sdk-1.0.jar"
E:\maven3\bin\mvn.cmd -s "E:\.m2\settings.xml" install:install-file -DgroupId="com.weaver.rpa" -DartifactId=RSA -Dversion="1.0-SNAPSHOT" -Dpackaging=jar -Dfile="E:\libs\RSA-SNAPSHOT.jar"

# 未完...待补充
```

# 在pom中导入安装好的依赖

```bash
<dependency>
    <groupId>com.weaver</groupId>
    <artifactId>ecology</artifactId>
    <version>[版本号]</version>
</dependency>
```