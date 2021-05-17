## Linux概述 ##
	1. 发展：Unix-->Linux:redhat、centos、红旗、ubuntu、suse
	2. Linux是由Linus Torvalds（林纳斯·托瓦兹）起初开发的
	3. windows目录反斜杠 \
	4. Linux  目录斜杠   /
	5. 目录结构：
		1. etc:存放系统配置文件
		2. usr:存放系统共享资源
		3. home:用户主目录
		4. root:管理员组目录
		5. bin:可执行二进制文件
	6. 用户配置文件
		1. 【账户文件】
			/etc/passwd  用户文件 
			/etc/shadow  密码文件 
			/etc/group  组信息文件
		2. 【用户文件】
			root:x:0:0:root:/root:/bin/bash 
			账号名称：		在系统中是唯一的 
			用户密码：		此字段存放加密口令 
			用户标识码(User ID)：  系统内部用它来标示用户 
			组标识码(Group ID)：   系统内部用它来标识用户属性 
			用户相关信息：		例如用户全名等 
			用户目录：		用户登录系统后所进入的目录 
			用户环境:		用户工作的环境
		3. 【密码文件】
			shadow文件中每条记录用冒号间隔的9个字段组成. 
			用户名：用户登录到系统时使用的名字，而且是惟一的 
			口令：  存放加密的口令 
			最后一次修改时间:  标识从某一时刻起到用户最后一次修改时间 
			最大时间间隔:  口令保持有效的最大天数，即多少天后必须修改口令 
			最小时间间隔：	再次修改口令之间的最小天数 
			警告时间：从系统开始警告到口令正式失效的天数 
			不活动时间：	口令过期少天后，该账号被禁用 
			失效时间：指示口令失效的绝对天数(从1970年1月1日开始计算) 
			标志：未使用 
		4. 【组文件】
			root:x:0: 
			组名：用户所属组 
			组口令：一般不用 
			GID：组ID 
			用户列表：属于该组的所有用户


## 基本命令 ##
### 目录切换命令 ###
	* cd usr	切换到该目录下usr目录 	
	* cd ../	切换到上一层目录 	
	* cd /		切换到系统根目录 	
	* cd ~		切换到用户主目录 	
	* cd -		切换到上一个所在目录

### 目录操作命令（增删改查） ###
	1. 创建目录：mkdir 目录名称
	2. 查看目录：ls
				-a:查看全部，包括隐藏
				-l:查看详细信息（ls -l  ===  ll）
	3. 查找目录：find 目录 参数
				find /root 'test*'      单引号


	4. 修改目录名称：mv 目录名称 新目录名称
				   mv olddir new dir
	5. 移动目录的位置---剪切：mv 目录名称 目录的新位置
				   mv newdir /user
				   *注意：mv可对文件，压缩包重命名剪贴


	6. 拷贝目录
		命令：cp -r 目录名称 目录拷贝的目标位置 -----r代表递归拷贝（文件也可以）
		示例：将/usr下的newTest拷贝到根目录下的test中
		使用cp -r /usr/newTest /test

	7. 删除目录
		命令：rm [-rf] 目录
			-r:删除
			-f:不询问直接删除
		示例：删除/usr下的newTest，进入/usr下使用rm -r newTest

### 文件的操作命令（增删改查） ###
	1. 文件的创建（增）
		命令：touch 文件名称
	2. 文件的查看（查）
		命令：cat/more/less/tail 文件
			* cat:显示文件左右内容
			* more:分页显示文件内容
				* 空格：向下一屏
				* b/ctrl+b:向上一屏
				* q:退出
			* less:
				* -m:百分比
				* -N:显示行号
				* 空格：向下一屏
				* b/ctrl+b:向上一屏
				* q:退出
			* tail:
				* tail -10 查看/etc/sudo.conf文件的后10行
				* Ctrl+C结束
	3. 修改文件的内容（改）
		命令：vim 文件
		示例：编辑/test下的aaa.txt文件，使用vim aaa.txt
			点击键盘i/a/o进入编辑模式，可以	编辑文件
			编辑完成后，按下Esc，退回命令模式
			输入冒号：进入底行模式，在底行模式下输入wq代表写入内容并退出，即保存；
			输入q!代表强制退出不保存。

	4. 删除文件（删）
		同目录删除：熟记 rm -rf 文件 即可

