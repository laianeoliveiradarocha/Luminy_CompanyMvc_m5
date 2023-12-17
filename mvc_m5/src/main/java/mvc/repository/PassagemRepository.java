package mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mvc.model.Passagem;

public interface PassagemRepository extends JpaRepository<Passagem, long> {

}