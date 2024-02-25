import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;
import java.util.Scanner;

public class StudentDA
{
    public StudentDA() {

        try {
            Scanner inputFile = new Scanner(new FileReader("C:\\Users\\Chryzle\\IdeaProjects\\exercise7\\src\\student.csv"));
            //read the header file
            inputFile.nextLine();
            while (inputFile.hasNext()){
                String lineData = new String();
                lineData = inputFile.nextLine();
                String[] splitData = new String[3];
                splitData = lineData.split(",");

                Student student = new Student();

                student.setStudentNumber(splitData[0].trim());
                student.setLastName(splitData[1].trim());
                student.setFirstName(splitData[2].trim());

                CourseDA courseDA = new  CourseDA(student.getStudentNumber());

                // hashmap
                student.setCourseMap(courseDA.getCourseMap());
                // average grade
                Double counter = 0.0;
                Double gradeTotal;
                gradeTotal = 0.0;
                Double averageGrade = 0.0;
                for (Map.Entry<String, Course> entryMap: student.getCourseMap().entrySet()){
                        gradeTotal += entryMap.getValue().getGrade();
                        counter++;
                    }
                averageGrade = gradeTotal / counter;
                student.setAverageGrade(averageGrade);

                // print  the report
                System.out.println("Student Number: " + student.getStudentNumber());
                System.out.println("Student Name: " + student.getLastName() + ", " + student.getFirstName());
                System.out.println("Student Average Grade: " + student.getAverageGrade());
                System.out.println("--------- Details of the grade ------");
                System.out.println("Course code\tDescription\tUnit\tGrade");

                for(Map.Entry<String, Course> courseMap: student.getCourseMap().entrySet()){
                    System.out.println(courseMap.getValue().getCourseCode() + "\t");
                    System.out.println(courseMap.getValue().getDescription() + "\t");
                    System.out.println(courseMap.getValue().getUnit() + "\t");
                    System.out.println(courseMap.getValue().getGrade());
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
