package vehicles;

public final class Car extends Vehicle{

    static public class Builder extends Vehicle.Builder<Builder>{

        @Override
        protected Builder self() {
            return this;
        }

        @Override
        public Car build() {
            return new Car(this);
        }
    }

    Car(Builder builder) {
        super(builder);
    }

}
