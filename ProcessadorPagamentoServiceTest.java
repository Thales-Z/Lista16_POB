package lista16_pob;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ProcessadorPagamentoServiceTest {

    @Mock
    private GatewayPagamento gateway;

    @Mock
    private PedidoRepository pedidoRepository;

    @InjectMocks
    private ProcessadorPagamentoService processador;

    @Test
    void testProcessarPagamentoRecusado() {
        Pedido pedido = new Pedido();

        doThrow(new PagamentoRecusadoException("Recusado"))
            .when(gateway)
            .cobrar(anyDouble());

        assertThrows(PagamentoRecusadoException.class, () -> {
            processador.processar(pedido, 100.0);
        });

        verify(pedidoRepository, never()).atualizar(any(Pedido.class));
    }
}
