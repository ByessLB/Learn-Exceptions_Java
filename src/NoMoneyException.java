
public class NoMoneyException extends Exception {

    private static final long serialVersionUID = 1L;

    public NoMoneyException() {
        super("Attention : La balance ne peut pas être négative.");
    }
}
