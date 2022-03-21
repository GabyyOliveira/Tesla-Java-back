package cyberdyne.empresa3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cyberdyne.empresa3.models.Cargo;

public interface CargoRepository extends JpaRepository<Cargo, Integer> {

    @Query(value = "SELECT * FROM cargo WHERE id_supervisor is null", nativeQuery = true)
	List<Cargo> CargoSemSupervisor();

    @Query(value = "SELECT * FROM cargo WHERE id_supervisor = :id_supervisor", nativeQuery = true)
    Cargo supervisorDoCargo(Integer id_supervisor);

    @Query(value ="SELECT cargo.id_cargo, cargo.car_nome, cargo.car_atribuicao, supervisor.id_supervisor, supervisor.su_nome, supervisor.su_email FROM cargo left JOIN supervisor ON supervisor.id_cargo = cargo.id_cargo order by cargo.car_nome;", nativeQuery = true)
    List<List> cargoComOSupervisor();
    
    
}
  