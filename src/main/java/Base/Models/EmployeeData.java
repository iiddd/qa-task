package Base.Models;

import java.util.Objects;

/**
 * This class is used to store EmployeeData properties in object.
 */

public class EmployeeData {

    private String firstName;
    private String lastName;
    private String startDate;
    private String email;

    //region setters
    public EmployeeData setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public EmployeeData setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public EmployeeData setStartDate(String startDate) {
        this.startDate = startDate;
        return this;
    }

    public EmployeeData setEmail(String email) {
        this.email = email;
        return this;
    }
    //endregion

    //region getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEmail() {
        return email;
    }
    //endregion

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeData that = (EmployeeData) o;
        return Objects.equals(getFirstName(), that.getFirstName()) &&
                Objects.equals(getLastName(), that.getLastName()) &&
                Objects.equals(getStartDate(), that.getStartDate()) &&
                Objects.equals(getEmail(), that.getEmail());
    }
}
