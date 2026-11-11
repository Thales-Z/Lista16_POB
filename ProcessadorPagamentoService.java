package lista16_pob;

class PagamentoRecusadoException extends RuntimeException {
    public PagamentoRecusadoException(String mensagem) {
        super(mensagem);
    }
}

class Pedido {
    private String status = "PENDENTE";

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}

interface GatewayPagamento {
    void cobrar(double valor);
}

interface PedidoRepository {
    void atualizar(Pedido pedido);
}

class ProcessadorPagamentoService {
    private final GatewayPagamento gateway;
    private final PedidoRepository pedidoRepository;

    public ProcessadorPagamentoService(GatewayPagamento gateway, PedidoRepository pedidoRepository) {
        this.gateway = gateway;
        this.pedidoRepository = pedidoRepository;
    }

    public void processar(Pedido pedido, double valor) {
        gateway.cobrar(valor);
        pedido.setStatus("PAGO");
        pedidoRepository.atualizar(pedido);
    }
}
