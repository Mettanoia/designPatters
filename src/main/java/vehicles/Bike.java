package vehicles;

public final class Bike extends Vehicle{

    static public class Builder extends Vehicle.Builder<Builder>{

        @Override
        protected Builder self() {
            return this;
        }

        @Override
        public Bike build() {
            return new Bike(this);
        }
    }

    Bike(Builder builder) {
        super(builder);
    }

}
