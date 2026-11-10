package lista16_pob;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class ValidadorSenhaTest {

    private final ValidadorSenha validador = new ValidadorSenha();

    @ParameterizedTest
    @ValueSource(strings = {"SenhaForte1", "Abcdefg2", "MinhaSenha2026"})
    void testSenhasValidas(String senha) {
        assertTrue(validador.isForte(senha));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"curta1A", "semnumero", "SEMMAIUSCULA1", "12345678"})
    void testSenhasInvalidas(String senha) {
        assertFalse(validador.isForte(senha));
    }
}
