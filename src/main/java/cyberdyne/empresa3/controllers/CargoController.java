package cyberdyne.empresa3.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import cyberdyne.empresa3.models.Cargo;
import cyberdyne.empresa3.models.Supervisor;
import cyberdyne.empresa3.services.CargoService;


@CrossOrigin //EVITA ERRO DE CORS
@RestController 
@RequestMapping("empresa")
public class CargoController {
	
	@Autowired 
	private CargoService cargoService;

//-------------------------------------MÉTODOS-----------------------------------------//

	//mostrar todos os cargos
	@GetMapping("/cargo")
	public List<Cargo> mostrarCargos(){
		List<Cargo> cargo = cargoService.mostrarCargos();
		return cargo;
	}
	
	//mostrar um cargo
	@GetMapping("/cargo/{id_cargo}")
	public ResponseEntity<Cargo> buscarUmCargo(@PathVariable Integer id_cargo){
		Cargo cargo = cargoService.buscarUmCargo(id_cargo);
		return ResponseEntity.ok().body(cargo);
		
	} 
	
	@GetMapping("/cargoSemSupervisor")
	public List<Cargo> cargoSemSupervisor(){
		List<Cargo> cargo = cargoService.cargoSemSupervisor();
		return cargo;
	}
	
	@GetMapping("/cargo/cargo-supervisor/{id_supervisor}")
	public Cargo cargoDoSupervisor(@PathVariable Integer id_supervisor) {
		return cargoService.supervisorDoCargo(id_supervisor);
	}
	
	@GetMapping("/cargo/cargo-supervisor")
	public List<List> cargosComSupervisor(){
		List<List> cargoSu = cargoService.cargoComSeuSupervisor();
		return cargoSu;
	}
	
	//cadastrar cargo
	@PostMapping("/cargo")
	public ResponseEntity<Cargo> cadastrarCargo(@RequestParam(value = "supervisor", required = false)Integer id_supervisor, @RequestBody Cargo cargo ){
		cargo = cargoService.cadastrarCargo(id_supervisor, cargo);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(cargo.getId_cargo()).toUri();
		return ResponseEntity.created(uri).build();
		
	}

	//editar cargo
	@PutMapping("/cargo/{id_cargo}")
	public ResponseEntity<Void> editarCargo(@PathVariable Integer id_cargo , @RequestBody Cargo cargo){
		cargo.setId_cargo(id_cargo);
		cargo = cargoService.editarCargo(cargo);
		return ResponseEntity.noContent().build();
	}
	
	//deletar cargo
	@DeleteMapping("/cargo/{id_cargo}")
	public ResponseEntity<Cargo> deletarUmCargo(@PathVariable Integer id_cargo){
		cargoService.deletarUmCargo(id_cargo);
		return ResponseEntity.noContent().build();
	}
	

	//atribuir servico ao cargo
	@PutMapping("/cargo/definirSupervisor/{id_cargo}/{id_supervisor}")
	public ResponseEntity<Supervisor> atribuirSupervisor(@PathVariable Integer id_cargo, @PathVariable Integer id_supervisor){
		cargoService.atribuirSupervisor(id_cargo, id_supervisor);
		return ResponseEntity.noContent().build();
	}

	//deixar cargo sem servico
	@PutMapping("/cargo/tirarSupervisor/{id_cargo}/{id_supervisor}")
	public ResponseEntity<Supervisor> deixarCargoSemSupervisor(@PathVariable Integer id_cargo, @PathVariable Integer id_supervisor){
		cargoService.deixarCargoSemServico(id_cargo, id_supervisor);
		return ResponseEntity.noContent().build();
	}
}
