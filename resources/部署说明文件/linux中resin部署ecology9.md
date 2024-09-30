

# 1. 下载unzip、tar解压工具
```shell
# ubuntu命令
sudo apt install unzip
sudo apt install zip
```

# 2. 下载并设置字符集为zh_CN.UTF-8
```shell
sudo locale-gen zh_CN.utf8

export LANG=zh_CN.UTF-8
```


# 3. 将文件放到同以目录下
文件列表：
1. Ecology_setup_forLinux_v2.66_forPythony3_ubuntuAndRedHat.py
2. Ecology9.00.2401.01.zip
3. jdk-8u151-linux-x64.tar.gz
4. Resin-4.0.58.zip

# 4. 执行安装程序
```shell
python3 Ecology_setup_forLinux_v2.66_forPythony3_ubuntuAndRedHat.py
```

# 5. 启动ecology
```shell
cd Resin4/bin
# 启动不监听启动日志
sudo ./startresin.sh # 若无法启动，使用chmod更改startresin.sh文件权限后启动
# 启动监听启动日志
sudo ./startresin.sh && tail -f ../log/stdout.log
```