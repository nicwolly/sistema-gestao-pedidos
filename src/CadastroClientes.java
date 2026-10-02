import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CadastroClientes {
    private List<Cliente> clientes;

    public CadastroClientes() {
        this.clientes = new ArrayList<>();
    }
    public void cadastrar(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException(
                    "Erro: não pode ficar nulo"
            );
        }
        Optional<Cliente> clienteEncontrado = buscarPorId(cliente.getId());
         if (clienteEncontrado.isPresent()){
             throw new IdDuplicadoException(
                     "Erro: já existe cliente cadastrado com esse ID."
             );
        }
        this.clientes.add(cliente);
    }

    public Optional<Cliente> buscarPorId(int id){
        for (Cliente cliente : clientes){
            if (cliente.getId() == id){
                return Optional.of(cliente);
            }
        }
        return Optional.empty();
    }



    public List<Cliente> listarClientes() {
        return new ArrayList<>(clientes);
    }

    public boolean removerPorId(int id){
        Optional<Cliente> clienteEncontrado = buscarPorId(id);

        if (clienteEncontrado.isPresent()) {
            clientes.remove(clienteEncontrado.get());
            return true;
        }
        return false;
    }
}
