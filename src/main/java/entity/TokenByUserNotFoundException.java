package entity;

public class TokenByUserNotFoundException extends RuntimeException {
    public TokenByUserNotFoundException(Long userId) {
        super("Not found token with user ID=" + userId);
    }
}
