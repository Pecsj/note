package listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class TestRequestListener implements ServletRequestListener {

    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("request对象销毁啦");
    }

    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("request对象创建啦");

    }

}
