package br.insper.sistemaprojetos.Projeto;

import br.insper.sistemaprojetos.Projeto.ProjetoService;
import br.insper.sistemaprojetos.Projeto.dto.EditProjetoDTO;
import br.insper.sistemaprojetos.Projeto.dto.ResponseProjetoDTO;
import br.insper.sistemaprojetos.Projeto.dto.SaveProjetoDTO;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/projetos")
public class ProjetoController {

    @Autowired
    private ProjetoService projetoService;

    @GetMapping
    public List<ResponseProjetoDTO> listProjetos(@RequestParam(required = false, name = "nome") String nome) {
        return projetoService.list(nome);
    }

    @PostMapping
    public ResponseProjetoDTO saveProjeto(@Valid @RequestBody SaveProjetoDTO projeto) {
        return projetoService.save(projeto);
    }

    @GetMapping("/{id}")

    public ResponseProjetoDTO getProjeto(@PathVariable UUID id) {
        return projetoService.getDTO(id);
    }

    @PutMapping("/{id}")
    public ResponseProjetoDTO editProjeto(@PathVariable UUID id, @RequestBody EditProjetoDTO projeto) {
        return projetoService.edit(id, projeto);
    }

    @DeleteMapping("/{id}")
    public void deleteProjeto(@PathVariable UUID id) {
        projetoService.delete(id);
    }

}