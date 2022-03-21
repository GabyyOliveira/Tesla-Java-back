package cyberdyne.empresa3.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cyberdyne.empresa3.models.Supervisor;

public interface SupervisorRepository extends JpaRepository<Supervisor, Integer>{
    
//    @Query(value = "SELECT * FROM servico WHERE id_cargo = :id_cargo", nativeQuery = true)
//    Supervisor fetchByCargo(Integer id_cargo);
//
//    @Query(value = "SELECT * FROM servico WHERE id_cargo is null", nativeQuery = true)
//    List<Supervisor> cargoSemServico();
//
//    @Query(value = "SELECT id_servico, serv_nome, serv_objetivos, serv_periodo, id_cargo, car_nome, car_atribuicao FROM cargo right JOIN servico ON servico.id_cargo = cargo.id_cargo order by servico.serv_nome", nativeQuery = true)
//    List<List> cargoComServico();
//
//    @Query(value = "SELECT * FROM servico WHERE id_cargo is not null", nativeQuery = true)
//    List<Supervisor> cargoComoServico();
//    @Query(value = "SELECT * FROM servico WHERE serv_nome = :serv-nome", nativeQuery = true)
//    Servico fetchByName(String serv_nome);
	
	@Query(value = "SELECT * FROM supervisor WHERE id_cargo = :id_cargo", nativeQuery = true)
	Supervisor fetchByCargo(Integer id_cargo);
	
	@Query(value = "SELECT * FROM supervisor WHERE supervisor_nome = :supervisor_nome", nativeQuery = true)
	Supervisor fetchByName(String supervisor_nome);
	
	@Query(value = "SELECT * FROM supervisor WHERE id_cargo is null", nativeQuery = true)
	List<Supervisor> supervisorSemCargo();
	
	@Query(value = "SELECT supervisor.id_supervisor, supervisor.su_nome, supervisor.su_email, cargo.id_cargo, cargo.car_nome, cargo.car_atribuicao FROM cargo right JOIN supervisor ON supervisor.id_cargo = cargo.id_cargo order by supervisor.su_nome", nativeQuery = true)
	List<List> supervisorComSeuCargo();

}
  