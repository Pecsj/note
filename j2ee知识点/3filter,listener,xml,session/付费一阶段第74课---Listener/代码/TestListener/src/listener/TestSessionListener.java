package listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class TestSessionListener implements HttpSessionListener, HttpSessionAttributeListener {

    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("session对象创建啦");
    }
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("session对象销毁啦");
    }
    //----------------------------------------------------
    public void attributeAdded(HttpSessionBindingEvent se) {
        System.out.println("session存储了值");
    }
    public void attributeRemoved(HttpSessionBindingEvent se) {
        System.out.println("session删除了值");
    }
    public void attributeReplaced(HttpSessionBindingEvent se) {
        System.out.println("session修改了值");
    }
}
