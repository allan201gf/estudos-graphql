package br.com.allangf.compras.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteInput {

    private Long id;
    private String nome;
    private String email;

}
