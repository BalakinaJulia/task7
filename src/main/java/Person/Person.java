package Person;

import java.io.Serializable;
import java.util.Objects;

//import com.fasterxml.jackson.annotation.JsonCreator;
//import com.fasterxml.jackson.annotation.JsonGetter;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonSetter;
//import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
//import com.fasterxml.jackson.databind.annotation.JsonSerialize;
//
//import java.time.LocalDate;
//import java.util.Objects;
//@JsonSerialize(using = PersonSerializer.class)
//@JsonDeserialize(using = PersonDeserializer.class)
//public class Person {
//    private String name;
//    private String surname;
//    private String patronymic;
//
//    @JsonIgnore
//    private String fullName;
//    @JsonIgnore
//    private boolean fullNameChanged = true;
//    private LocalDate birthdate;//текущая дата
//    public Person(String name, String surname, String patronymic,
//                  LocalDate birthdate) {
//        setName(name);
//        setSurname(surname);
//        setPatronymic(patronymic);
//        setFullName();
//        setBirthdate(birthdate);
//    }
//     public Person(String name, String surname, String patronymic, String birthdate) {
//            this(name, surname, patronymic, LocalDate.parse(birthdate));
//        }
//
//    @JsonCreator
//    public Person(String mahler, String gustav, LocalDate of) {
//    }
//    @JsonGetter("name")
//    public String getName() {
//        return name;
//    }
//    @JsonSetter("name")
//    public void setName(String name) {
//        if (name == null) {
//            throw new IllegalArgumentException("name == null");
//        }
//        if (name.length() == 0) {
//            throw new IllegalArgumentException("name cannot be blank");
//        }
//
//        this.name = name;
//        fullNameChanged = true;
//    }
//
//    @JsonSetter("surname")
//    public String getSurname() {
//        return surname;
//    }
//    @JsonSetter("surname")
//    public void setSurname(String surname) {
//        if (name == null) {
//            throw new IllegalArgumentException("name == null");
//        }
//        if (name.length() == 0) {
//            throw new IllegalArgumentException("name cannot be blank");
//        }
//
//        this.surname = surname;
//        fullNameChanged = true;
//    }
//
//
//    @JsonSetter("patronymic")
//    public String getPatronymic() {
//        return patronymic;
//    }
//    @JsonSetter("patronymic")
//    public void setPatronymic(String patronymic) {
//        if (name == null) {
//            throw new IllegalArgumentException("name == null");
//        }
//        if (name.length() == 0) {
//            throw new IllegalArgumentException("name cannot be blank");
//        }
//
//        this.patronymic = patronymic;
//        fullNameChanged = true;
//    }
//
//
//
//    public String getFullName() {
//        setFullName();
//        return fullName;
//    }
//    private void setFullName() {
//        if (fullNameChanged) {
//            if (patronymic.length() == 0) {
//                fullName = String.format(
//                        "%s %s", name, surname);
//            }
//            else {
//                fullName = String.format(
//                        "%s %s %s", name, surname, patronymic);
//            }
//
//            fullNameChanged = false;
//        }
//    }
//
//    public LocalDate getBirthdate() {
//        return birthdate;
//    }
//
//    public void setBirthdate(LocalDate birthdate) {
//        if (birthdate == null) {
//            throw new IllegalArgumentException("birthdate == null");
//        }
//
//        this.birthdate = birthdate;
//    }
//
//    @JsonGetter("birthdate")
//    public String getBirthdateString() {
//        return birthdate.toString();
//    }
//
//    @JsonSetter("birthdate")
//    public void setBirthdateString(String birthdateString) {
//        if (birthdateString == null) {
//            throw new IllegalArgumentException("birthdateString == null");
//        }
//
//        this.birthdate = LocalDate.parse(birthdateString);
//    }
//
//    @JsonIgnore
//    public int getBirthdateDay() {
//        return birthdate.getDayOfMonth();
//    }
//
//    @JsonIgnore
//    public int getBirthdateMonth() {
//        return birthdate.getMonthValue();
//    }
//
//    @JsonIgnore
//    public int getBirthdateYear() {
//        return birthdate.getYear();
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o)
//            return true;
//        if (o == null || getClass() != o.getClass())
//            return false;
//        Person person = (Person) o;
//        return Objects.equals(name, person.name)
//                && Objects.equals(surname, person.surname)
//                && Objects.equals(patronymic, person.patronymic)
//                && Objects.equals(birthdate, person.birthdate);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(name, surname, patronymic, birthdate);
//    }
//}
//
public class Person implements Serializable {
    private String lastName;
    private String firstName;
    private String middleName;
    private String fullName;
    private boolean fullNameChanged = true;
    //    private LocalDate birthdate;
    private String birthdate;


    public Person(){
        setLastName("Иванов");
        setFirstName("Иван");
        setMiddleName("Иванович");
        setFullName();
        setBirthdate("10.01.2000");
    }

    public Person(String lastName, String firstName, String middleName,
                  String birthdate) {
        setLastName(lastName);
        setFirstName(firstName);
        setMiddleName(middleName);
        setFullName();
        setBirthdate(birthdate);
    }

    public Person(String lastName, String firstName,
                  String birthdate) {
        this(lastName, firstName, "", birthdate);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null) {
            throw new IllegalArgumentException("lastName == null");
        }
        if (lastName.length() == 0) {
            throw new IllegalArgumentException("lastName cannot be blank");
        }

        this.lastName = lastName;
//        fullNameChanged = true;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName == null) {
            throw new IllegalArgumentException("firstName == null");
        }
        if (firstName.length() == 0) {
            throw new IllegalArgumentException("firstName cannot be blank");
        }

        this.firstName = firstName;
        fullNameChanged = true;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        if (middleName == null) {
            throw new IllegalArgumentException("middleName == null");
        }

        this.middleName = middleName;
        fullNameChanged = true;
    }

    public String getFullName() {
        setFullName();
        return fullName;
    }

    private void setFullName() {
        if (fullNameChanged) {
            if (middleName.length() == 0) {
                fullName = String.format(
                        "%s %s", lastName, firstName);
            }
            else {
                fullName = String.format(
                        "%s %s %s", lastName, firstName, middleName);
            }

            fullNameChanged = false;
        }
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        if (birthdate == null) {
            throw new IllegalArgumentException("birthdate == null");
        }

        this.birthdate = birthdate;
    }

    public String getBirthdateString() {
        return birthdate.toString();
    }

    public void setBirthdateString(String birthdateString) {
        if (birthdateString == null || birthdateString.isEmpty()) {
            throw new IllegalArgumentException("birthdateString == null || birthdateString is empty");
        }

//        this.birthdate = LocalDate.parse(birthdateString);
        this.birthdate = birthdateString;
    }

//    public int getBirthdateDay() {
//        return birthdate.getDayOfMonth();
//    }

//    public int getBirthdateMonth() {
//        return birthdate.getMonthValue();
//    }

//    public int getBirthdateYear() {
//        return birthdate.getYear();
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Person person = (Person) o;
        return Objects.equals(lastName, person.lastName)
                && Objects.equals(firstName, person.firstName)
                && Objects.equals(middleName, person.middleName)
                && Objects.equals(birthdate, person.birthdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName, middleName, birthdate);
    }
}