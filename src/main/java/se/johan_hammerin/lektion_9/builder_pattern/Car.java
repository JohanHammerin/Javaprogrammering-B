package se.johan_hammerin.lektion_9.builder_pattern;

public class Car {

    //Attribut
    private String colour;
    private String engine;
    private int seats;

    //Constructor
    private Car(Builder builder) {
        colour = builder.colour;
        engine = builder.engine;
        seats = builder.seats;
    }

    public static class Builder {
        private String colour;
        private String engine;
        private int seats;

        public Builder colour(String colour) {
            this.colour = colour;
            return this;
        }

        public Builder engine(String engine) {
            this.engine = engine;
            return this;
        }

        public Builder seats(int seats) {
            this.seats = seats;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }
}
