package ar.com.integradorbackend.repository;

import java.time.LocalDate;

import ar.com.integradorbackend.orador.Orador;

/**
 * MainOradorRepository
 */
public class MainOradorRepository {

    public static void main(String[] args) {
        OradorRepository repository = new MySQLOradorRepository();

        Orador newOrador = new Orador("marcelo", "lopez", "email@gmail", "C#", LocalDate.now());
        repository.save(newOrador);
        System.out.println(newOrador);
    }
}
