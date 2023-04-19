package edu.eci.cvds;

import javax.persistence.*;
import java.util.*;
@Entity
@Table(name = "CONFIGURATION")
public class Guess {
    @Id
    @Column(name = "PROPIEDAD")
    private String id;
    @Column(name = "VALOR")
    private String valor;

    public Guess(String id, String valor) {
        this.id = id;
        this.valor = valor;
    }

    public Guess() {

    }
    public void setId(String propiedad) {
        this.id = propiedad;
    }

    public String getId() {
        return id;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "ConfigutationB{" +
                "propiedad='" + id + '\'' +
                ", valor='" + valor + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Guess that = (Guess) o;
        return Objects.equals(id, that.id) && Objects.equals(valor, that.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, valor);
    }
}