package testinterface;

public class ImplB implements TestInterface {
    @Override
    public void interfaceMethod() {
        System.out.println("子类B 实现的方法");
    }
}
