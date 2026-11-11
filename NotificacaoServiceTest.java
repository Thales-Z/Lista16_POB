package lista16_pob;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class NotificacaoServiceTest {

    @Mock
    private EmailSender emailSender;

    @InjectMocks
    private NotificacaoService notificacaoService;

    @Captor
    private ArgumentCaptor<String> destinatarioCaptor;

    @Captor
    private ArgumentCaptor<String> assuntoCaptor;

    @Captor
    private ArgumentCaptor<String> corpoCaptor;

    @Test
    void testNotificarBoasVindas() {
        Usuario usuario = new Usuario(1L, "Thales");

        notificacaoService.notificarBoasVindas(usuario);

        verify(emailSender).enviar(
            destinatarioCaptor.capture(),
            assuntoCaptor.capture(),
            corpoCaptor.capture()
        );

        assertTrue(assuntoCaptor.getValue().contains("Bem-vindo"));
        assertTrue(corpoCaptor.getValue().contains("Thales"));
    }
}
