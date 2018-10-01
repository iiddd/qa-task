package base.models;

import base.utils.RandomUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class is used to build EmployeeData object with specified or default values
 */

public class EmployeeDataBuilder {

    private static final int RANDOM_COUNT = 6;
    private static final String DATE_PATTERN = "yyyy-MM-dd";

    private String firstName = String.format("AM_fName%s", RandomUtils.getRandomAlphaNumeric(RANDOM_COUNT));
    private String lastName = String.format("AM_LName%s", RandomUtils.getRandomAlphaNumeric(RANDOM_COUNT));
    private String startDate = getCurrentDate();
    private String email = RandomUtils.getRandomEmail();

    public EmployeeDataBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public EmployeeDataBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public EmployeeDataBuilder setStartDate(String startDate) {
        this.startDate = startDate;
        return this;
    }

    public EmployeeDataBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    private String getCurrentDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_PATTERN);
        Date date = new Date();
        return dateFormat.format(date);
    }

    public EmployeeData build() {
        {
            return new EmployeeData()
                    .setEmail(email)
                    .setFirstName(firstName)
                    .setLastName(lastName)
                    .setStartDate(startDate);
        }
    }
}
