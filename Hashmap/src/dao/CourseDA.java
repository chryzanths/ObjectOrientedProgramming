package dao;

import domain.Course;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;
public class CourseDA
{


    public class CourseDA {
        private HashMap<String, Course> courseMap ;

        public HashMap<String, Course> getCourseMap() {
            return courseMap;
        }

        public void setCourseMap(HashMap<String, Course> courseMap) {
            this.courseMap = courseMap;
        }

        public CourseDA(String studentNumber) {

            try {
                Scanner gradeInput = new Scanner(new FileReader("src/com/oop/cs1/exer7/grades.csv"));
                courseMap = new HashMap<String, Course>();

                //read the header text
                gradeInput.nextLine();
                Integer key = 0;
                while (gradeInput.hasNext()) {

                    String gradeLineData = new String();
                    gradeLineData = gradeInput.nextLine();
                    String[] gradeSplitData = new String[3];
                    gradeSplitData = gradeLineData.split(",");

                    if (studentNumber.equals(gradeSplitData[0].trim())) {
                        //debug
                        //System.out.println("Student number: " + gradeSplitData[0].trim());
                        Course course = new Course();
                        course.setCourseCode(gradeSplitData[1].trim());
                        course.setGrade(Double.parseDouble(gradeSplitData[2]));

                        //debug
                        //System.out.println("Course code: " + course.getCourseCode());
                        //System.out.println("Grade: " + course.getGrade());

                        Scanner courseInput = new Scanner(new FileReader("src/com/oop/cs1/exer7/courseData.csv"));
                        //read the header text
                        courseInput.nextLine();

                        while (courseInput.hasNext()) {

                            String courseLineData = new String();
                            courseLineData = courseInput.nextLine();
                            String[] courseSplitData = new String[3];
                            courseSplitData = courseLineData.split(",");

                            if (course.getCourseCode().equals(courseSplitData[0].trim())) {
                                course.setDescription(courseSplitData[1].trim());
                                course.setUnit(Integer.parseInt(courseSplitData[2].trim()));

                                courseMap.put(studentNumber+key, course);
                                key++;


                            }

                        }

                    }

                }

            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
}
