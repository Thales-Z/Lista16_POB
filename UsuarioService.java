package lista16_pob;

import java.util.Optional;

class Usuario {
    private Long id;
    private String email;

    public Usuario(Long id, String email) {
        this.id = id;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

interface UsuarioRepository {
    Optional<Usuario> buscarPorId(Long id);
    void salvar(Usuario u);
}

class UsuarioService {
    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public void atualizarEmail(Long id, String novoEmail) {
        Optional<Usuario> usuarioOpt = repository.buscarPorId(id);
        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            usuario.setEmail(novoEmail);
            repository.salvar(usuario);
        }
    }
}
