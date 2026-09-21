// Representa um produto da cafeteria
public class Produto {
    private int id;
    private String nome;
    private double preco;

    public Produto(int id, String nome, double preco) {
        this.id = id;
        if (nome == null) {
            System.out.println("Erro: O nome do produto é obrigatório!");
        } else {
            this.nome = nome;
        }
        if (preco > 0){
            this.preco = preco;
        } else {
            System.out.println("Erro: O preço deve ser maior que zero.");
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String novoNome) {
        if (novoNome == null || novoNome.isEmpty()) {
            System.out.println("Erro: O novo nome não pode ser nulo!");
        }else {
            this.nome = novoNome; // altera o nome
        }
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double novoPreco) {
        if (novoPreco > 0){
            this.preco = novoPreco;
        }else {
            System.out.println("Erro: O novo preço é inválido! Valor antigo continua mantido.");
        }
    }

    public void exibirDadosProduto(){
        System.out.println(id);
        System.out.println(nome);
        System.out.println(preco);
    }

    @Override
    public String toString() {
        return nome + " (R$ " + String.format("%.2f", preco) + ")";
    }
}