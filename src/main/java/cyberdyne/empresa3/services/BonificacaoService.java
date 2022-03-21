package cyberdyne.empresa3.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cyberdyne.empresa3.models.Bonificacao;
import cyberdyne.empresa3.models.Funcionario;
import cyberdyne.empresa3.models.StatusBonificacao;
import cyberdyne.empresa3.repository.BonificacaoRepository;

@Service
public class BonificacaoService {
	
	@Autowired
	private BonificacaoRepository boRepository;
	
	@Autowired
	private FuncionarioService funcService;
	
	public List<Bonificacao> buscarTodasBonificacoes(){
		return boRepository.findAll();
	}
	
	public Bonificacao buscarUmaBonificacao(Integer codigo) {
		Optional<Bonificacao> bonificacao = boRepository.findById(codigo);
		return bonificacao.orElseThrow();
	}
	
	public List<Bonificacao> buscarBonificacaoDoFuncionario(Integer id_funcionario){
		List<Bonificacao> bonificacao = boRepository.buscarBonificacaoDoFuncionario(id_funcionario);
		return bonificacao;
	}
	
	public Bonificacao adicionarBonificacao(Bonificacao bonificacao, Integer id_funcionario) {
		bonificacao.setCodigo(null);
		Funcionario funcionario = funcService.buscarUmfunc(id_funcionario);
		bonificacao.setFuncionario(funcionario);
		return boRepository.save(bonificacao);
	}
	
	public Bonificacao pagarBonificacao(Integer codigo) {
		Bonificacao bonificacao = buscarUmaBonificacao(codigo);
		StatusBonificacao st1 = StatusBonificacao.RECEBIDO;
		bonificacao.setBo_status(st1);
		return boRepository.save(bonificacao);
	}
	
	public Bonificacao cancelarBonificacao(Integer codigo) {
		Bonificacao bonificacao = buscarUmaBonificacao(codigo);
		StatusBonificacao st1 = StatusBonificacao.CANCELADO;
		bonificacao.setBo_status(st1);
		return boRepository.save(bonificacao);
	}
	
	public Bonificacao editarBonificacao(Bonificacao bonificacao, Integer codigo, Integer id_funcionario) {
		buscarUmaBonificacao(bonificacao.getCodigo());
		Funcionario funcionario = funcService.buscarUmfunc(id_funcionario);
		bonificacao.setFuncionario(funcionario);
		return boRepository.save(bonificacao);
	}
}
