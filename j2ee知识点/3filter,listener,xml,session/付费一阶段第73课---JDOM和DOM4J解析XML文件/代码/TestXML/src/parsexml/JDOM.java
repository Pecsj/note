package parsexml;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import java.io.File;
import java.util.List;

public class JDOM {

    public static void main(String[] args){
        try {
            System.out.println("以JDOM形式进行解析 需要一个jdom.jar外部包");
            //获取builder对象   自己创建
            SAXBuilder builder = new SAXBuilder();
            File file = new File("src/testxml/school.xml");
            //工人创建document对象
            Document document = builder.build(file);

            //读取school.xml中的根标记  school
            Element school = document.getRootElement();
            //获取school标签中的属性
            String schoolID = school.getAttributeValue("id");
            String schoolName = school.getAttributeValue("name");
            String schoolLOC = school.getAttributeValue("loc");
            System.out.println(schoolID+"--"+schoolName+"--"+schoolLOC);
            //获取school标记的子元素 好几个class
            List<Element> classList = school.getChildren("class");
            for(Element classEle : classList){
                //获取classEle中的属性
                String classID = classEle.getAttributeValue("id");
                String className = classEle.getAttributeValue("name");
                String classLOC = classEle.getAttributeValue("loc");
                System.out.println("\t"+classID+"--"+className+"--"+classLOC);
                //获取class中的子元素 teacher
                Element teacher = classEle.getChild("teacher");
                String teacherID = teacher.getAttributeValue("id");
                String teacherName = teacher.getAttributeValue("name");
                String teacherAge = teacher.getAttributeValue("age");
                Element teacherSexEle = teacher.getChild("sex");
                String teacherSex = teacherSexEle.getText();
                System.out.println("\t\t"+teacherID+"--"+teacherName+"--"+teacherAge+"--"+teacherSex);
                //获取class中的子元素 好多student
                List<Element> studentList = classEle.getChildren("student");
                for(Element student : studentList){
                    String studentID = student.getAttributeValue("id");
                    String studentName = student.getAttributeValue("name");
                    String studentAge = student.getAttributeValue("age");
                    String studentSex = student.getChildText("sex");
                    System.out.println("\t\t"+studentID+"--"+studentName+"--"+studentAge+"--"+studentSex);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
