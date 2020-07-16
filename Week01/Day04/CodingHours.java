import javax.xml.bind.SchemaOutputResolver;
import java.text.DecimalFormat;

public class CodingHours {
    public static void main(String[] args) {
        int semester = 17;
        int dailyCodingHours = 6;
        int codingPerAttendee;
        codingPerAttendee = semester * 5 * dailyCodingHours;
        System.out.println("Hours: " + codingPerAttendee);
        int weeklyWorkHours = 52;
        int semesterWorkHours;
        semesterWorkHours = semester * weeklyWorkHours;
        float percentage;
        float codingPerAttendeeF =codingPerAttendee;
        float semesterWorkHoursF = semesterWorkHours;
        percentage = (codingPerAttendeeF/semesterWorkHoursF)*100;
        DecimalFormat df = new DecimalFormat("##.##");
        System.out.println("Percentage of coding hours: " + df.format(percentage)+"%");
    }
}
