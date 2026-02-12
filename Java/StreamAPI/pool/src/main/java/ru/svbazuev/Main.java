package ru.svbazuev;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import ru.svbazuev.parkings.Parking;
import ru.svbazuev.parkings.Car;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;


public class Main {

    public static void main(String[] args) throws Exception {

        List<Parking> parkings = new ObjectMapper().readValue(
            new File("./src/main/resources/parkings.json"),
            new TypeReference<List<Parking>>() {}
        );

        //TODO List<Car> redCars = parkings.stream()
    }
}
