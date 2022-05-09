package br.com.allangf.compras.graphql;

import br.com.allangf.compras.domain.Cliente;
import br.com.allangf.compras.domain.ClienteInput;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClienteGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private ClienteService clienteService;

    public Cliente cliente(Long id) {
        return clienteService.findById(id);
    }

    public List<Cliente> clientes() {
        return clienteService.findAll();
    }

    public Cliente saveCliente(ClienteInput clienteInput) {
//        Cliente cliente = new Cliente();
//        cliente.setId(clienteInput.getId());
//        cliente.setEmail(clienteInput.getEmail());
//        cliente.setNome(clienteInput.getNome());

        ModelMapper modelMapper = new ModelMapper();

        Cliente cliente = modelMapper.map(clienteInput, Cliente.class);

        return clienteService.save(cliente);
    }

    public Boolean deleteCliente(Long id) {
        return clienteService.deleteById(id);
    }

}
