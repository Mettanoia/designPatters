package vehicles;

public final class Ship extends Vehicle{

    static public class Builder extends Vehicle.Builder<Builder>{

        @Override
        protected Builder self() {
            return this;
        }

        @Override
        public Ship build() {
            return new Ship(this);
        }
    }

    Ship(Builder builder) {
        super(builder);
    }

}
