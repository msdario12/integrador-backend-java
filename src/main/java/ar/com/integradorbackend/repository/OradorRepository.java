package ar.com.integradorbackend.repository;

import java.util.List;

import ar.com.integradorbackend.orador.Orador;

/**
 * OradorRepository
 */
public interface OradorRepository {
    public void save(Orador orador);

    public Orador getById(Long id);

    public void update(Orador orador);

    public void delete(Long id);

    public List<Orador> findAll();

}
