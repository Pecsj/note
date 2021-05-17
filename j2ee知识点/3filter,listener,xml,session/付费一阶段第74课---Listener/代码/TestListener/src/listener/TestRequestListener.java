package listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class TestRequestListener implements ServletRequestListener, ServletRequestAttributeListener {

    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("request对象销毁啦");
    }

    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("request对象创建啦");
    }

    //-------------------------------------------------------------

    public void attributeAdded(ServletRequestAttributeEvent srae) {
        System.out.println("request添加了数据");
    }

    public void attributeRemoved(ServletRequestAttributeEvent srae) {
        System.out.println("request删除了数据");
    }

    public void attributeReplaced(ServletRequestAttributeEvent srae) {
        System.out.println("request修改了数据");
    }

}
