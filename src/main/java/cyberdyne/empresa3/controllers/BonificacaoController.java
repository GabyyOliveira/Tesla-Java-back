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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import cyberdyne.empresa3.models.Bonificacao;
import cyberdyne.empresa3.services.BonificacaoService;

@CrossOrigin
@RestController
@RequestMapping("empresa")
public class BonificacaoController {
	
	@Autowired
	private BonificacaoService boService;
	
	@GetMapping("/funcionario/bonificacoes")
	public List<Bonificacao> buscarTodasBonificacoes(){
		List<Bonificacao> bonificacao = boService.buscarTodasBonificacoes();
		return bonificacao;
	}
	
	@GetMapping("/funcionario/bonificacao/{codigo}")
	public ResponseEntity<Bonificacao> buscarUmaBonificacao(@PathVariable Integer codigo){
		Bonificacao bonificacao = boService.buscarUmaBonificacao(codigo);
		return ResponseEntity.ok().body(bonificacao);
	}
	
	@GetMapping("/funcionario/bonificacao-funcionario/{id_funcionario}")
	public List<Bonificacao> buscarBonificacoesDoFuncionario(@PathVariable Integer id_funcionario){
		List<Bonificacao> bonificacao = boService.buscarBonificacaoDoFuncionario(id_funcionario);
		return bonificacao;
	}
	
	@PostMapping("/funcionario/adicionarBonificacao/{id_funcionario}")
	public ResponseEntity<Bonificacao> adicionarBonificacao(@RequestBody Bonificacao bonificacao, @PathVariable Integer id_funcionario){
		bonificacao = boService.adicionarBonificacao(bonificacao, id_funcionario);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(bonificacao.getCodigo()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping("/funcionario/pagarBonificacao/{codigo}")
	public ResponseEntity<Bonificacao> pagarBonificacao(@PathVariable Integer codigo){
		boService.pagarBonificacao(codigo);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/funcionario/cancelarBonificacao/{codigo}")
	public ResponseEntity<Bonificacao> cancelarBonificacao(@PathVariable Integer codigo){
		boService.cancelarBonificacao(codigo);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/funcionario/editarBonificacao/{codigo}/{id_funcionario}")
	public ResponseEntity<Bonificacao> editarBonificacao(@RequestBody Bonificacao bonificacao, @PathVariable Integer codigo, @PathVariable Integer id_funcionario){
		boService.editarBonificacao(bonificacao, codigo, id_funcionario);
		return ResponseEntity.noContent().build();
	}

//	@DeleteMapping("/funcionario/excluir-bonificacao/{codigo}/{id_funcionario}")
//	public ResponseEntity<Bonificacao> excluirBonificacao(@PathVariable Integer)
}
