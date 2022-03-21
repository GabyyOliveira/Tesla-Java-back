package cyberdyne.empresa3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import cyberdyne.empresa3.models.Funcionario;
import cyberdyne.empresa3.services.FuncionarioService;
import cyberdyne.empresa3.utils.UploadFileUtil;

@CrossOrigin
@RestController
@RequestMapping("empresa")
public class UploadFileController {
	
	@Autowired
	 private FuncionarioService funcService;
    
    @PostMapping("/envio/{id_funcionario}")
    public ResponseEntity<String> enviarDados(@PathVariable Integer id_funcionario, MultipartFile foto, @RequestParam(value = "nome")String nome){

        String fileName = nome;
        String uploadDir = "C:/Users/gabyy/Documents/Development/Tesla/src/assets";
        String nomeMaisCaminho = "/src/assets" + "/" + nome;

        Funcionario funcionario = funcService.salvarFoto(id_funcionario, nomeMaisCaminho);
        
        try{
            UploadFileUtil.salvarArquivo(uploadDir, fileName, foto);
        }catch(Exception e){
            System.out.println("O arquivo não foi enviado " + e);
        }

        System.out.println("Deu certo " + nomeMaisCaminho);
        return ResponseEntity.ok("Arquivo enviado");
    }
}
