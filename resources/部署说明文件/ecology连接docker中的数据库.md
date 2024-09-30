# Mysql
运行容器时需要设置其参数
```bash
docker run  -p 3306:3306 --name mysql-ecology -e MYSQL_ROOT_PASSWORD=my_root_psw -d mysql:latest --character-set-server=utf8 --innodb_buffer_pool_size=512M --log_bin_trust_function_creators=1 --lower_case_table_names=1 --max_connections=5000 --sql_mode=NO_ENGINE_SUBSTITUTION,STRICT_TRANS_TABLES --transaction_isolation=READ-COMMITTED --group_concat_max_len=102400
```


# Oracle
适用12以下版本
```bash
docker run -d -p 1521:1521 --name Oracle-11g iatebes/oracle_11g

# 进入容器后执行下列命令
ln -s /opt/oracle/app/product/11.2.0/dbhome_1/bin/sqlplus /usr/bin # 在容器中创建软连接
su - oracle #从root切换到oracle用户（中间的减号必须添加）

sqlplus /nolog #进入sqlplus
conn /as sysdba; -- 以系统管理员身份登录
alter user system identified by system; #system用户密码修改为system
alter user sys identified by sysdba; #sys用户密码修改为sysdba
ALTER PROFILE DEFAULT LIMIT PASSWORD_LIFE_TIME UNLIMITED; #修改密码规则策略为密码永不过期
alter system set processes=1000 scope=spfile; #修改数据库最大连接数
 

# 重启数据库或容器，然后执行下列命令(可选修改连接的service_name名，即数据库名)
show parameter name; # 查看参数：service_names为orcl
alter system set service_names=ecology-service scope=both; #修改service_names
```