import java.util.List;
import java.util.ArrayList;

public class Cafeteria {
    public static void main(String[] args) {

        Produto produto = new Produto(1,"Café gelado",10.50 );
        Cliente cliente = new Cliente(1, "Maria", "maria@gmail.com");

        ItemPedido itemPedido = new ItemPedido(produto, 2);
        Pedido pedido = new Pedido(1, cliente);
        CadastroClientes cadastro = new CadastroClientes();
        CadastroProdutos cadastroProdutos = new CadastroProdutos();


        pedido.adicionarItem(itemPedido);
        System.out.println(pedido);

        cadastroProdutos.cadastrarProduto(produto);
        System.out.println(cadastroProdutos.listarProdutos());
        System.out.println(cadastroProdutos.buscarProdutoPorId(1).get());
        System.out.println(cadastroProdutos.removerProdutos(1));
        System.out.println();
        cadastro.cadastrar(cliente);


        pedido.processar();
        System.out.println(pedido.getStatus());



        pedido.entregar();
        System.out.println(pedido.getStatus());

        pedido.cancelar();
        System.out.println(pedido.getStatus());
    }
}