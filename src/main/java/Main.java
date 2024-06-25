import vehicles.*;
import undo.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Vehicle> vehicles = List.of(
                new Car.Builder()
                        .run(() -> System.out.println("Running a vehicles.Car"))
                        .stop(() -> System.out.println("Stopping a vehicles.Car"))
                        .accelerate(() -> System.out.println("Accelerating a vehicles.Car"))
                        .build(),
                new Bike.Builder()
                        .run(() -> System.out.println("Running a vehicles.Bike"))
                        .stop(() -> System.out.println("Stopping a vehicles.Bike"))
                        .accelerate(() -> System.out.println("Accelerating a vehicles.Bike"))
                        .build(),
                new Plane.Builder()
                        .run(() -> System.out.println("Running a vehicles.Plane"))
                        .stop(() -> System.out.println("Stopping a vehicles.Plane"))
                        .accelerate(() -> System.out.println("Accelerating a vehicles.Plane"))
                        .build(),
                new Ship.Builder()
                        .run(() -> System.out.println("Running a vehicles.Ship"))
                        .stop(() -> System.out.println("Stopping a vehicles.Ship"))
                        .accelerate(() -> System.out.println("Accelerating a vehicles.Ship"))
                        .build()
        );

        Undo.addCommand(vehicles.getFirst().run);
        Undo.addCommand(vehicles.get(2).stop);
        Undo.addCommand(vehicles.get(3).accelerate);

        for (Command c : Undo.history(3))
            c.exec();

        Undo.exec();

        System.out.println();

        for (Command c : Undo.history(3))
            c.exec();

    }
}
