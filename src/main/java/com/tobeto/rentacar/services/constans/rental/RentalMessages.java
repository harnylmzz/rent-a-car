package com.tobeto.rentacar.services.constans.rental;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RentalMessages {
    public static final String START_DATE_CANNOT_BE_BEFORE_TODAY = "Start date cannot be before today.";

    public static final String END_DATE_CANNOT_BE_BEFORE_THE_START_DATE = "End date cannot be before the start date.";

    public static final String RETURN_DATE_CANNOT_BE_BEFORE_THE_START_DATE = "Return date cannot be before the start date.";

    public static final String THE_RENTAL_DURATION_CANNOT_EXCEED_25_DAYS = "The rental duration cannot exceed 25 days.";

    public static final String RENTALS_LISTED = "Rentals listed";

    public static final String DATA_NOT_FOUND = "Data not found.";

    public static final String CAR_NOT_FOUND = "Car not found";

    public static final String RENTAL_ADDED = "Rental added";

    public static final String RENTAL_UPDATED = "Rental updated";

    public static final String RENTAL_DELETED = "Rental deleted";

    public static final String START_DATE_IS_MANDATORY = "Start date is mandatory";

    public static final String END_DATE_IS_MANDATORY = "End date is mandatory";

    public static final String START_KILOMETER_IS_MANDATORY = "Start kilometer is mandatory";

    public static final String TOTAL_PRICE_IS_MANDATORY = "Total price is mandatory";

    public static final String DISCOUNT_MUST_BE_GREATER_THAN_0 = "Discount must be greater than 0";

    public static final String DISCOUNT_IS_MANDATORY = "Discount is mandatory";
}
