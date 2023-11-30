package ar.com.integradorbackend.repository;

import java.time.LocalDate;
import java.util.List;

import ar.com.integradorbackend.orador.Orador;

/**
 * MainOradorRepository
 */
public class MainOradorRepository {

    public static void main(String[] args) {
        OradorRepository repository = new MySQLOradorRepository();

        // Orador newOrador = new Orador("marcelo", "lopez", "email@gmail", "C#",
        // LocalDate.now());
        // repository.save(newOrador);
        // System.out.println(newOrador);
        Orador foundedOrador = repository.getById(1L);
        System.out.println(foundedOrador);
        // repository.delete(12L);
        // foundedOrador.setName("Ignacio");
        // repository.update(foundedOrador);
        List<Orador> list = repository.findAll();
        System.out.println(list);
    }
}
