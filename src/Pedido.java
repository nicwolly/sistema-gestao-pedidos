import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int id;
    private Cliente cliente;
    private List<ItemPedido> carrinho;

    public Pedido(int id, Cliente cliente) {
        this.id = id;
        if (cliente == null){
            System.out.println("Erro: O pedido precisa ter um cliente!");
        }else {
            this.cliente = cliente;
        }
        this.carrinho = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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

