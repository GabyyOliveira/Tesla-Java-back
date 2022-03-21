package cyberdyne.empresa3.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import cyberdyne.empresa3.models.Cargo;

import cyberdyne.empresa3.models.Funcionario;
import cyberdyne.empresa3.repository.FuncionarioRepository;
import cyberdyne.empresa3.services.exceptions.ObjectNotFoundException;


@Service
public class FuncionarioService {
	
	@Autowired
	private CargoService cargoService;

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	
//------------------------------------------MÉTODOS----------------------------------//
	//mostrar todos funcionarios
	public List<Funcionario> mostrarTodosFunc(){
		return funcionarioRepository.findAll();
	}

	//mostrar funcionarios com servico
	public List<List> funcionariosComCargo(){
		return funcionarioRepository.funcionariosComCargo();
	}
	
	//mostrar um funcionario
	public Funcionario buscarUmfunc(Integer id_funcionario) {
		Optional<Funcionario> funcionario = funcionarioRepository.findById(id_funcionario);
		return funcionario.orElseThrow();
	}

	//mostrar funcionario do cargo
	public List<Funcionario> buscarFuncCargo(Integer id_cargo){
		List<Funcionario> funcionario = funcionarioRepository.fetchByCargo(id_cargo);
		return funcionario;
	}
	
	public Funcionario buscarFuncPeloNome(String func_nome) {
		Funcionario funcionario = funcionarioRepository.fetchByName(func_nome);
		return funcionario;
	}
	
	//cadastrar funcionario no cargo
	public Funcionario inserirFuncNoCargo(Integer id_funcionario, Cargo cargo) {
		Funcionario funcionario = buscarUmfunc(id_funcionario);
		funcionario.setCargo(cargo);
		return funcionarioRepository.save(funcionario);
	}

	//cadastrar funcionario
	public Funcionario inserirFunc(Integer id_cargo, Funcionario funcionario){
		funcionario.setId_funcionario(null);
		Cargo cargo = cargoService.buscarUmCargo(id_cargo);
		funcionario.setCargo(cargo);
		return funcionarioRepository.save(funcionario);
	}

	//deletar funcionario
	public void deletarFunc(Integer id_funcionario) {
		funcionarioRepository.deleteById(id_funcionario);
	}

	//editar funcionario
	public Funcionario editarFunc(Funcionario funcionario) {
		buscarUmfunc(funcionario.getId_funcionario());
		return funcionarioRepository.save(funcionario);
	}

	//salvar foto
	public Funcionario salvarFoto(Integer id_funcionario, String caminhoFoto){
		Funcionario funcionario = buscarUmfunc(id_funcionario);
		funcionario.setFunc_foto(caminhoFoto);
		return funcionarioRepository.save(funcionario);
	}
}
