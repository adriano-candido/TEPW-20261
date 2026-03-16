package br.edu.christus.backend.repository;

import br.edu.christus.backend.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends
        JpaRepository<User, Long> {
}
