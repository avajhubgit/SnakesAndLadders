package entity;

public class TokenManager {
    int square = 1;

    public int getSquare() {
        return square;
    }

    public void move(int number) {
        if (square + number <= 100) {
            square += number;
        }
    }

    public boolean isWinner() {
        return (square == 100);
    }
}
