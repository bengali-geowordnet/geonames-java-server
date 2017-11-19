package edu.aiub.cs.geonames.model.base;

import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

import static edu.aiub.cs.geonames.utility.Constants.CD_ID_LENGTH;

/**
 * Created by Sk Golam Muhammad Hasnain on 10/19/17.
 */

/*CREATE TABLE `user` (
        `userId` int(11) NOT NULL,
        `userName` varchar(200) NOT NULL,
        `userType` varchar(200) NOT NULL,
        `fullName` varchar(200) NOT NULL,
        `dateOfBirth` date NOT NULL,
        `gender` varchar(100) NOT NULL,
        `address` varchar(500) NOT NULL,
        `contactNumber` int(11) NOT NULL,
        `age` int(11) NOT NULL,
        `country` varchar(100) NOT NULL,
        `education` varchar(300) NOT NULL
        ) ENGINE=InnoDB DEFAULT CHARSET=latin1;*/

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userId")
    private int userId;

    @NotNull
    @Length(max = 200)
    @Column(name = "name")
    private String name;

    @NotNull
    @Length(max = 200)
    @Column(name = "type")
    private String type;

    @NotNull
    @Length(max = 200)
    @Column(name = "fullName")
    private String fullName;

    @NotNull
    @Column(name = "dateOfBirth")
    private String dateOfBirth;

    @NotNull
    @Length(max = 100)
    @Column(name = "gender")
    private String gender;

    @NotNull
    @Length(max = 500)
    @Column(name = "address")
    private String address;

    @NotNull
    @Length(max = 13)
    @Column(name = "phone", length = 13)
    private String phone;

    @NotNull
    @Column(name = "age")
    private int age;

    @NotNull
    @Length(max = 100)
    @Column(name = "country")
    private String country;

    @NotNull
    @Length(max = 300)
    @Column(name = "education")
    private String education;

    public User() {
    }

    public User(String name, String type, String fullName, String dateOfBirth, String gender, String address,
                String phone, int age, String country, String education) {
        this.name = name;
        this.type = type;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.address = address;
        this.phone = phone;
        this.age = age;
        this.country = country;
        this.education = education;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }
}
