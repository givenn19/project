import java.util.Scanner;
import java.util.ArrayList;

public class App {

    private static boolean isValidCourse(String str){
        String regex = "^[a-zA-Z]{4} \\d{3}$";
        if (str.matches(regex)) return true;
        return false;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Grade Calculator started.");

        ArrayList<String> courseDatabase = new ArrayList<String>();
        Scanner reader = new Scanner(System.in);

        while(true) {
            // GET COURSE
            System.out.print("Enter course: ");
            String course = reader.nextLine();

            // VALIDATE COURSE
            if (!isValidCourse(course)) {
                System.out.println("Please enter a valid course.");
                continue;
            } 
            else{
                // SEARCH course database for course
                if (!courseDatabase.contains(course)) {
                    System.out.print("Course not found. Add " + course + " to course database? (Y/N): ");
                    
                    String input = reader.nextLine();

                    while (!input.equalsIgnoreCase("Y") && !input.equalsIgnoreCase("N")) {
                        System.out.print("Invalid input. Try again (Y/N): ");
                        input = reader.nextLine();
                    }

                    if (input.equalsIgnoreCase("N")) {
                        System.out.println("Course not added.");
                        continue;
                    } else {
                        courseDatabase.add(course);
                        System.out.println(course + " added to course database.");
                    }

                }
                
                System.out.println("Course located.");
                
            }

            break;
        }

        reader.close();

    }
}