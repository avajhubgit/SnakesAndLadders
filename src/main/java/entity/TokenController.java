package entity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tokens")
public class TokenController {
    private final TokenRepository tokenRepository;
    private TokenManager tokenManager;

    public TokenController(TokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
        tokenManager = new TokenManager();
    }

    @PostMapping("")
    public Token newToken(@RequestBody Token token) {
        //set square for new token equal 1
        token.setSquare(1);

        return tokenRepository.save(token);
    }

    //a lot of tokens
    @GetMapping("")
    public List<Token> all() {
        return tokenRepository.findAll();
    }

    //single token
    @GetMapping("/{id}")
    public Token getToken(@PathVariable Long id) {
        return tokenRepository.findById(id)
                .orElseThrow(() -> new TokenNotFoundException(id));
    }

    //token by user
    @GetMapping("/{user_id}")
    public Token getTokenByUser(@PathVariable Long userId) {
        return tokenRepository.findAll().stream()
                .filter(x -> x.getUserId().equals(userId))
                .findAny().orElseThrow(() -> new TokenByUserNotFoundException(userId));
    }

    @PutMapping("/{id}")
    public Token replaceToken(@RequestBody Token token, @PathVariable Long id) {
        return tokenRepository.findById(id)
                .map(tok -> {
                    tok.setSquare(token.getSquare());
                    tok.setUserId(token.getUserId());
                    return tokenRepository.save(tok);
                })
                .orElseGet(() -> {
                    token.setTokenId(id);
                    return tokenRepository.save(token);
                });
    }

    @DeleteMapping("/{id}")
    public void deleteToken(@PathVariable Long id) {
        tokenRepository.deleteById(id);
    }
}