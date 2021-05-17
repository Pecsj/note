package testinterface;

/**
 *      跟spring的bean工厂要当前TestService类的对象
 *      TestService ts = (TestService)f.getBean("testService");
 *      想要在过程中让ts对象中的属性进行自动DI
 *      属性可以通过构造方法、set方法进行装配(手动ref指定  自动autowire)
 *      如果这个属性是一个抽象类或接口形式 装配一定不是当前属性类型 是当前属性的子类类型
 *      子类类型可能不止一个 看一看装配时会产生什么样的问题
 */
public class TestService {//外部bean

    //属性
    private TestInterface ti;

    //方式一 带参数构造方法方式
    public TestService(TestInterface ti) {
        System.out.println("带参数构造方法给接口属性赋值");
        this.ti = ti;
    }
    //方式二 无参数构造方法+set方法
    public TestService() {
        System.out.println("无参数构造方法");
    }
    public void setTi(TestInterface ti) {
        System.out.println("set方法给接口属性赋值");
        this.ti = ti;
    }


    public TestInterface getTi() {
        return ti;
    }
}
