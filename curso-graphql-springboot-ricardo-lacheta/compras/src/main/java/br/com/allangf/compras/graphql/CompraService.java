package br.com.allangf.compras.graphql;

import br.com.allangf.compras.domain.Cliente;
import br.com.allangf.compras.domain.Compra;
import br.com.allangf.compras.domain.CompraRepository;
import br.com.allangf.compras.graphql.dto.CompraResumo;
import br.com.allangf.compras.graphql.exception.DomainException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CompraService {

    @Autowired
    private CompraRepository compraRepository;

    public Compra findById(Long id) {
        return compraRepository.findById(id).orElse(null);
    }

    public List<Compra> findAll(Pageable pageable) {
        return compraRepository.findAll(pageable).getContent();
    }

    @Transactional
    public Compra save(Compra c) {
        if(c.getQuantidade() > 100) {
            throw new DomainException("Não é possível fazer uma compra com mais de 100 items");
        }
        return compraRepository.save(c);
    }

    @Transactional
    public boolean deleteById(Long id) {
        if(compraRepository.findById(id).isPresent()) {
            compraRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Compra> findAllByCliente(Cliente cliente) {
        return compraRepository.findAllByCliente(cliente.getId());
    }

    public List<CompraResumo> findAllComprasRelatorio() {
        return compraRepository.findAllComprasRelatorio();
    }
}