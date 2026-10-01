import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CadastroProdutos {
    private List<Produto> produtos;

    public CadastroProdutos() {
        this.produtos = new ArrayList<>();
    }

    public void cadastrarProduto(Produto produto){
        if (produto == null){
            System.out.println("Erro: não pode ficar nulo.");
        }
        Optional<Produto> produtoEncontrado = buscarProdutoPorId(produto.getId());
        if (produtoEncontrado.isPresent()){
            System.out.println("Erro: já existe produto cadastrado com esse ID.");
            return;
        }
        this.produtos.add(produto);
    }

    public Optional<Produto> buscarProdutoPorId(int id){
        for (Produto produto : produtos){
            if (produto.getId() == id){
                return Optional.of(produto);
            }
        }
        return Optional.empty();
    }

    public List<Produto> listarProdutos(){
        return new ArrayList<>(produtos);
        }

    public boolean removerProdutos(int id){
        Optional<Produto> produtoEncontrado = buscarProdutoPorId(id);

        if (produtoEncontrado.isPresent()){
            produtos.remove(produtoEncontrado.get());
            return true;
        }
        return false;
    }
}