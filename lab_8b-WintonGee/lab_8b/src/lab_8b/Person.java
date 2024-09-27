package lab_8b;

import java.util.ArrayList;
import java.util.List;


public class Person {
	
	public enum GENDER {
        MALE, FEMALE, NONBINARY
    }


    String name;
    int age;
    GENDER gender;
    String emailAddress;
    
    Person(String name, int age, GENDER gender, String emailAddress) {
    	this.name=name;
    	this.age=age;
    	this.gender = gender;
    	this.emailAddress = emailAddress;
    }
    
    public int getAge() {
        return age;
    }
    
    public String getName() {
    	return name;
    }
    
    public void setAge(int age) {
    	this.age = age;
    }

    public void printPerson() {
        System.out.println(name + ", "+age+", "+gender+ ", "+emailAddress);
    }
    
    public GENDER getGender() {
    	return gender;
    }
    
    public String getEmailAddress() {
    	return emailAddress;
    }
}