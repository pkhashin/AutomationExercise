package com.ecommerce.utils;

import com.github.javafaker.Faker;

public class FakerUtil {

    private static final Faker faker = new Faker();

    public static String getFirstName() {
        return faker.name().firstName();
    }

    public static String getLastName() {
        return faker.name().lastName();
    }

    public static String day () {
        return String.valueOf(faker.number().numberBetween(1, 29));
    }

    public static String year() {
        return String.valueOf(faker.number().numberBetween(1980, 2024));
    }
    public static String getCompany() {
        return faker.company().name();
    }
    public static String getAddress() {
        return faker.address().streetAddress();
    }
    public static String getAddress1() {
        return faker.address().secondaryAddress();
    }
    public static String getAddress2() {
        return faker.address().streetAddress();
    }
    public static String getCountry() {
        return faker.address().country();
    }
    public static String getState() {
        return faker.address().state();
    }
    public static String getCity() {
        return faker.address().city();
    }
    public static String getZipCode() {
        return faker.address().zipCode();
    }
    public static String getMobileNumber() {
        return faker.phoneNumber().cellPhone();
    }

    public static String getName() {
        return faker.name().fullName();
    }

    public static String getEmail() {
        return faker.internet().emailAddress();
    }

}


