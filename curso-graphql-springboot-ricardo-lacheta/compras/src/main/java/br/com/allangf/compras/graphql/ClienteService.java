package br.com.allangf.compras.graphql;

import br.com.allangf.compras.domain.Cliente;
import br.com.allangf.compras.domain.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente findById(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Transactional
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Transactional
    public Boolean deleteById(Long id) {
        if(clienteRepository.findById(id).isPresent()) {
            clienteRepository.deleteById(id);
            return true;
        }

        return false;
    }

}
