import java.util.Optional;

public class Cafeteria {

    public static void main(String[] args) {

        // =========================
        // PRODUTOS
        // =========================

        Produto produto1 = new Produto(1, "Café gelado", 9.50);
        Produto produto2 = new Produto(2, "Cappuccino", 6.50);
        Produto produto3 = new Produto(3, "Bolo de chocolate", 12.00);

        // =========================
        // CLIENTES
        // =========================

        Cliente cliente1 = new Cliente(1, "Maria", "maria@gmail.com");
        Cliente cliente2 = new Cliente(2, "Ana", "ana@gmail.com");
        Cliente cliente3 = new Cliente(3, "Sandra", "sandra@gmail.com");

        // =========================
        // ITENS DOS PEDIDOS
        // =========================

        ItemPedido itemPedido1 = new ItemPedido(produto1, 2);
        ItemPedido itemPedido2 = new ItemPedido(produto2, 1);
        ItemPedido itemPedido3 = new ItemPedido(produto3, 2);

        // =========================
        // PEDIDOS
        // =========================

        Pedido pedido1 = new Pedido(1, cliente1);
        Pedido pedido2 = new Pedido(2, cliente2);
        Pedido pedido3 = new Pedido(3, cliente3);

        // =========================
        // ADICIONAR ITENS AOS PEDIDOS
        // =========================

        pedido1.adicionarItem(itemPedido1);
        pedido2.adicionarItem(itemPedido2);
        pedido3.adicionarItem(itemPedido3);

        // =========================
        // CADASTROS
        // =========================

        CadastroClientes cadastro = new CadastroClientes();
        CadastroProdutos cadastroProdutos = new CadastroProdutos();

        cadastroProdutos.cadastrarProduto(produto1);
        cadastroProdutos.cadastrarProduto(produto2);
        cadastroProdutos.cadastrarProduto(produto3);

        cadastro.cadastrar(cliente1);
        cadastro.cadastrar(cliente2);
        cadastro.cadastrar(cliente3);


        // =========================
        // NOTA FISCAL 1
        // =========================

        System.out.println("              NOTA FISCAL 1                ");
        System.out.println("------------------------------------------");

        System.out.println("Pedido: #" + pedido1.getId());

        System.out.println();

        System.out.println("CLIENTE");
        System.out.println("------------------------------------------");
        System.out.println("Nome: " + cliente1.getNome());
        System.out.println("Email: " + cliente1.getEmail());

        System.out.println();

        System.out.println("ITENS DO PEDIDO");
        System.out.println("------------------------------------------");

        System.out.printf(
                "%-20s %5s %10s%n",
                "Produto",
                "Qtd.",
                "Valor"
        );

        System.out.println("------------------------------------------");

        System.out.printf(
                "%-20s %5d R$ %7.2f%n",
                produto1.getNome(),
                itemPedido1.getQuantidade(),
                itemPedido1.subtotal()
        );

        System.out.println("------------------------------------------");

        System.out.printf(
                "%-26s R$ %7.2f%n",
                "TOTAL:",
                itemPedido1.subtotal()
        );

        System.out.println("------------------------------------------");
        System.out.println("FORMA DE PAGAMENTO: DINHEIRO");

        pedido1.definirFormaPagamento(new Dinheiro());
        pedido1.pagar();


        // =========================
        // NOTA FISCAL 2
        // =========================

        System.out.println();
        System.out.println();

        System.out.println("              NOTA FISCAL 2                ");
        System.out.println("------------------------------------------");

        System.out.println("Pedido: #" + pedido2.getId());

        System.out.println();

        System.out.println("CLIENTE");
        System.out.println("------------------------------------------");
        System.out.println("Nome: " + cliente2.getNome());
        System.out.println("Email: " + cliente2.getEmail());

        System.out.println();

        System.out.println("ITENS DO PEDIDO");
        System.out.println("------------------------------------------");

        System.out.printf(
                "%-20s %5s %10s%n",
                "Produto",
                "Qtd.",
                "Valor"
        );

        System.out.println("------------------------------------------");

        System.out.printf(
                "%-20s %5d R$ %7.2f%n",
                produto2.getNome(),
                itemPedido2.getQuantidade(),
                itemPedido2.subtotal()
        );

        System.out.println("------------------------------------------");

        System.out.printf(
                "%-26s R$ %7.2f%n",
                "TOTAL:",
                itemPedido2.subtotal()
        );

        System.out.println("------------------------------------------");
        System.out.println("FORMA DE PAGAMENTO: PIX");

        pedido2.definirFormaPagamento(new Pix());
        pedido2.pagar();

        // =========================
        // NOTA FISCAL 3
        // =========================

        System.out.println();
        System.out.println();

        System.out.println("              NOTA FISCAL 3                ");
        System.out.println("------------------------------------------");

        System.out.println("Pedido: #" + pedido3.getId());

        System.out.println();

        System.out.println("CLIENTE");
        System.out.println("------------------------------------------");
        System.out.println("Nome: " + cliente3.getNome());
        System.out.println("Email: " + cliente3.getEmail());

        System.out.println();

        System.out.println("ITENS DO PEDIDO");
        System.out.println("------------------------------------------");

        System.out.printf(
                "%-20s %5s %10s%n",
                "Produto",
                "Qtd.",
                "Valor"
        );

        System.out.println("------------------------------------------");

        System.out.printf(
                "%-20s %5d R$ %7.2f%n",
                produto3.getNome(),
                itemPedido3.getQuantidade(),
                itemPedido3.subtotal()
        );

        System.out.println("------------------------------------------");

        System.out.printf(
                "%-26s R$ %7.2f%n",
                "TOTAL:",
                itemPedido3.subtotal()

        );

        System.out.println("------------------------------------------");
        System.out.println("FORMA DE PAGAMENTO: CARTÃO DE CRÉDITO");

        pedido3.definirFormaPagamento(new CartaoCredito());
        pedido3.pagar();

        // =========================
        // STATUS DO PEDIDO
        // =========================

        System.out.println();
        System.out.println();

        System.out.println("------------------------------------------");
        System.out.println("STATUS DO PEDIDO 1");
        System.out.println("------------------------------------------");

        pedido1.processar();
        System.out.println("Processando... " + pedido1.getStatus());

        pedido1.enviar();
        System.out.println("Enviado... " + pedido1.getStatus());

        pedido1.entregar();
        System.out.println("Entregue... " + pedido1.getStatus());


        System.out.println();

        System.out.println("------------------------------------------");
        System.out.println("STATUS DO PEDIDO 2");
        System.out.println("------------------------------------------");

        pedido2.processar();
        System.out.println("Processando... " + pedido2.getStatus());

        pedido2.enviar();
        System.out.println("Enviado... " + pedido2.getStatus());

        pedido2.entregar();
        System.out.println("Entregue... " + pedido2.getStatus());


        System.out.println();

        System.out.println("------------------------------------------");
        System.out.println("STATUS DO PEDIDO 3");
        System.out.println("------------------------------------------");

        pedido3.processar();
        System.out.println("Processando... " + pedido3.getStatus());

        pedido3.enviar();
        System.out.println("Enviado... " + pedido3.getStatus());

        pedido3.entregar();
        System.out.println("Entregue... " + pedido3.getStatus());


        // =========================
        // TESTES DE EXCEÇÕES
        // =========================

        System.out.println();
        System.out.println("========== TESTES DE EXCEÇÕES ==========");


        // Teste: produto com ID duplicado
        try {
            cadastroProdutos.cadastrarProduto(produto3);
        } catch (IdDuplicadoException e) {
            System.out.println("[ERRO] " + e.getMessage());
        } finally {
            System.out.println("Fim da lista: Produto não encontrado.");
        }

        // Teste: cliente com ID duplicado
        try {
            cadastro.cadastrar(cliente1);
        } catch (IdDuplicadoException e) {
            System.out.println("[ERRO] " + e.getMessage());
        } finally {
            System.out.println("Fim da lista: Cliente não encontrado.");
        }

        // Teste: produto não encontrado
        try {
            Optional<Produto> produtoEncontrado =
                    cadastroProdutos.buscarProdutoPorId(10);
            if (produtoEncontrado.isEmpty()) {
                throw new ProdutoNaoEncontradoException(
                        "Produto com ID 10 não encontrado."
                );
            }
        } catch (ProdutoNaoEncontradoException e) {
            System.out.println("[ERRO] " + e.getMessage());
        }

        // Teste: cliente não encontrado
        try {
            Optional<Cliente> clienteEncontrado =
                    cadastro.buscarPorId(10);
            if (clienteEncontrado.isEmpty()) {
                throw new ClienteNaoEncontradoException(
                        "Cliente com ID 10 não encontrado."
                );
            }
        } catch (ClienteNaoEncontradoException e) {
            System.out.println("[ERRO] " + e.getMessage());
        }

    }
}