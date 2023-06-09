package sda.orange.grcy.hibernateDemo;

import java.util.List;

public class HibernateDemoApp {
    public static void main(String[] args) {
        var car1 = new Car();
        //car1.setId(1); //setId tylko jeśli nie mamy ustawionej @GeneratedValue na polu z Id
        car1.setName("Ford");
        car1.setModel("Mustang");

        var car2 = new Car();
        //car2.setId(2); //setId tylko jeśli nie mamy ustawionej @GeneratedValue na polu z Id
        car2.setName("Kia");
        car2.setModel("Ceed");

        var util = new HibernateUtil();
        var factory = util.getFactory();

        try (var session = factory.openSession()) {
            var transaction = session.beginTransaction();
            session.persist(car1);
            session.persist(car2);
            transaction.commit();
        }

        System.out.println("Wylistujmy dane z bazy:");
        try (var session = factory.openSession()) {
            List<Car> carsFromDb = session.createQuery("from Car", Car.class).list();
            carsFromDb.forEach(each -> {
                System.out.println("Samochód o id = " + each.getId());
                System.out.println(each.getName() + " " + each.getModel() + "\n");
            });
        }

        System.out.println("Podmieniamy model dla Kia na Stinger");
        try (var session = factory.openSession()) {
            Car kijanka = session.get(Car.class, 2);

            /**
             * beginTransaction i transaction.commit() są niezbędne
             * żeby zmiany wprowadzone do bazy zostały w niej.
             * jeśli nie zrobimy "commit'a" to po zakończeniu sesji
             * (czyli po wyjściu z try-with-resources)
             * zmiany zostaną usunięte z bazy
             * i stan bazy będzie taki jak przed ich wprowadzeniem
             *
             * !!! UWAGA - można ustawić system tak że transakcje będą kończone automatycznie,
             * w szczególności w SPRING'u albo innych frameworkach DI
             */
            var transaction = session.beginTransaction();
            kijanka.setModel("Stinger");
            session.persist(kijanka);
            transaction.commit();
        }

        System.out.println("\nWylistujmy dane z bazy jeszcze raz:");
        try (var session = factory.openSession()) {
            List<Car> carsFromDb = session.createQuery("from Car", Car.class).list();
            carsFromDb.forEach(each -> {
                System.out.println("Samochód o id = " + each.getId());
                System.out.println(each.getName() + " " + each.getModel() + "\n");
            });
        }

        System.out.println("\nUsuniemy Mustanga");
        try (var session = factory.openSession()) {
            Car mustang = session.get(Car.class, 1);
            var transaction = session.beginTransaction();
            session.remove(mustang);
            transaction.commit();
        }

        System.out.println("\nWylistujmy dane z bazy jeszcze raz po usunięciu mustanga:");
        try (var session = factory.openSession()) {
            List<Car> carsFromDb = session.createQuery("from Car", Car.class).list();
            carsFromDb.forEach(each -> {
                System.out.println("Samochód o id = " + each.getId());
                System.out.println(each.getName() + " " + each.getModel() + "\n");
            });
        }
    }
}
