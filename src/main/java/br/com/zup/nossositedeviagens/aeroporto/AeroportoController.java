package br.com.zup.nossositedeviagens.aeroporto;

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
public class AeroportoController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping("/api/aeroportos")
    @Transactional
    public ResponseEntity<?> cadastra(@RequestBody @Valid NovoAeroportoRequest request, UriComponentsBuilder uriComponentsBuilder){
        Aeroporto aeroporto = request.toModel(entityManager);
        entityManager.persist(aeroporto);
        URI location = uriComponentsBuilder.path("/api/aeroportos/{id}").buildAndExpand(aeroporto.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
