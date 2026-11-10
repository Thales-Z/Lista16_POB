package lista16_pob;

public class ValidadorSenha {
    public boolean isForte(String senha) {
        if (senha == null || senha.length() < 8) {
            return false;
        }
        
        boolean temDigito = false;
        boolean temMaiuscula = false;
        
        for (int i = 0; i < senha.length(); i++) {
            char c = senha.charAt(i);
            if (Character.isDigit(c)) {
                temDigito = true;
            }
            if (Character.isUpperCase(c)) {
                temMaiuscula = true;
            }
        }
        
        return temDigito && temMaiuscula;
    }
}
