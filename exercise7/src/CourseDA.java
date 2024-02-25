import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

public class CourseDA {
    private HashMap<String, Course> courseMap = new HashMap<String, Course>();

    public HashMap<String, Course> getCourseMap() {
        return courseMap;
    }

    public void setCourseMap(HashMap<String, Course> courseMap) {
        this.courseMap = courseMap;
    }

    public CourseDA(String studentNumber) {

        try {
            Scanner gradeInput = new Scanner(new FileReader("C:\\Users\\Chryzle\\IdeaProjects\\exercise7\\src\\grades.csv"));
            //read the header file
            gradeInput.nextLine();
            while(gradeInput.hasNext()){


                String gradeLineData = new String();
                gradeLineData = gradeInput.nextLine();
                String[] gradeSplitData = new String[3];
                gradeSplitData = gradeLineData.split(",");

                if (studentNumber.equals(gradeSplitData[0].trim())) {
                    Course course = new Course();
                    course.setCourseCode(gradeSplitData[1].trim());
                    course.setGrade(Double.parseDouble(gradeSplitData[2]));

                    Scanner courseInput = new Scanner(new FileReader("C:\\Users\\Chryzle\\IdeaProjects\\exercise7\\src\\coursedata.csv"));

                    //read the header text
                    courseInput.nextLine();
                    while (courseInput.hasNext()) {
                        String courseLineData = new String();
                        courseLineData = courseInput.nextLine();
                        String[] courseSplitData = new String[3];
                        courseSplitData = courseLineData.split(",");

                        if (course.getCourseCode().equals(courseSplitData[0].trim())) {
                            // course.setCourseCode(courseSplitData[0].trim());
                            course.setDescription(courseSplitData[1].trim());
                            course.setUnit(Integer.parseInt(courseSplitData[2].trim()));

                            courseMap.put(studentNumber, course);
                        }
                    }
                    //courseMap.put(studentNumber, course);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
