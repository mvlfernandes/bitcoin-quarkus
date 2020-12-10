package com.mvlfernandes.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.SecurityContext;

import com.mvlfernandes.model.Ordem;
import com.mvlfernandes.model.Usuario;
import com.mvlfernandes.repository.OrdemRepository;

@ApplicationScoped
public class OrdemService {

    @Inject
    OrdemRepository ordemRepository;

    public void inserir(SecurityContext securityContext, Ordem ordem) {
        Optional<Usuario> usuarioOptional = Usuario.findByIdOptional(ordem.getUserId());
        Usuario usuario = usuarioOptional.orElseThrow();
        if (!usuario.getUsername().equals(securityContext.getUserPrincipal().getName())) {
            throw new RuntimeException("O usuário logado é diferente do userId");
        }

        ordem.setData(LocalDate.now());
        ordem.setStatus("ENVIADA");
        ordemRepository.persist(ordem);
    }

    public List<Ordem> listar() {
        return ordemRepository.listAll();
    }

}
