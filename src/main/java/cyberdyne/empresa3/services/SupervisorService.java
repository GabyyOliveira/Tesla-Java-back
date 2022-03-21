package cyberdyne.empresa3.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.context.annotation.Lazy;

import cyberdyne.empresa3.models.Cargo;
import cyberdyne.empresa3.models.Supervisor;
import cyberdyne.empresa3.repository.SupervisorRepository;

@Service
public class SupervisorService {


////-------------------------------- INJEÇÃO DE DEPENDENCIAS -----------------------------//
//    @Autowired
//    private SupervisorRepository servRepository;
//
//    @Lazy
//    @Autowired
//    private CargoService cargoService;
//
////------------------------------------------MÉTODOS------------------------------------//
//
//    //mostrar todos os servicos
//    public List<Supervisor> mostrarTodosServs(){
//        return servRepository.findAll();
//    }
//
//    //mostrar um servico
//    public Supervisor mostrarUmServico(Integer id_servico){
//        Optional<Supervisor> servico = servRepository.findById(id_servico);
//        return servico.orElseThrow();
//    }
//
//    //mostrar funcionario do servico ONE TO ONE
//    public Supervisor buscarCargoDoServico(Integer id_cargo){
//        Supervisor servico = servRepository.fetchByCargo(id_cargo);
//        return servico;
//    }
//
//    //buscar servico por nome
////    public Servico buscarServicoPeloNome(String serv_nome) {
////        Servico servico = servRepository.fetchByName(serv_nome);
////        return servico;
////    }
//
//    //buscar cargo sem servico
//    public List<Supervisor> cargoSemServico(){
//        return servRepository.cargoSemServico();
//    }
//    
//    public List<Supervisor> cargoComoServico(){
//    	return servRepository.cargoComoServico();
//    }
//
//    public List<List> cargoComServico(){
//        return servRepository.cargoComServico();
//    }
//
//    //cadastrar servico
////    public Supervisor inserirServico(Integer id_cargo, Supervisor servico){
////        servico.setId_servico(null);
////        if(id_cargo != null){
////            Cargo cargo = cargoService.buscarUmCargo(id_cargo);
////            servico.setCargo(cargo);
////        }
////        return servRepository.save(servico);
////    }
//
//    //editar servico
//    public Supervisor editarServico(Supervisor servico){
//        mostrarUmServico(servico.getId_supervisor());
//        return servRepository.save(servico);
//    }

	//------------------------Instanciação dependencias-------------------//
	@Autowired
	private SupervisorRepository suRepository;
	
	@Autowired
	private CargoService cargoService;
	
	//mostra todos supervisores
	public List<Supervisor> mostrarTodosSupervisores(){
		return suRepository.findAll();
	}
	
	//mostrar Um Supervisor
	public Supervisor mostrarUmSupervisor(Integer id_supervisor) {
		Optional<Supervisor> supervisor = suRepository.findById(id_supervisor);
		return supervisor.orElseThrow();
	}

	//mostrar Supervisor do cargo pelo id
	public Supervisor buscarSupervisorDoCargo(Integer id_cargo){
		Supervisor supervisor = suRepository.fetchByCargo(id_cargo);
		return supervisor;
	}
	
	//buscar supervisor pelo nome
	public Supervisor buscarSupervisorPeloNome(String supervisor_nome){
		Supervisor supervisor = suRepository.fetchByName(supervisor_nome);
		return supervisor;
	}
	
	public List<Supervisor> supervisorSemCargo(){
		return suRepository.supervisorSemCargo();
	}
	
	public List<List> supervisorComSeuCargo(){
		return suRepository.supervisorComSeuCargo();
	}
	
	public Supervisor InserirSupervisor(Integer id_cargo, Supervisor supervisor) {
		supervisor.setId_supervisor(null);
		
		if(id_cargo != null) {
			Cargo cargo = cargoService.buscarUmCargo(id_cargo);
			supervisor.setCargo(cargo);
			
		}
		return suRepository.save(supervisor);
		
	}
	
	public Supervisor editarSupervisor(Supervisor supervisor) {
		mostrarUmSupervisor(supervisor.getId_supervisor());
		return suRepository.save(supervisor);
	}
	
	public void excluirSupervisor(Integer id_supervisor) {
		suRepository.deleteById(id_supervisor);
	}
}