### 压缩文件的操作命令 ###
	1. 打包：	.tar结尾
	2. 压缩：	*.gz
	3. 打包并压缩：*.tar.gz

	1. 命令：tar -zcvf 打包压缩后的文件名 要打包压缩的文件
		其中：z：调用gzip压缩命令进行压缩
  		c：打包文件
  		v：显示运行过程
  		f：指定文件名
		示例：打包并压缩/test下的所有文件 压缩后的压缩包指定名称为xxx.tar.gz
		tar -zcvf xxx.tar.gz aaa.txt bbb.txt ccc.txt
		或：tar -zcvf xxx.tar.gz /test/*

	2. 解压压缩包（重点）
		命令：tar [-xvf] 压缩文件
		其中：x：代表解压
		* 示例：将/test下的xxx.tar.gz解压到当前目录下
			 tar -xvf xxx.tar.gz
		* 示例：将/test下的xxx.tar.gz解压到根目录/usr下
			 tar -xvf xxx.tar.gz -C /usr		--C代表指定解压的位置

#### 其他命令 ####
	1. 显示当前所在位置
		pwd

	2. 搜索命令
		* 命令：grep 要搜索的字符串 要搜索的文件
			示例：搜索/usr/sudu.conf文件中包含字符串to的行
				grep to sudo.conf
			示例：搜索/usr/sudu.conf文件中包含字符串to的行 to要高亮显示
		* locate 文件名		（在文件资料库中查询）

	3. 管道命令
		命令：|   将前一个命令的输出作为本次目录的输入
		示例：查看当前系统中所有的进程中包括system字符串的进程
		ps -ef|grep system

	4. 重定向输出>和>>
		> 重定向输出，覆盖原有内容； 
		>> 重定向输出，又追加功能； 
		示例：
		cat /etc/passwd > a.txt  将输出定向到a.txt中
		cat /etc/passwd >> a.txt  输出并且追加
		ifconfig > ifconfig.txt

	5. 网络通讯命令
	* ifconfig  显示或设置网络设备。
		ifconfig  显示网络设备
		ifconfig eth0 up 启用eth0网卡
		ifconfig eth0 down  停用eth0网卡 

	* ping   探测网络是否通畅。
		ping 192.168.0.1 netstat 查看网络端口。
		netstat -an | grep 3306 查询3306端口占用情况

	* 查看当前系统的端口使用
		netstat -an

	6. 系统管理命令
	* date 显示或设置系统时间
		date  显示当前系统时间
		date -s “2014-01-01 10:10:10“  设置系统时间 

	* df 显示磁盘信息
		df –h  友好显示大小 

	* free 显示内存状态
		free –m 以mb单位显示内存组昂头 

	* top 显示，管理执行中的程序
	
	* clear 清屏幕 

	* ps 正在运行的某个进程的状态
		ps –ef  查看所有进程
		ps –ef | grep ssh 查找某一进程 
	* kill 杀掉某一进程
		kill 2868  杀掉2868编号的进程
		kill -9 2868  强制杀死进程
	
	* du 显示目录或文件的大小。
		du –h 显示当前目录的大小

	* who 显示目前登入系统的用户信息。 

	* hostname 查看当前主机名

	* uname 显示系统信息。
		uname -a 显示本机详细信息。 
		依次为：内核名称(类别)，主机名，内核版本号，内核版本，内核编译日期，硬件名，处理器类型，硬件平台类型，操作系统名称

	7. 下载资料
	    wget http://nginx.org/download/nginx-1.9.12.tar.gz

	8. 查看进程
		命令：ps -ef

	9. 杀死进程
		命令：kill -9 (进程的pid)
	
## Linux的权限命令 ##
	1. 权限
![](https://ftp.bmp.ovh/imgs/2020/03/de82401b4faa8e79.png)

	2. 文件的类型
		1. d：代表目录
		2. -：代表文件
		3. l：代表链接（可以认为是window中的快捷方式）
	3. 用户管理
		1. 添加用户
			useradd 添加一个用户
			useradd test 添加test用户
			useradd test -d /home/t1  指定用户home目录 
			passwd  设置、修改密码
			passwd test  为test用户设置密码

		2. 切换登录：
			su – 用户名
		3. 删除用户
			userdel 删除一个用户
			userdel test 删除test用户(不会删除home目录)
			userdel –r test  删除用户以及home目录
	4. 组管理
		当在创建一个新用户user时，若没有指定他所属于的组，就建立一个和该用户同名的私有组 
		创建用户时也可以指定所在组 
		groupadd  创建组
		groupadd public  创建一个名为public的组
		useradd u1 –g public  创建用户指定组 groupdel 删除组，如果该组有用户成员，必须先删除用户才能删除组。
		groupdel public
	5. 用户和组的命令
		1. id：查看一个用户的UID和GID
		2. su：切换用户
			* su u1  切换到u1用户
			* su - u1 切换到u1用户，并且将环境也切换到u1用户的环境（推荐使用）

	4. 数字权限
		后面的9位分为3组，每3位置一组，分别代表属主的权限，与当前用户同组的	用户的权限，其他用户的权限
		r：代表权限是可读，r也可以用数字4表示
		w：代表权限是可写，w也可以用数字2表示
		x：代表权限是可执行，x也可以用数字1表示
	5. 修改文件权限
		* 示例：修改/test下的aaa.txt的权限为属主有全部权限，属主所在的组有读写权限，其他用户只有读的权限
		chmod u=rwx,g=rw,o=r aaa.txt
		chmod 764 aaa.tx

