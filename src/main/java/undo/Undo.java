package undo;

import vehicles.Command;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public final class Undo {

    private static Undo instance = null;
    private final List<Command> commands = new ArrayList<>();
    private Undo(){}

    public static void addCommand(Command command) {
        if (instance == null)
            instance = new Undo();

        instance.commands.add(command);

    }

    /**
     * It executes de Undo operation removing the last command added.
     * @return an Optional containing the last command or empty if there is no last command.
     */
    public static Optional<Command> exec() {
        if (instance == null || instance.commands.isEmpty())
            return Optional.empty();

        return Optional.of(instance.commands.removeLast());

    }

    static Undo getInstance() {
        if (instance == null)
            instance = new Undo();

        return instance;

    }

    public static List<Command> history(int n) {
        if (instance == null)
            instance = new Undo();

        if (instance.commands.size() < n)
            return instance.commands;

        return instance.commands.subList(instance.commands.size() - n, n);

    }

    @Override
    public String toString() {
        return commands.toString();
    }

}
