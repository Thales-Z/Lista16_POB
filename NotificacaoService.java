package lista16_pob;

interface EmailSender {
    void enviar(String destinatario, String assunto, String corpo);
}

class NotificacaoService {
    private final EmailSender emailSender;

    public NotificacaoService(EmailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void notificarBoasVindas(Usuario usuario) {
        String assunto = "Bem-vindo ao sistema!";
        String corpo = "Olá " + usuario.getEmail() + ", seja muito bem-vindo.";
        emailSender.enviar(usuario.getEmail(), assunto, corpo);
    }
}
