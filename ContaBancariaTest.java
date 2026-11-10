package lista16_pob;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContaBancariaTest {

    private ContaBancaria conta;

    @BeforeEach
    void setUp() {
        conta = new ContaBancaria();
        conta.depositar(500.0);
    }

    @Test
    void testSacarSaldoInsuficiente() {
        SaldoInsuficienteException excecao = assertThrows(
            SaldoInsuficienteException.class,
            () -> conta.sacar(600.0)
        );

        assertEquals("Saldo insuficiente para realizar o saque.", excecao.getMessage());
    }
}
