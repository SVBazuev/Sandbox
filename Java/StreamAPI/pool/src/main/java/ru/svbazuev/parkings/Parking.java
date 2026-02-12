package ru.svbazuev.parkings;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.util.List;
import java.util.Objects;

@JsonDeserialize(builder = Parking.Builder.class)
public class Parking {
    private final int id;
    private final String companyName;
    private final String location;
    private final int numberSpaces;
    private final int freeSpaces;
    private final List<Car> cars;

    private Parking(Builder builder) {
        this.id = builder.id;
        this.companyName = builder.companyName;
        this.location = builder.location;
        this.numberSpaces = builder.numberSpaces;
        this.freeSpaces = builder.freeSpaces;
        this.cars = builder.cars;
    }

    public int getId() { return id; }
    public String getCompanyName() { return companyName; }
    public String getLocation() { return location; }
    public int getNumberSpaces() { return numberSpaces; }
    public int getFreeSpaces() { return freeSpaces; }
    public List<Car> getCars() { return cars; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parking parking = (Parking) o;
        return id == parking.id &&
               numberSpaces == parking.numberSpaces &&
               freeSpaces == parking.freeSpaces &&
               Objects.equals(companyName, parking.companyName) &&
               Objects.equals(location, parking.location) &&
               Objects.equals(cars, parking.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, companyName, location, numberSpaces, freeSpaces, cars);
    }

    @Override
    public String toString() {
        return String.format("Parking{id=%d, company='%s', location='%s', spaces=%d, free=%d, cars=%d}",
                id, companyName, location, numberSpaces, freeSpaces, cars.size());
    }

    @JsonPOJOBuilder(withPrefix = "")
    public static class Builder {
        private int id;
        private String companyName;
        private String location;
        private int numberSpaces;
        private int freeSpaces;
        private List<Car> cars;

        @JsonCreator
        public Builder() {}

        @JsonProperty("id")
        public Builder id(int id) { this.id = id; return this; }

        @JsonProperty("companyName")
        public Builder companyName(String companyName) { this.companyName = companyName; return this; }

        @JsonProperty("location")
        public Builder location(String location) { this.location = location; return this; }

        @JsonProperty("numberSpaces")
        public Builder numberSpaces(int numberSpaces) { this.numberSpaces = numberSpaces; return this; }

        @JsonProperty("freeSpaces")
        public Builder freeSpaces(int freeSpaces) { this.freeSpaces = freeSpaces; return this; }

        @JsonProperty("cars")
        public Builder cars(List<Car> cars) { this.cars = cars; return this; }

        public Parking build() { return new Parking(this); }
    }
}
