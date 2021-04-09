package entity;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface TokenRepository extends JpaRepository<Token, Long> {
}
