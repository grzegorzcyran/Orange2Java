package sda.orange.grcy.hibernateDemo;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Żeby klasa była "oznaczona" jako "encja" - czyli odwzorowanie tabeli w bazie danych
 * to konieczne jest nałożenie dwóch anotacji:
 * @Entity - na klasę - mówimy wtedy że klasa to encja
 * @Id - na pole które będziemy traktować jako identyfikator
 *
 * !!! Hibernate wymaga konstruktora bezparametrowego więc
 * jeśli mamy w klasie inny konstruktor to trzeba utworzyć też
 * bezparametrowy na potrzeby Hibernate
 */

@Setter
@Getter
@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String model;
}
