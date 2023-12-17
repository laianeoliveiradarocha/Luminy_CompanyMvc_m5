package mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mvc.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, long> {

}