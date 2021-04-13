/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author eliel
 */
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {
    
    @Id
    @NotNull(message = "O nome de usuario não pode ser nulo")
    @NotBlank(message = "O nome do usuário deve ser informado.")
    @Length(max = 20, message = "O nome de usuário não pode ter mais que {max} caracteres.")
    @Column(name = "nome_usuario", length = 20, nullable = false)
    private String nomeUsuario;
    
    @NotBlank(message = "A senha deve ser informada.")
    @Length(max = 20, message = "A senha não pode ter mais que {max} caracteres.")
    @Column(name = "senha", length = 20, nullable = false)
    private String senha;
    
    @NotBlank(message = "O nome deve ser informado.")
    @Length(max = 50, message = "O nome não pode ter mais qe {max} caracteres.")
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;
    
    @Email(message = "O e-mail deve ser válido.")
    @NotBlank(message = "O e-mail deve ser informado.")
    @Length(max = 50, message = "O e-mail não pode ter mais qe {max} caracteres.")
    @Column(name = "email", length = 50, nullable = false)
    private String email;
    
    @NotNull(message = "O campo ativo deve ser informado.")
    @Column(name = "ativo", nullable = false)
    private Boolean ativo;
    
    @Temporal(TemporalType.DATE)
    @NotNull(message = "A data de cadastro deve ser informada.")
    @Column(name = "data_cadastro", nullable = false)
    private Calendar dataCadastro;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "permissoes",
            joinColumns = @JoinColumn(name = "nome_usuario", referencedColumnName = "nome_usuario", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "permissao", referencedColumnName = "nome", nullable = false))
    private Set<Permissao> permissoes = new HashSet<>();

    public Usuario() {
        this.dataCadastro = Calendar.getInstance();
    }
    
    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Calendar getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Calendar dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
    
    public Set<Permissao> getPermissoes() {
        return permissoes;
    }

    public void setPermissoes(Set<Permissao> permissoes) {
        this.permissoes = permissoes;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.nomeUsuario);
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
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.nomeUsuario, other.nomeUsuario)) {
            return false;
        }
        return true;
    }
    
    
    
}
