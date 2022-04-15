package kg.itschool.megacom;

import kg.itschool.megacom.builder.MentorBuilder;
import kg.itschool.megacom.dao.DaoContext;
import kg.itschool.megacom.dao.MentorDao;
import kg.itschool.megacom.model.Mentor;

import java.time.LocalDate;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Mentor mentor1 = MentorBuilder.builder()
                .firstname("NODIR")
                .lastName("UMAROV")
                .phoneNumber("+99999999999")
                .email("umarov@gmail.com")
                .dob(LocalDate.parse("1995-05-05"))
                .salary(100000.0)
                .build();

        MentorDao mentorDao = (MentorDao) DaoContext.autowired("MentorDao", "singleton");

        Optional<Mentor> mentorFromDB = mentorDao.save(mentor1);

        System.out.println(mentor1);
        System.out.println(mentorFromDB);
    }
}
