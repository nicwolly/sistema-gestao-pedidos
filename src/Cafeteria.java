import java.util.List;
import java.util.ArrayList;

public class Cafeteria {
    public static void main(String[] args) {

        Produto produto = new Produto(1,"Café gelado",10.50 );
        Produto produto2 = new Produto(1,"Café pingado",6.00 );
        Cliente cliente = new Cliente(1, "Maria", "maria@gmail.com");
        Cliente cliente2 = new Cliente(2, "Sandra", "sandra@gmail.com");
        Cliente cliente3 = new Cliente(0, "", "");


        ItemPedido itemPedido = new ItemPedido(produto, 2);
        Pedido pedido = new Pedido(12, cliente);
        CadastroClientes cadastro = new CadastroClientes();
        CadastroProdutos cadastroProdutos = new CadastroProdutos();

        pedido.adicionarItem(itemPedido);
        System.out.println(pedido);


        cadastroProdutos.cadastrarProduto(produto);
        cadastroProdutos.cadastrarProduto(produto2);
        cadastroProdutos.cadastrarProduto(p);
        System.out.println(cadastroProdutos.listarProdutos());
        System.out.println(cadastroProdutos.buscarProdutoPorId(1).get());
        System.out.println(cadastroProdutos.buscarProdutoPorId(1).get());
        System.out.println(cadastroProdutos.removerProdutos(1));
        System.out.println();
        cadastro.cadastrar(cliente);
        System.out.println();
        cadastro.cadastrar(cliente2);
        System.out.println();
        cadastro.cadastrar(cliente3);
        System.out.println(cadastro.listarClientes());
        System.out.println(cadastro.buscarPorId(1).get());
        System.out.println(cadastro.buscarPorId(1));
        System.out.println(cadastro.removerPorId(1));

    }
}