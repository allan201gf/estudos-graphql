package br.com.allangf.compras.graphql.exception;

public class DomainException extends RuntimeException {

    public DomainException(String message) {
        super(message);
    }

}