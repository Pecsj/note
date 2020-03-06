## XML语法 ##
### 文档声明 ###
	1. 必须以<?xml  ..  ?>开头结尾
	2. 必须0行0列书写
	3. 只有三个属性
		1. version：指定xml版本（选1.0  不选1.1）
		2. encoding：指定当前文档的编码，默认utf-8(可省略)


### 元素Element ###
	1. 普通元素要有开始关闭标签
	2. 空元素：<a/>   自关闭
	3. 内容体的属性值必须加双引号或者单引号
	4. 只有一个根元素
	5. 区分大小写
	6. 元素名不包含xml字样

### 属性 ###
	1. 属性是元素的一部分，出现再元素开始标签中
	2. 一个元素中可以有多个属性，但是属性名不能重复
	3. 定义格式 属性名=“属性值”
	4. 属性名不能出现特殊字符，必须以字母开头

### 注释 ###
	1. 和html注释相同  <!--     -->

### 转移字符 ###
	1. 实体引用
		1. <	&lt;
		2. >	&gt;
		3. "	&quot;
		4. '	&apos;
		5. &	&amp;
	2. CDATA区
		* <![CDATA[    ]]>
		* 不能出现  ]]>  字符

## DTD约束(.dtd) ##
	1. 常见的xml约束：DTD、Schema
	2. 规定元素 名称 子元素名称及顺序 元素属性
	3. 文档类型约束（Document Type Definition）
	4. 语法（了解），通常我们使用框架提供的约束，如struts2、hibernate
	5. 引用约束
		1. 内部：SYSTEM
		2. 外部：PUBLIC
		<!DOCTYPE web-app SYSTEM "web-app_2_3.dtd">

## Schema约束(.xsd) ##
	1. dtd约束的取代者
	2. 通常我们使用框架提供的约束，如Spring
	2. 作用
		定义可出现在文档中的元素 
		定义可出现在文档中的属性 
		定义哪个元素是子元素 
		定义子元素的次序 
		定义子元素的数目 
		定义元素是否为空，或者是否可包含文本 
		定义元素和属性的数据类型 
		定义元素和属性的默认值以及固定值 
	3. 命名空间：
		1. 默认<标签名 xmlns="">
		2. 显式命名<标签名 xmlns:别名="">
		3. 实例
			1. 引用w3c官方文档
				<xsd:schema xmlns:xsd="http://www.w3.org/2001/XMLSchema"  >
				使用官方文档必须使用官方提供的<xsd:chema>标签
			2. 自定义

	4. 引用servle2.5规范约束
		<web-app xmlns="http://www.example.org/web-app_2_5" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
		xsi:schemaLocation="http://www.example.org/web-app_2_5 web-app_2_5.xsd"
		version="2.5">

## dom4j解析 ##
### xml解析方式 ###
	1. DOM	把整个装载到内存，并解析成洗个Document文档
	2. SAX	速度快，边扫描边解析
	3. PULL	安卓内置解析器，类似SAX
### xml解析器 ###
	1. dom4j:比较常用，hibernate底层使用
 
### 实例 ###
	1. 导入包dome4j-1.6.1.jar,并且add path
	2. 常用API:
		1. SaxReader对象
			* read(..)	加载执行xml文档
		2. Document对象
			* gerRootElement()	获得根元素
		3. Element对象
			* elements([..])	获得指定名称的所有子元素或第一个子元素
			* gatName(..)	获得当前元素的元素名
			* attributeValue(..)	由属性名-->属性值
			* elementText(..)		元素名称-->文本值
			* getText()			获得当前元素的文本内容
	3. 实例
		package cn.itheima.xml.dom4j;

		import java.util.List;
		
		import org.dom4j.Document;
		import org.dom4j.DocumentException;
		import org.dom4j.Element;
		import org.dom4j.io.SAXReader;
		import org.junit.Test;
		
		public class TestDom4j {
			@Test
			public void testReadWebXML() {
				try {
					// 1.获取解析器
					SAXReader saxReader = new SAXReader();
					// 2.获得document文档对象
					Document doc = saxReader.read("src/cn/itheima/xml/schema/web.xml");
					// 3.获取根元素
					Element rootElement = doc.getRootElement();
					// System.out.println(rootElement.getName());//获取根元素的名称
					// System.out.println(rootElement.attributeValue("version"));//获取根元素中的属性值
					// 4.获取根元素下的子元素
					List<Element> childElements = rootElement.elements();
					// 5.遍历子元素
					for (Element element : childElements) {
						//6.判断元素名称为servlet的元素
						if ("servlet".equals(element.getName())) {
							//7.获取servlet-name元素
							Element servletName = element.element("servlet-name");
							//8.获取servlet-class元素
							Element servletClass = element.element("servlet-class");
							System.out.println(servletName.getText());
							System.out.println(servletClass.getText());
						}
					}
		
				} catch (DocumentException e) {
					e.printStackTrace();
				}
			}
		
		}


