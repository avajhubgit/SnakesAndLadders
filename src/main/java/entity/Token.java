package entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Token {
    private @Id
    @GeneratedValue
    Long tokenId;
    private int square = 1;
    private Long userId;

    public int getSquare() {
        return square;
    }

    public void setTokenId(Long tokenId) {
        this.tokenId = tokenId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setSquare(int square) {
        this.square = square;
    }
}
