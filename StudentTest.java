package itcs371.ict.mahidol.ac.th;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Calendar;

class StudentTest {
    Student stu;

    @BeforeEach
    void setUp() {
        stu = new Student("Wudhichart", "Sawangphol", "99999999", 1986);
    }

    @AfterEach
    void tearDown() {
    }

    @ParameterizedTest(name = "TestDisplayName for {2}")
    @CsvSource({ "Wudhichart,Sawangphol,Wudhichart Sawangphol", "Morakot,    Choetkiertikul,   Morakot Choetkiertikul",
            "Chaiyong,  Ragkhitwetsagul, Chaiyong Ragkhitwetsagul"

    })

    void getDisplayNames(String firstName, String lastName, String expectedResult) {
        Student stu1 = new Student(firstName, lastName, "9999999", 1986);
        assertEquals(expectedResult, stu1.getDisplayName(), firstName + " " + lastName + "should be " + expectedResult);
    }

    @Test
    void getDisplayName() {
        String displayName = stu.getDisplayName();
        assertEquals("Wudhichart Sawangphol", displayName);
    }

    @ParameterizedTest(name = "TestGetAge")
    @CsvSource({ "1998,21", "1999,20", "2000,19" })

    void getAges(String birthYear, String expectedAge) {
        Student stu = new Student("firstname", "lastname", "99999", Integer.parseInt(birthYear));
        assertEquals(Integer.parseInt(expectedAge), stu.getAge(), "age should be " + expectedAge);
    }

    @Test
    void getAge() {
        int age = stu.getAge();
        int targetAge = Calendar.getInstance().get(Calendar.YEAR) - 1986;
        assertEquals(targetAge, age);
    }
}
