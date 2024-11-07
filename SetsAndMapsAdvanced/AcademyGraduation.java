package JavaAdvanced.SetsAndMapsAdvanced;

import java.math.BigDecimal;
import java.util.*;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfStudents = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> students = new TreeMap<>();

        for (int i = 0; i < numberOfStudents; i++) {
            String studentName = scanner.nextLine();
            double[] grades = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToDouble(Double::parseDouble).toArray();

            students.putIfAbsent(studentName, new ArrayList<>());
            List<Double> studentGrades = students.get(studentName);

            for (double grade : grades){
                studentGrades.add(grade);
            }

            students.put(studentName, studentGrades);
        }

        for (String student : students.keySet()){
            String averageGrade = getAverageGrade(students.get(student));
            System.out.printf("%s is graduated with %s%n", student, averageGrade);
        }
    }

    private static String getAverageGrade(List<Double> grades) {
        double averageGrade = 0;
        for (double grade : grades){
            averageGrade += grade;
        }

        averageGrade = averageGrade / grades.size();
        String roundedGrade = String.valueOf(averageGrade);

        boolean isEnd = false;
        int endIndex = 0;

        for (int i = roundedGrade.length() - 1; i >= 0 ; i++) {
            if (roundedGrade.charAt(i) != 0){
                isEnd = false;
                endIndex = i;
                break;
            }else {
                isEnd = true;
            }
        }

        if (isEnd){
           roundedGrade = roundedGrade.substring(0, endIndex + 1);
        }

        return roundedGrade;
    }
}
