package parsexml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

@SuppressWarnings("all")
public class DOM {

    public static void main(String[] args){
        try {
            System.out.println("原生JavaAPI中提供的方式 不用导包");
            //采用DOM方式   Document Object Model
            //1.需要一个工厂(建造工人)
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            //2.利用工厂创建工人
            DocumentBuilder builder = factory.newDocumentBuilder();
            //3.工人创建一个document对象(需要一张图纸 xml文件)
            File file = new File("src/testxml/school.xml");
            //InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("testxml/school.xml");
            Document document = builder.parse(file);

            //4.解析xml文件
            //获取根标签对象(school)
            //方式一
            Element school = document.getDocumentElement();
            //方式二
//            Element school = document.getElementById("duyi");//需要有dtd规则
            //方式三
//            NodeList RootList = document.getElementsByTagName("school");
//            Element school = RootList.item(0);//   list.get(0);
            //school标签中的属性
            String schoolID = school.getAttribute("id");
            String schoolName = school.getAttribute("name");
            String schoolLOC = school.getAttribute("loc");
            System.out.println(schoolID+"--"+schoolName+"--"+schoolLOC);
            //school标签中的子标签
            //方式一
//            NodeList classList = document.getElementsByTagName("class");
            //方式二
            NodeList classList = school.getElementsByTagName("class");
            //方式三
//            NodeList classList = school.getChildNodes();//需要有dtd规则
            for(int i=0;i<classList.getLength();i++){
                //某一个class标签
                Element classEle = (Element)classList.item(i);
                String classID = classEle.getAttribute("id");
                String className = classEle.getAttribute("name");
                String classLOC = classEle.getAttribute("loc");
                System.out.println("\t"+classID+"--"+className+"--"+classLOC);
                //class标签的子标签teacher
                //方式一
                Element teacher = (Element)classEle.getElementsByTagName("teacher").item(0);
                //方式二
//                Element teacher = (Element)classEle.getFirstChild();//需要有dtd规则
                String teacherID = teacher.getAttribute("id");
                String teacherName = teacher.getAttribute("name");
                String teacherAge = teacher.getAttribute("age");
                Element teacherSexEle = (Element)teacher.getElementsByTagName("sex").item(0);
                String teacherSex = teacherSexEle.getTextContent();
                System.out.println("\t\t"+teacherID+"--"+teacherName+"--"+teacherAge+"--"+teacherSex);

                //class标签中的子标签student
                NodeList studentList = classEle.getElementsByTagName("student");
                for(int j=0;j<studentList.getLength();j++){
                    Element student = (Element)studentList.item(j);
                    String studentID = student.getAttribute("id");
                    String studentName = student.getAttribute("name");
                    String studentAge = student.getAttribute("age");
                    Element sex = (Element)student.getElementsByTagName("sex").item(0);
                    String studentSex = sex.getTextContent();//获取标签中的文本内容<>xxx</>
                    System.out.println("\t\t"+studentID+"--"+studentName+"--"+studentAge+"--"+studentSex);
                }
            }

            //document对象还能写入
//            Element newElement = document.createElement("class");
//            //<class></class>
//            newElement.setAttribute("id","three");
//            newElement.appendChild(newElement);
      } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
