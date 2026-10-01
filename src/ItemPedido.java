import java.util.ArrayList;
import java.util.List;

public class ItemPedido {
    private Produto produto;
    private int quantidade;


    public ItemPedido(Produto produto, int quantidade) {
        if (produto == null){
            throw new IllegalArgumentException(
                    "Erro: O produto não pode estar nulo."
            );
        }
        this.produto = produto;

        if (quantidade > 0){
            this.quantidade = quantidade;
        }else {
            throw new IllegalArgumentException(
                    "Erro: A quantidade deve ser maior que zero."
            );
        }
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int novaQuantidade) {
        if (novaQuantidade > 0){
            this.quantidade = novaQuantidade;
        }else {
            throw new IllegalArgumentException(
                    "Erro: A nova quantidade é inválida! Quantidade anterior permanece mantida."
            );
        }
    }

    public double subtotal(){
        return (produto.getPreco() * quantidade);
    }

    public void exibirDadosItens(){
        System.out.println(produto);
        System.out.println(quantidade);
        System.out.println(subtotal());
    }

    @Override
    public String toString() {
        return quantidade + "x " + produto + " -> Subtotal: R$ " + String.format("%.2f", subtotal());
    }
}