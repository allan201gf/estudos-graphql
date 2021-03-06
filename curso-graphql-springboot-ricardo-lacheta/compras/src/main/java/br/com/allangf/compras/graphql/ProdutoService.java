package br.com.allangf.compras.graphql;

import br.com.allangf.compras.domain.Produto;
import br.com.allangf.compras.domain.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto findById(Long id) {
        return produtoRepository.findById(id).orElse(null);
    }

    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    @Transactional
    public Produto save(Produto produto) {
        return produtoRepository.save(produto);
    }

    @Transactional
    public Boolean deleteById(Long id) {
        if(produtoRepository.findById(id).isPresent()) {
            produtoRepository.deleteById(id);
            return true;
        }

        return false;
    }

}
