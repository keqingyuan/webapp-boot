package exception;

/**
 * Created by qingyuan on 2018/10/23.
 */
public class BussicessException extends RuntimeException {

    private static final long serialVersionUID = -8627838232253690816L;

    public BussicessException(String code) {
        super(code);
    }

}
