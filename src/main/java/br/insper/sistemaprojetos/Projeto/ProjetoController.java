package br.insper.sistemaprojetos.Projeto;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.insper.sistemaprojetos.Projeto.dto.EditProjetoDTO;
import br.insper.sistemaprojetos.Projeto.dto.ResponseProjetoDTO;
import br.insper.sistemaprojetos.Projeto.dto.SaveProjetoDTO;
import br.insper.sistemaprojetos.Auth.AccessService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/projetos")
public class ProjetoController {

    @Autowired
    private ProjetoService projetoService;

    @Autowired
    private AccessService accessService;

    @GetMapping
    public List<ResponseProjetoDTO> listProjetos(@RequestHeader("X-USER-ID") UUID adminId, @RequestParam(required = false, name = "nome") String nome) {
        return projetoService.list(nome);
    }

    @PostMapping
    public ResponseProjetoDTO saveProjeto(@RequestHeader("X-USER-ID") UUID adminId, @Valid @RequestBody SaveProjetoDTO projeto) {
        return projetoService.save(projeto);
    }

    @GetMapping("/{id}")
    public ResponseProjetoDTO getProjeto(@RequestHeader("X-USER-ID") UUID adminId, @PathVariable UUID id) {
        return projetoService.getDTO(id);
    }

    @PutMapping("/{id}")
    public ResponseProjetoDTO editProjeto(@RequestHeader("X-USER-ID") UUID adminId, @PathVariable UUID id, @RequestBody EditProjetoDTO projeto) {
        return projetoService.edit(id, projeto);
    }

    @DeleteMapping("/{id}")
    public void deleteProjeto(@RequestHeader("X-USER-ID") UUID adminId, @PathVariable UUID id) {
        projetoService.delete(id);
    }

    @PostMapping("/{projetoId}/usuarios/{userId}")
    public ResponseProjetoDTO adicionarUsuario(@RequestHeader("X-USER-ID") UUID adminId, @PathVariable UUID projetoId, @PathVariable UUID userId) {
        accessService.checkAdmin(adminId);
        return projetoService.adicionarUsuario(projetoId, userId);
    }

    @DeleteMapping("/{projetoId}/usuarios/{userId}")
    public ResponseProjetoDTO removerUsuario(@RequestHeader("X-USER-ID") UUID adminId, @PathVariable UUID projetoId, @PathVariable UUID userId) {
        accessService.checkAdmin(adminId);
        return projetoService.removerUsuario(projetoId, userId);
    }

}