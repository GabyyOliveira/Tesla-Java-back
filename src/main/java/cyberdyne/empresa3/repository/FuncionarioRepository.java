package cyberdyne.empresa3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cyberdyne.empresa3.models.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer>{
 
	@Query(value = "SELECT * FROM funcionario WHERE id_cargo = :id_cargo", nativeQuery = true)
	List<Funcionario> fetchByCargo(Integer id_cargo);

	@Query( value = "SELECT id_funcionario, func_nome, func_email, func_cidade,func_foto, func_telefone, car_nome, car_atribuicao FROM cargo right JOIN funcionario ON funcionario.id_cargo = cargo.id_cargo order by func_nome", nativeQuery = true)
	List<List> funcionariosComCargo();
	
	@Query(value = "SELECT * FROM funcionario WHERE func_nome = :func_nome", nativeQuery = true)
	Funcionario fetchByName(String func_nome);
	
}