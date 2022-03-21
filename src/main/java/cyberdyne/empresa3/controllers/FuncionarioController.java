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
import cyberdyne.empresa3.models.Funcionario;
import cyberdyne.empresa3.services.FuncionarioService;


//ESTA ANOTAÇÃO JA TIRA TODOS NOSSO PROBLEMAS COM CORS, MESMO PROBLEMA QUE DANA NO ANGULAR
@CrossOrigin
//DENTRO DA CALSSE CONTROLLER IREMOS COLOCAR TODOS OS MÉTODOS DE CONTROLE
@RestController
//NO JAVA NÓ NÃO CHAMAMOS AS ROTAS COMO ROTAS, MAS COMO ENDPOINT
@RequestMapping("empresa")
public class FuncionarioController {
	
	//PRECISAMOS DA INJEÇÃO DE DEPENDENCIAS
	
	@Autowired
	private FuncionarioService funcionarioService;
	
//-----------------------------------------MÉTODOS--------------------------------------//
	//mostrar todos funcionarios
	@GetMapping("/funcionario")
	public List<Funcionario> mostrarTodosFuncionarios(){
		List<Funcionario> funcionario = funcionarioService.mostrarTodosFunc();
		return funcionario;
	}

	//mostrar funcionarios com cargo
	@GetMapping("/funcionario-cargo")
	public List<List> funcsComCargo(){
		List<List> funcCargo = funcionarioService.funcionariosComCargo();
		return funcCargo;
	}

	//mostrar um funcionario	
	@GetMapping("/funcionario/{id_funcionario}")
	public ResponseEntity<?> buscarUmFunc(@PathVariable Integer id_funcionario){
		Funcionario funcionario = funcionarioService.buscarUmfunc(id_funcionario);
		return ResponseEntity.ok().body(funcionario);
	}

	//buscar funcionario do cargo
	@GetMapping("/funcionario/busca-cargo/{id_cargo}")
	public List<Funcionario> buscarFuncCargo(@PathVariable Integer id_cargo){
		List<Funcionario> funcionario = funcionarioService.buscarFuncCargo(id_cargo);
		return funcionario;
	}
	
	@GetMapping("/funcionario-nome/{func_nome}")
	public ResponseEntity<Funcionario> buscarFuncPeloNome(@PathVariable String func_nome){
		Funcionario funcionario = funcionarioService.buscarFuncPeloNome(func_nome);
		return ResponseEntity.ok().body(funcionario);
	}
	
//	//mostra funcionario de determinado cargo
//	@GetMapping("/funcionario/busca-cargo/{id_cargo}")
//	public List<Funcionario> buscaFuncCargo(@PathVariable Integer id_cargo){
//		List<Funcionario> funcionario = funcionarioService.buscarFuncCargo(id_cargo);
//		return funcionario;
//	}
			
	//cadastrar funcionario	
	@PostMapping("/funcionario")
	public ResponseEntity<Funcionario> inserirFunc(@RequestParam(value = "cargo") Integer id_cargo, @RequestBody Funcionario funcionario){
		funcionario = funcionarioService.inserirFunc( id_cargo, funcionario);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/funcionario/{id}")
					.buildAndExpand(funcionario.getId_funcionario()).toUri();
		return ResponseEntity.created(uri).build();
		 
	}
	
	//deletar funcionario
	@DeleteMapping("/funcionario/{id_funcionario}")
	public ResponseEntity<Void> deletarUmFunc(@PathVariable Integer id_funcionario){
		funcionarioService.deletarFunc(id_funcionario);
		return ResponseEntity.noContent().build();
	}
		
	//inserir funcionario no cargo
	@PutMapping("/funcionario/inserirCargo/{id_funcionario}")
	public ResponseEntity<Funcionario> inserirFuncNoCargo(@PathVariable Integer id_funcionario, @RequestBody Cargo cargo ){
		Funcionario funcionario = funcionarioService.inserirFuncNoCargo(id_funcionario, cargo);
		return ResponseEntity.noContent().build();
	}

	//editar funcionario
	@PutMapping("/funcionario/{id_funcionario}")
	public ResponseEntity<Void> editarFunc( @RequestParam(value = "cargo")Cargo cargo, @PathVariable Integer id_funcionario,@RequestBody Funcionario funcionario){
		funcionario.setId_funcionario(id_funcionario);
		funcionario.setCargo(cargo);
		funcionario = funcionarioService.editarFunc(funcionario);
		return ResponseEntity.noContent().build();
	}

	
	

}
