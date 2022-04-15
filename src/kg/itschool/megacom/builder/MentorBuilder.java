package kg.itschool.megacom.builder;

import kg.itschool.megacom.model.Mentor;

import java.time.LocalDate;

public class MentorBuilder {


    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private LocalDate dob;
    private Double salary;


    private MentorBuilder(){}

    public static MentorBuilder builder(){
        return new MentorBuilder();
    }
    public Mentor build(){
        return new Mentor(firstName, lastName, phoneNumber, email, dob, salary);
    }
    public MentorBuilder firstname(String firstName) {
        this.firstName = firstName;
        return this;
    }

        public MentorBuilder lastName(String lastName){
        this.lastName = lastName;
        return this;
    }

        public MentorBuilder phoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
        return this;
    }

         public MentorBuilder email(String email){
        this.email = email;
        return this;
    }

        public MentorBuilder dob( LocalDate dob){
        this.dob = dob;
        return this;
    }

        public MentorBuilder salary(Double salary){
        this.salary = salary;
        return this;
    }
    }


