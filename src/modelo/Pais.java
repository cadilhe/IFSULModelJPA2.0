/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author sigaln
 */

@Entity
@Table(name = "tbl_pais")
public class Pais implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Length(max = 50, message = "O nome só pode ter até 50 caracteres.")
    @NotBlank(message = "O campo nome não pode ficar em branco.")
    @NotNull(message = "O nome é obrigatório")
    private String nome;
    @Length(max = 3, message = "O nome só pode ter até 50 caracteres.")
    @NotBlank(message = "O campo ISO não pode ficar em branco.")
    @NotNull(message = "O ISO não pode ser nulo")
    private String iso;
    
        
    // Getters e Setters
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIso() {
        return iso;
    }

    public void setIso(String iso) {
        this.iso = iso;
    }
    
    // Equals() e HashCode() para tornar cada objeto único

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pais other = (Pais) obj;
        return Objects.equals(this.id, other.id);
    }
    
    
    
}
