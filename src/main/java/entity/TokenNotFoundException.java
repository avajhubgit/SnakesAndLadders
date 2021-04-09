package entity;

public class TokenNotFoundException extends RuntimeException {
    public TokenNotFoundException(Long id) {
        super("Not found token with ID=" + id);
    }
}
