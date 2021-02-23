package br.com.zup.nossositedeviagens.companhia;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
public class NovaCompanhiaController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping("/api/companhias")
    @Transactional
    public ResponseEntity<?> criar(@RequestBody @Valid NovaCompanhiaRequest request, UriComponentsBuilder uriBuilder){
        Companhia companhia = request.toModel(entityManager);
        
        entityManager.persist(companhia);
        
        URI location = uriBuilder.path("/api/companhias/{id}").buildAndExpand(companhia.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

}
