package parsexml;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

public class DOM4J {

    public static void main(String[] args){
        try {
            System.out.println("利用DOM4J形式解析 需要以来外部dom4j.jar");
            //创建一个解析对象
            SAXReader reader = new SAXReader();//理解为是之前的builder对象
            //提供一个文件
            File file = new File("src/testxml/school.xml");
            //让解析对象读取file并产生一个document对象
            Document document = reader.read(file);

            //获取根元素
            Element school = document.getRootElement();
            //获取school中的属性
            String schoolID = school.attributeValue("id");
            String schoolName = school.attributeValue("name");
            String schoolLOC = school.attributeValue("loc");
            System.out.println(schoolID+"--"+schoolName+"--"+schoolLOC);

            //获取school中的子元素 class
            List<Element> classList = school.elements("class");
            for(Element classEle : classList){
                //获取class中的属性
                String classID = classEle.attributeValue("id");
                String className = classEle.attributeValue("name");
                String classLOC = classEle.attributeValue("loc");
                System.out.println("\t"+classID+"--"+className+"--"+classLOC);
                //获取class中的子元素(一个teacher)
                Element teacher = classEle.element("teacher");
                String teacherID = teacher.attributeValue("id");
                String teacherName = teacher.attributeValue("name");
                String teacherAge = teacher.attributeValue("age");
                Element teacherSexEle = teacher.element("sex");
                String teacherSex = teacherSexEle.getText();
                System.out.println("\t\t"+teacherID+"--"+teacherName+"--"+teacherAge+"--"+teacherSex);
                //获取class中的子元素(好多student)
                List<Element> studentList = classEle.elements("student");
                for(Element student : studentList){
                    String studentID = student.attributeValue("id");
                    String studentName = student.attributeValue("name");
                    String studentAge = student.attributeValue("age");
                    String studentSex = student.elementText("sex");
                    System.out.println("\t\t"+studentID+"--"+studentName+"--"+studentAge+"--"+studentSex);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
