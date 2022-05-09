package br.com.allangf.compras.graphql;

import br.com.allangf.compras.domain.Produto;
import com.coxautodev.graphql.tools.GraphQLResolver;
import org.springframework.stereotype.Component;

@Component
public class ProdutoResolver implements GraphQLResolver<Produto> {

    public String valorReais(Produto produto) {
        return "R$"+produto.getValor();
    }
}