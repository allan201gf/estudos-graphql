package br.com.allangf.compras.graphql;

import br.com.allangf.compras.domain.Produto;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProdutoGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private ProdutoService produtoService;

    public Produto produto(Long id) {
        return produtoService.findById(id);
    }

    public List<Produto> produtos() {
        return produtoService.findAll();
    }

    public Produto saveProduto(Produto produtoInput) {

        ModelMapper modelMapper = new ModelMapper();

        Produto produto = modelMapper.map(produtoInput, Produto.class);

        return produtoService.save(produto);
    }

    public Boolean deleteProduto(Long id) {
        return produtoService.deleteById(id);
    }

}
