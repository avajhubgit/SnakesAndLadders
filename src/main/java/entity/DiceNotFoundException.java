package entity;

public class DiceNotFoundException extends RuntimeException {
    public DiceNotFoundException(Long id) {
        super("Not found departmen with ID=" + id);
    }
}
