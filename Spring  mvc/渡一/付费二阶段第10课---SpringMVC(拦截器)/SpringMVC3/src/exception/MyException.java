package exception;

/**
 * 他是一个普通自定义异常
 */
public class MyException extends RuntimeException {

    private String message;

    public MyException(){}
    public MyException(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
