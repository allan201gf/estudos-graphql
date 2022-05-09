package br.com.allangf.compras.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date data;
    private Integer quantidade;
    private String status;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

}
