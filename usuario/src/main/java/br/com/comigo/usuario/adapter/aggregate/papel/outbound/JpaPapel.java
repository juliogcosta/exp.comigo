package br.com.comigo.usuario.adapter.aggregate.papel.outbound;

import br.com.comigo.usuario.domain.aggregate.papel.Papel;
import br.com.comigo.usuario.domain.util.StatusDePapel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "papel", schema = "usuario")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class JpaPapel {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", updatable = false, nullable = false)
        private Long id;

        @Column(nullable = false)
        private String nome;

        @Enumerated(EnumType.STRING)
        @Column(nullable = false)
        private StatusDePapel status;
        
        public JpaPapel(Papel papel) {
                this.nome = papel.getNome();
                this.status = StatusDePapel.ATIVO;
        }

        @Override
        public String toString() {
                return "{" +
                                " id='" + getId() + "'" +
                                ", nome='" + getNome() + "'" +
                                ", status='" + getStatus() + "'" +
                                "}";
        }

}