import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int id;
    private Cliente cliente;
    private List<ItemPedido> carrinho;
    private StatusPedido status;

    public Pedido(int id, Cliente cliente) {
        this.id = id;
        if (cliente == null){
            System.out.println("Erro: O pedido precisa ter um cliente!");
        }else {
            this.cliente = cliente;
        }
        this.carrinho = new ArrayList<>();
        this.status = StatusPedido.PENDENTE;
    }

    public StatusPedido getStatus(){
        return this.status;
    }

    public void processar(){
        if (this.status == StatusPedido.PENDENTE){
            this.status = StatusPedido.PROCESSANDO;
        } else {
            System.out.println("Não é possível processar um pedido que não está pendente.");
        }
    }

    public void enviar(){
        if (this.status == StatusPedido.PROCESSANDO){
            this.status = StatusPedido.ENVIADO;
        } else {
            System.out.println("Não é possível enviar um pedido que não está processando.");
        }
    }

    public void entregar(){
        if (this.status == StatusPedido.ENVIADO){
            this.status = StatusPedido.ENTREGUE;
        } else {
            System.out.println("Não é possível entregar um pedido que não foi enviado.");
        }
    }

    public void cancelar(){
        if (this.status == StatusPedido.PENDENTE
                || this.status == StatusPedido.PROCESSANDO){
            this.status = StatusPedido.CANCELADO;
        } else {
            System.out.println("Não é possível cancelar um pedido que não está pendente/processando.");
        }
    }

    public List<ItemPedido> getcarrinho() {
        return carrinho;
    }

    public void setcarrinho(List<ItemPedido> carrinho) {
        this.carrinho = carrinho;
    }

    // checa se o item não é nulo E se o subtotal dele é maior que zero
    public void adicionarItem(ItemPedido item){
        if (item != null && item.subtotal() > 0){
            this.carrinho.add(item);
        }else {
            System.out.println("Erro: Não é possível adicionar um item inválido no carrinho.");
        }
    }

    public boolean ehValido(){
        return this.cliente != null && !this.carrinho.isEmpty();
    }

    public double calcularTotal(){
        double total = 0;
        for (ItemPedido item: this.carrinho){
            total += item.subtotal();
        }
        return total;
    }

    public void exibirDadosPedido(){
        System.out.println(id);
        System.out.println(cliente);
        System.out.println(carrinho);
        System.out.println(calcularTotal());
    }

    @Override
    public String toString() {
        return "=== Pedido ID: " + id + " ===\n" +
                "Cliente: " + cliente + "\n" +
                "--- Itens ---\n" +
                carrinho.toString().replace("[", "").replace("]", "").replace(", ", "\n") + "\n" +
                "-------------------\n" +
                "Valor total: R$ " + String.format("%.2f", calcularTotal());
    }
}

