package br.insper.sistemaprojetos.Projeto;

import br.insper.sistemaprojetos.User.User;
import br.insper.sistemaprojetos.User.UserService;

import br.insper.sistemaprojetos.Projeto.dto.EditProjetoDTO;
import br.insper.sistemaprojetos.Projeto.dto.ResponseProjetoDTO;
import br.insper.sistemaprojetos.Projeto.dto.SaveProjetoDTO;
import br.insper.sistemaprojetos.Projeto.exception.ProjetoAlreadyExistsException;
import br.insper.sistemaprojetos.Projeto.exception.ProjetoNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    @Autowired
    private UserService userService;

    public ResponseProjetoDTO save(SaveProjetoDTO dto) {

        if (projetoRepository.existsByNome(dto.getNome())) {
            throw new ProjetoAlreadyExistsException();
        }

        Projeto projeto = Projeto.toModel(dto);
        projeto = projetoRepository.save(projeto);
        return ResponseProjetoDTO.toDTO(projeto);
    }

    public List<ResponseProjetoDTO> list(String nome) {
        List<Projeto> projetos;
        if (nome != null) {
            projetos = projetoRepository.findByNomeContaining(nome);
        } else {
            projetos = projetoRepository.findAll();
        }

        return projetos.stream().map(ResponseProjetoDTO::toDTO).toList();
    }

    public Projeto get(UUID id) {
        return projetoRepository.findById(id).orElseThrow(() -> new ProjetoNotFoundException());
    }

    public ResponseProjetoDTO getDTO(UUID id) {
        return ResponseProjetoDTO.toDTO(get(id));
    }

    public ResponseProjetoDTO edit(UUID id, EditProjetoDTO dto) {

        Projeto projetoDB = get(id);
        projetoDB.setNome(dto.getNome());
        projetoDB.setDescricao(dto.getDescricao());
        projetoDB = projetoRepository.save(projetoDB);

        return ResponseProjetoDTO.toDTO(projetoDB);
    }

    public void delete(UUID id) {
        Projeto projetoDB = get(id);
        projetoRepository.delete(projetoDB);
    }

    public ResponseProjetoDTO adicionarUsuario(UUID projetoId, UUID userId) {
        Projeto projeto = get(projetoId);
        User user = userService.get(userId);

        if (!projeto.getUsuarios().contains(user)) {
            projeto.getUsuarios().add(user);
        }
        projeto = projetoRepository.save(projeto);
        return ResponseProjetoDTO.toDTO(projeto);
    }

    public ResponseProjetoDTO removerUsuario(UUID projetoId, UUID userId) {
        Projeto projeto = get(projetoId);
        User user = userService.get(userId);
        projeto.getUsuarios().remove(user);
        projeto = projetoRepository.save(projeto);

        return ResponseProjetoDTO.toDTO(projeto);
    }

}
