package mvc_security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mvc_security.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, long> {

	Cliente findByEmail(String email);

}