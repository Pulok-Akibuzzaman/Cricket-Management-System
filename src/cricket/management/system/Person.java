/*
Group Members:
Muin Hossain
Id:2023-3-60-059
Fayaza Islam                 
Id:2023-3-60-314  
Pulok Akibuzzaman
ID: 2023-3-60-051
*/

package cricket.management.system;

import java.time.LocalDate;

public abstract class Person {
    private int age;
    private String name;
    private LocalDate birthdate;

    // Default Constructor
    Person() {}

    // Parameterized Constructor
    Person(String name, int age, LocalDate birthdate) {
        this.name = name;
        this.age = age;
        this.birthdate = birthdate;
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for age
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative.");
        }
        this.age = age;
    }

    // Getter and Setter for birthdate
    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        if (birthdate.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Birthdate cannot be in the future.");
        }
        this.birthdate = birthdate;
    }

    // Abstract method for subclasses to implement
    public abstract String toString();
}
