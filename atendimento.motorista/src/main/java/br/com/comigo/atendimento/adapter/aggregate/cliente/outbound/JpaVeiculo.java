package br.com.comigo.atendimento.adapter.aggregate.cliente.outbound;

import br.com.comigo.atendimento.domain.aggregate.cliente.Veiculo;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "veiculo", schema = "atendimento")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class JpaVeiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(nullable = false)
    private String marca;

    @Column(nullable = false)
    private String modelo;

    @Column(nullable = true)
    private String cor;

    @Column(nullable = false, unique = true)
    private String placa;

    @Column(nullable = true)
    private String ano;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private JpaCliente cliente;

    public JpaVeiculo(Veiculo veiculo) {
        this.id = veiculo.getId();
        this.marca = veiculo.getMarca();
        this.modelo = veiculo.getModelo();
        this.cor = veiculo.getCor();
        this.placa = veiculo.getPlaca();
        this.ano = veiculo.getAno();
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", marca='" + getMarca() + "'" +
                ", modelo='" + getModelo() + "'" +
                ", cor='" + getCor() + "'" +
                ", placa='" + getPlaca() + "'" +
                ", ano='" + getAno() + "'" +
                "}";
    }

}