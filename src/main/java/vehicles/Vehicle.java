package vehicles;

sealed public abstract class Vehicle permits Bike, Car, Plane, Ship {

    public final Command run;
    public final Command stop;
    public final Command accelerate;

    Vehicle(Builder<?> builder) {
        this.run = builder.run;
        this.stop = builder.stop;
        this.accelerate = builder.accelerate;
    }

    abstract static class Builder<T extends Builder<T>>{

        private Command run = () -> System.out.println("Running...");
        private Command stop = () -> System.out.println("Stopping...");
        private Command accelerate = () -> System.out.println("Accelerating...");

        protected abstract T self();

        public T run(Command run) {
            this.run = run;
            return self();
        }

        public T stop(Command stop) {
            this.stop = stop;
            return self();
        }

        public T accelerate(Command accelerate) {
            this.accelerate = accelerate;
            return self();
        }

        abstract Vehicle build();

    }

}
