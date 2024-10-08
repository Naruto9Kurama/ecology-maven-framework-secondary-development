# 将class文件打包成jar包
```bash
# 进入ecology/classbean目录
jar -cvf ecology-[版本号].jar .
```

# 将打包后的jar包复制到对应ecology版本模块的libs目录下

# 在pom中导入依赖

```bash
# 例如导入WeaverBoot-E9：
 <dependency>
    <groupId>com.weaver.frame</groupId>
    <artifactId>WeaverBoot-E9</artifactId>
    <version>1.0</version>
    <scope>system</scope>
    <systemPath>${ecology-libs-basedir}/WeaverBoot-E9.jar</systemPath>
</dependency>

```