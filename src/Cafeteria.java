import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

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

        System.out.println(cadastroProdutos.removerProdutos(1));
        System.out.println();


        try {
            Optional<Produto> produtoEncontrado = cadastroProdutos.buscarProdutoPorId(3);
            if (produtoEncontrado.isEmpty()) {
                throw new ProdutoNaoEncontradoException(
                        "Erro: Produto com esse ID não foi encontrado."
                );
            }
        } catch (ProdutoNaoEncontradoException e){
            System.out.println(e.getMessage());
        }

        try {
            Optional<Cliente> clienteEncontrado = cadastro.buscarPorId(3);

            if (clienteEncontrado.isEmpty()){
                throw new ClienteNaoEncontradoException(
                        "Erro: Cliente com ID 3 não encontrado."
                );
            }
        } catch (ClienteNaoEncontradoException e) {
            System.out.println(e.getMessage());
        }

        System.out.println();

        pedido.processar();
        System.out.println(pedido.getStatus());

        pedido.enviar();
        System.out.println(pedido.getStatus());

        pedido.entregar();
        System.out.println(pedido.getStatus());

        pedido.cancelar();
        System.out.println(pedido.getStatus());

    }
}