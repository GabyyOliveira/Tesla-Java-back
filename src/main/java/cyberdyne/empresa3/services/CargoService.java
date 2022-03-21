package cyberdyne.empresa3.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
 
import cyberdyne.empresa3.models.Cargo;
import cyberdyne.empresa3.models.Supervisor;
import cyberdyne.empresa3.repository.CargoRepository;
import cyberdyne.empresa3.services.exceptions.ObjectNotFoundException;

@Service
public class CargoService {
	
	@Autowired
	private CargoRepository cargoRepository;

	@Lazy
	@Autowired
	private SupervisorService servService;

	
//-------------------------------------MÉTODOS-------------------------------------------//
	//MÉTODO LISTAR TODO CARGOS
	public List<Cargo> mostrarCargos(){
		return cargoRepository.findAll();
	}
	
	//MÉTODO LISTAR UM CARGO
	public Cargo buscarUmCargo(Integer id_cargo) {
		Optional<Cargo> cargo = cargoRepository.findById(id_cargo);
		return cargo.orElseThrow(() -> new ObjectNotFoundException("Cargo não encontrado " + id_cargo));
	}
	
	//cadastrar cargo
	public Cargo cadastrarCargo(Integer id_supervisor, Cargo cargo) {
		cargo.setId_cargo(null);
		if(id_supervisor != null) {
			Supervisor supervisor = servService.mostrarUmSupervisor(id_supervisor);
			cargo.setSupervisor(supervisor);
		}
		return cargoRepository.save(cargo);
	}

	//mostrar cargos sem servico
	public List<Cargo> cargoSemSupervisor(){
		return cargoRepository.CargoSemSupervisor();
	}
	

	//mostrar cargo de determinado servico
	public Cargo supervisorDoCargo(Integer id_supervisor){
		Cargo cargo = cargoRepository.supervisorDoCargo(id_supervisor);
		return cargo;
	}

	//mostrar cargo com o servico
	public List<List> cargoComSeuSupervisor(){
		return cargoRepository.cargoComOSupervisor();
	}
	
	//editar cargo
	public Cargo editarCargo(Cargo cargo) {
		buscarUmCargo(cargo.getId_cargo());
		return cargoRepository.save(cargo);
	}
	
	//deletar cargo
	public void deletarUmCargo(Integer id_cargo) {
		buscarUmCargo(id_cargo);
		try {
			cargoRepository.deleteById(id_cargo);
		}catch (org.springframework.dao.DataIntegrityViolationException e) {
			throw new cyberdyne.empresa3.services.exceptions.DataIntegrityViolationException("Cargo não pode ser excluido pois há funcionarios relacionados");
		}
	}

	//atribuir servico ao cargo
	public Cargo atribuirSupervisor(Integer id_cargo, Integer id_supervisor){
		Cargo cargo = buscarUmCargo(id_cargo);
		Supervisor suAnterior = servService.buscarSupervisorDoCargo(id_cargo);
		Supervisor supervisor = servService.mostrarUmSupervisor(id_supervisor);
		if(cargo.getSupervisor() != null){
			cargo.setSupervisor(null);
			suAnterior.setCargo(null);
		}
		cargo.setSupervisor(supervisor);
		supervisor.setCargo(cargo);
		return cargoRepository.save(cargo);
	}

	//deixar cargo sem servico
	public Cargo deixarCargoSemServico(Integer id_cargo, Integer id_supervisor){
		Cargo cargo = buscarUmCargo(id_cargo);
		cargo.setSupervisor(null);
		Supervisor supervisor = servService.mostrarUmSupervisor(id_supervisor);
		supervisor.setCargo(null);
		return cargoRepository.save(cargo);
	}
}
