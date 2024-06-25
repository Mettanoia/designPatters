package vehicles;

public final class Plane extends Vehicle{

    static public class Builder extends Vehicle.Builder<Builder>{

        @Override
        protected Builder self() {
            return this;
        }

        @Override
        public Plane build() {
            return new Plane(this);
        }
    }

    Plane(Builder builder) {
        super(builder);
    }

}
