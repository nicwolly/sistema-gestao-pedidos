import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private int id;
    private String nome;
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente(int id, String nome, String email) {
        this.id = id;
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException(
                    "Erro: O nome do cliente é obrigatório!"
            );
        }else {
            this.nome = nome;
        }

        if (email == null || email.isEmpty()){
            throw new IllegalArgumentException(
                    "Erro: O e-mail é obrigatório!"
            );
        }else {
            this.email = email;
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String novoNome) {
        if (novoNome == null || novoNome.isEmpty()){
            throw new IllegalArgumentException(
                    "Erro: O novo nome não pode estar nulo!"
            );
        }else {
            this.nome = novoNome;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String novoEmail) {
        if (novoEmail == null || novoEmail.isEmpty()){
            throw new IllegalArgumentException(
                    "Erro: O novo e-mail não pode estar nulo!"
            );
        }else {
            this.email = novoEmail;
        }
    }

    public void exibirDadosCliente(){
        System.out.println(id);
        System.out.println(nome);
        System.out.println(email);
    }

    @Override
    public String toString() {
        return nome + " \nE-mail: (" + email + ")";
    }
}