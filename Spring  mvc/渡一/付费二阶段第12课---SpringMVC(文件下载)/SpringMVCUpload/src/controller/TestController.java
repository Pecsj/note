package controller;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

@Controller
public class TestController {

    @RequestMapping("test.do")
    public String test(){
        System.out.println("test好用啦");
        return "welcome.jsp";
    }

    //原生方式处理文件的上传
//    @RequestMapping("upload.do")
//    public String upload(HttpServletRequest request) throws Exception {
//        //获取磁盘文件选项的factory
//        DiskFileItemFactory factory = new DiskFileItemFactory();
//        //创建一个ServletFileUpload对象
//        ServletFileUpload upload = new ServletFileUpload(factory);
//        //让upload对象帮我们去解析request(目的获取数据)
//        List<FileItem> itemList = upload.parseRequest(request);
//        //遍历所有的文件项
//        for(FileItem item : itemList){
//            //每次循环判断一下当前item是文件还是普通表单对象
//            if(item.isFormField()){//普通表单数据
//                String key = item.getFieldName();
//                String value = item.getString("UTF-8");
//                System.out.println(key+"--"+value);
//            }else{//文件数据
//                String fileName = item.getName();//名字可以自己弄一个规则 确保文件名唯一  UUID
//                item.write(new File("D://test//",fileName));
//            }
//        }
//        return "welcome.jsp";
//    }

    //文件上传的时候需要一个临时存储
    //factory.setSizeThreshold(1024000);//设置缓存大小
    //factory.setRepository(new File("路径"));

    //基于SpringMVC方式的文件上传
    @RequestMapping("upload.do")
    public String upload(String text, MultipartFile upload) throws IOException {
        System.out.println("新的controller执行啦");
        System.out.println(text);
        //文件名字
        String fileName = upload.getOriginalFilename();
        //文件对象
        //upload对象帮我们做传输
        upload.transferTo(new File("D://test//",fileName));
        return "welcome.jsp";
    }

    //=================================================================================

    //原生方式
//    @RequestMapping("download.do")
//    public void download(HttpServletRequest request,HttpServletResponse response) throws Exception {
//        //1.获取请求传递过来的文件名
//        String fileName = request.getParameter("fileName");
//        //2.直接创建文件输入流读取文件
//        InputStream inputStream = new FileInputStream("D://test//"+fileName);
//        //3.做响应啦----设置
//        //  如果服务端存储的文件名字含有中文，需要处理一下
//        fileName = URLEncoder.encode(fileName,"UTF-8");
//        //  响应信息头
//        response.setContentType("application/x-msdownload");
//        response.setHeader("Content-disposition","attachment;filename="+fileName);
//        //4.正式开始写数据(输出流)
//        OutputStream outputStream = response.getOutputStream();
//        byte[] b = new byte[1024];
//        int length = inputStream.read(b);//读取有效字节个数
//        while(length!=-1){
//            outputStream.write(b,0,length);
//            outputStream.flush();
//            length = inputStream.read(b);
//        }
//    }


    //基于SpringMVC方式实现下载
    @RequestMapping("download.do")
    public ResponseEntity<byte[]> download(String fileName) throws Exception {//fileName变量 名字是框架帮我们注入进去的  帮我们组合成了String
        //获取读取文件即可
        File file = new File("D://test//"+fileName);
        //设置响应信息相关
        //  如果有中文 需要处理
        fileName = new String(fileName.getBytes("UTF-8"),"ISO-8859-1");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment",fileName);
        //将响应信息存入一个返回值对象内即可----ResponseEntity
        byte[] b = FileUtils.readFileToByteArray(file);
        return new ResponseEntity(b,headers,HttpStatus.CREATED);
    }

}
