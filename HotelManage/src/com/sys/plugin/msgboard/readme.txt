留言板插件使用方法：
打开插件：
1.找到src目录下面对应的beans_{database_version}.xml 配置文件打开，找到如下
已经被注释掉的节点：
<!-- <value>com/sys/plugin/msgboard/Message.hbm.xml</value> -->
把注释去掉变成如下：
<value>com/sys/plugin/msgboard/Message.hbm.xml</value>

2.找到src/com/sys/web/left/tree 目录下面的tree.xml
找到如下节点：
<!-- 
	 <manager name="留言管理" type="0">
		<link href="./plugin_jsp/message/message_add.jsp" name="添加留言" type="0" />
		<link href="message/message_query.do" name="查看留言板" type="0" />
	</manager>
	  -->
把注释去掉变成如下（如果没有该注释的就把如下节点拷贝到tree.xml）：

	<manager name="留言管理" type="0">
		<link href="./plugin_jsp/message/message_add.jsp" name="添加留言" type="0" />
		<link href="message/message_query.do" name="查看留言板" type="0" />
	</manager>

关闭插件：
把打开插件所释放的注释重新注释回去