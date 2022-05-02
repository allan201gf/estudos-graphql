package br.com.allangf.compras;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

@Component
public class QueryGraphQL implements GraphQLQueryResolver {

    public String hello() {
        return "Hello GraphQL";
    }

    public int soma(int a, int b) {
        return a+b;
    }

    public Cliente cliente() {
        return new Cliente("Allan", "allan201gf@gmail.com");
    }

}
