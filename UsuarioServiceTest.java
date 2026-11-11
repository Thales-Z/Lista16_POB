package lista16_pob;

import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UsuarioServiceTest {

    @Mock
    private UsuarioRepository repository;

    @InjectMocks
    private UsuarioService service;

    @Test
    void testAtualizarEmail() {
        Usuario usuarioExistente = new Usuario(1L, "antigo@dominio.com");

        when(repository.buscarPorId(1L)).thenReturn(Optional.of(usuarioExistente));

        service.atualizarEmail(1L, "novo@dominio.com");

        assertEquals("novo@dominio.com", usuarioExistente.getEmail());
        verify(repository, times(1)).salvar(any(Usuario.class));
    }
}
