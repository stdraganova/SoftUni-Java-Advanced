package JavaAdvanced.SetsAndMapsAdvanced;

import java.util.*;

public class AverageStudentsGradesWithMaps {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfStudents = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> studentsGrades = new TreeMap<>();

        for (int student = 0; student < numberOfStudents; student++) {
            String input = scanner.nextLine();
            String studentName = input.split("\\s+")[0];
            double grade = Double.parseDouble(input.split("\\s+")[1]);

            studentsGrades.putIfAbsent(studentName, new ArrayList<>());
            List<Double> grades = studentsGrades.get(studentName);
            grades.add(grade);

            studentsGrades.put(studentName,grades);
        }

        for (String student : studentsGrades.keySet()){

            System.out.printf("%s -> ",student);
            for (double grade : studentsGrades.get(student)){
                System.out.printf("%.2f ", grade);
            }
             averageGrade(studentsGrades.get(student));
        }
    }

    private static void averageGrade(List<Double> grades) {
        double averageGrade = 0;

        for (double grade : grades){
            averageGrade += grade;
        }

        averageGrade = averageGrade / grades.size();
        System.out.printf("(avg: %.2f)%n",averageGrade);
    }
}
