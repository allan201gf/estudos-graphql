package br.com.allangf.compras.domain;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CompraInput {

    private Long id;
    private Integer quantidade;
    private String status;
    private Long clienteId;
    private Long produtoId;
}