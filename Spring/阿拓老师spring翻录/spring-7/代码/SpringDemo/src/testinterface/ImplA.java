package testinterface;

public class ImplA implements TestInterface {
    @Override
    public void interfaceMethod() {
        System.out.println("子类A 实现的方法");
    }
}
