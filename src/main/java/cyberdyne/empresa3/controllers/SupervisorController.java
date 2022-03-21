package cyberdyne.empresa3.controllers;

//
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
import cyberdyne.empresa3.services.SupervisorService;



@CrossOrigin
@RestController
@RequestMapping("empresa") 
public class SupervisorController {
//    
//    @Autowired
//    private ServicoService servService;
//
//    @GetMapping("/servicos")
//    public List<Servico> mostrarTodosServs(){
//        List<Servico> servico = servService.mostrarTodosServs();
//        return servico;
//    }
//
//    @GetMapping("/servico/{id_servico}")
//    public ResponseEntity<Servico> mostrarUmServ(@PathVariable Integer id_servico){
//        Servico servico = servService.mostrarUmServico(id_servico);
//        return ResponseEntity.ok().body(servico);
//    }
//
//    @GetMapping("/servico-cargo/{id_cargo}")
//    public ResponseEntity<Servico> buscarServicoDoCargo(@PathVariable Integer id_cargo){
//        Servico servico = servService.buscarCargoDoServico(id_cargo);
//        return ResponseEntity.ok().body(servico);
//    }

//    @GetMapping("/servico-nome/{serv_nome}")
//    public ResponseEntity<Servico> buscarServicoPeloNome(@PathVariable String serv_nome){
//        Servico servico = servService.buscarServicoPeloNome(serv_nome);
//        return ResponseEntity.ok().body(servico);
//    }

//    @GetMapping("/cargoSemServico")
//    public List<Servico> cargoSemServico(){
//        List<Servico> servico = servService.cargoSemServico();
//        return servico;
//    }
//    
//    @GetMapping("/cargoComServico")
//    public List<Servico> cargoComoServico(){
//        List<Servico> servico = servService.cargoComoServico();
//        return servico;
//    }
//
//    public List<List> cargosComServicos(){
//        List<List> cargoServico = servService.cargoComServico();
//        return cargoServico;
//    }


//    @PostMapping("/servico")
//    public ResponseEntity<Servico> inserirServico(@RequestParam(value = "cargo", required = false) Integer id_cargo, @RequestBody Servico servico){
//        servico = servService.inserirServico(id_cargo, servico);
//        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
//				.buildAndExpand(servico.getId_servico()).toUri();
//		
//		return ResponseEntity.created(uri).build();	
//    }
//
//    @PutMapping("/servico/{id_servico}")
//    public ResponseEntity<Servico> editarServico(@RequestParam(value = "cargo", required = false) Cargo cargo, @PathVariable Integer id_servico, @RequestBody Servico servico ){
//        servico.setId_servico(id_servico);
//        servico.setCargo(cargo);
//        cargo.setServico(servico);
//        servico = servService.editarServico(servico);
//        
//        return ResponseEntity.noContent().build();
//    }
	@Autowired
	private SupervisorService suService;
	
	@GetMapping("/supervisor")
	public List<Supervisor> mostrarTodosSupervisores(){
		List<Supervisor> supervisor = suService.mostrarTodosSupervisores();
		return  supervisor;
	}
	
	@GetMapping("/supervisor/{id_supervisor}")
	public ResponseEntity<Supervisor> mostrarUmSupervisor(@PathVariable Integer id_supervisor) {
		Supervisor supervisor = suService.mostrarUmSupervisor(id_supervisor);
		return ResponseEntity.ok().body(supervisor);
	}
	
	@GetMapping("/supevisor-cargo/{id_cargo}")
	public ResponseEntity<Supervisor> buscarSuperisorDoCargo(@PathVariable Integer id_cargo){
		Supervisor supervisor = suService.buscarSupervisorDoCargo(id_cargo);
		return ResponseEntity.ok().body(supervisor);
	}

	@GetMapping("/supervisor-nome/{su_nome}")
	public ResponseEntity<Supervisor> buscarSupervisorPeloNome(@PathVariable String su_nome){
		Supervisor supervisor = suService.buscarSupervisorPeloNome(su_nome);
		return ResponseEntity.ok().body(supervisor);
	}
	@GetMapping("/supervisorSemCargo")
	public List<Supervisor> supervisorSemCargo(){
		List<Supervisor> supervisor = suService.supervisorSemCargo();
		return supervisor;
	}
	
	@GetMapping("/supervisor-cargo")
	public List<List> SupervisorComOCargo(){
		List<List> supervisorCargo = suService.supervisorComSeuCargo();
		return supervisorCargo;
	}
	@PostMapping("/supervisor")
	public ResponseEntity<Supervisor> InserirSupervisor(@RequestParam(value="cargo", required = false)Integer id_cargo,@RequestBody Supervisor supervisor){
		supervisor = suService.InserirSupervisor(id_cargo, supervisor);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(supervisor.getId_supervisor()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping("/supervisor/{id_supervisor}")
	public ResponseEntity<Void> supervisorComCargo(@RequestParam(value = "cargo")Cargo cargo,@PathVariable Integer id_supervisor, @RequestBody Supervisor supervisor){
		supervisor.setId_supervisor(id_supervisor);
		supervisor.setCargo(cargo);
		supervisor = suService.editarSupervisor(supervisor);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/supervisorSemCargo/{id_supervisor}")
	public ResponseEntity<Void> editarSupervisor(@PathVariable Integer id_supervisor, @RequestBody Supervisor supervisor){
		supervisor.setId_supervisor(id_supervisor);
		supervisor = suService.editarSupervisor(supervisor);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/supervisor/{id_supervisor}")
	public ResponseEntity<Void> excluirSupervisor(@PathVariable Integer id_supervisor){
		suService.excluirSupervisor(id_supervisor);
		return ResponseEntity.noContent().build();
	}
}
