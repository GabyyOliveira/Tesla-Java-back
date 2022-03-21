package cyberdyne.empresa3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cyberdyne.empresa3.models.Bonificacao;

public interface BonificacaoRepository extends JpaRepository<Bonificacao, Integer>{

	@Query(value = "SELECT * FROM db_tesla.bonificacao WHERE id_funcionario = :id_funcionario", nativeQuery = true)
	List<Bonificacao> buscarBonificacaoDoFuncionario(Integer id_funcionario);
	
}
