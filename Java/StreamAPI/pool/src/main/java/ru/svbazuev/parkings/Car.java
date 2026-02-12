package ru.svbazuev.parkings;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.util.Objects;

@JsonDeserialize(builder = Car.Builder.class)
public class Car {
    private final String brand;
    private final String model;
    private final String bodyType;
    private final String color;
    private final int mileage;
    private final int manufactureYear;
    private final float rentPerDay;

    private Car(Builder builder) {
        this.brand = builder.brand;
        this.model = builder.model;
        this.bodyType = builder.bodyType;
        this.color = builder.color;
        this.mileage = builder.mileage;
        this.manufactureYear = builder.manufactureYear;
        this.rentPerDay = builder.rentPerDay;
    }

    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public String getBodyType() { return bodyType; }
    public String getColor() { return color; }
    public int getMileage() { return mileage; }
    public int getManufactureYear() { return manufactureYear; }
    public float getRentPerDay() { return rentPerDay; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return mileage == car.mileage &&
               manufactureYear == car.manufactureYear &&
               Float.compare(car.rentPerDay, rentPerDay) == 0 &&
               Objects.equals(brand, car.brand) &&
               Objects.equals(model, car.model) &&
               Objects.equals(bodyType, car.bodyType) &&
               Objects.equals(color, car.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, bodyType, color, mileage, manufactureYear, rentPerDay);
    }

    @Override
    public String toString() {
        return String.format("Car{brand='%s', model='%s', bodyType='%s', color='%s', mileage=%d, year=%d, rent=%.2f}",
                brand, model, bodyType, color, mileage, manufactureYear, rentPerDay);
    }

    @JsonPOJOBuilder(withPrefix = "")
    public static class Builder {
        private String brand;
        private String model;
        private String bodyType;
        private String color;
        private int mileage;
        private int manufactureYear;
        private float rentPerDay;

        @JsonCreator
        public Builder() {}

        @JsonProperty("brand")
        public Builder brand(String brand) { this.brand = brand; return this; }

        @JsonProperty("model")
        public Builder model(String model) { this.model = model; return this; }

        @JsonProperty("bodyType")
        public Builder bodyType(String bodyType) { this.bodyType = bodyType; return this; }

        @JsonProperty("color")
        public Builder color(String color) { this.color = color; return this; }

        @JsonProperty("mileage")
        public Builder mileage(int mileage) { this.mileage = mileage; return this; }

        @JsonProperty("manufactureYear")
        public Builder manufactureYear(int manufactureYear) { this.manufactureYear = manufactureYear; return this; }

        @JsonProperty("rentPerDay")
        public Builder rentPerDay(float rentPerDay) { this.rentPerDay = rentPerDay; return this; }

        public Car build() { return new Car(this); }
    }
}
