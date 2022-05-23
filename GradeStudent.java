import java.util.Scanner;

/**
 * GradeStudent
 */
public class GradeStudent {
    // Create global variable
    static int midWeight;
    static int finalWeight;
    static int homeworkWeight;
    static double midWeightedScore;
    static double finalWeightedScore;
    static double homeworkWeightedScore;
    public static void main(String[] args) {

        // Create Scanner
        Scanner console = new Scanner(System.in);

        // Call methods
        System.out.println(begin());;
        midTerm(console);
        finalTerm(console);
        homework(console);
        report();
    }

    // Create "begin" method
    public static String begin() {
        return "This program reads exam/homework scores and reports your overall course grade.\n";
    }
    
    // Create "midTerm" method
    public static void midTerm(Scanner console) {
        System.out.println("Midterm:");

        // Get data from user input
        System.out.print("Weight (0-100)? ");
        midWeight = console.nextInt();

        System.out.print("Score earned? ");
        int scoreEarned = console.nextInt();

        System.out.print("Were scores shifted (1 = yes, 2 = no)? ");
        int scoreShifted = console.nextInt();

        int shiftAmount = 0;
        if (scoreShifted == 1) {
            System.out.print("Shift amount? ");
            shiftAmount = console.nextInt();
        }

        // Print result to screen
        int totalPoints = scoreEarned + shiftAmount;
        if (totalPoints > 100) {
            totalPoints = 100;
        }
        System.out.println("Total points = " + totalPoints + " / 100");

        double weightedScoreRaw = ((double)(totalPoints) / 100) * (double)(midWeight);
        midWeightedScore = Math.round(weightedScoreRaw * 100.0) / 100.0;
        System.out.println("Weighted score = " + midWeightedScore + " / " + midWeight + "\n");
    }

    // Create "Final" method
    public static void finalTerm(Scanner console) {
        System.out.println("Final:");

        // Get data from user input
        System.out.print("Weight (0-100)? ");
        finalWeight = console.nextInt();

        System.out.print("Score earned? ");
        int scoreEarned = console.nextInt();

        System.out.print("Were scores shifted (1 = yes, 2 = no)? ");
        int scoreShifted = console.nextInt();

        int shiftAmount = 0;
        if (scoreShifted == 1) {
            System.out.print("Shift amount? ");
            shiftAmount = console.nextInt();
        }

        // Print result to screen
        int totalPoints = scoreEarned + shiftAmount;
        if (totalPoints > 100) {
            totalPoints = 100;
        }
        System.out.println("Total points = " + totalPoints + " / 100");

        double weightedScoreRaw = ((double)(totalPoints) / 100) * (double)(finalWeight);
        finalWeightedScore = Math.round(weightedScoreRaw * 100.0) / 100.0;
        System.out.println("Weighted score = " + finalWeightedScore + " / " + finalWeight + "\n");
    }

    // Create "homework" method
    public static void homework(Scanner console) {
        System.out.println("Homework:");

        // Get data from user input
        System.out.print("Weight (0-100)? ");
        homeworkWeight = console.nextInt();
        
        // Loop: total weight = 100
        while (midWeight + finalWeight + homeworkWeight != 100) {
            System.out.print("Please re-input (Total Weight: Midterm + Final + Homework must be 100): ");
            homeworkWeight = console.nextInt();
        }

        System.out.print("Number of assignments? ");
        int numOfAsm = console.nextInt();

        int scoreAsm = 0;
        int maxAsm = 0;
        for (int i = 1; i <= numOfAsm; i++) {
            System.out.print("Assignment " + i + " score and max? ");
            scoreAsm += console.nextInt();
            maxAsm += console.nextInt();
        }
        if (scoreAsm > 150) {
            scoreAsm = 150;
        }
        if (maxAsm > 150) {
            maxAsm = 150;
        }
        
        System.out.print("How many sections did you attend? ");
        int sections = console.nextInt();
        int sectionPoints = sections * 5;
        if (sectionPoints > 30) {
            sectionPoints = 30;
        }
        System.out.println("Section points = " + sectionPoints + " / 30");

        int totalPoints = scoreAsm + sectionPoints;
        int maxTotalPoints = maxAsm + 30;
        System.out.println("Total points = " + totalPoints + " / " + maxTotalPoints);

        double weightedScoreRaw = (double)(totalPoints) / (double)(maxTotalPoints) * (double)(homeworkWeight);
        homeworkWeightedScore = Math.round(weightedScoreRaw * 10.0) / 10.0;
        System.out.println("Weighted score = " + homeworkWeightedScore + " / " + homeworkWeight + "\n");
    }

    // Create "report" method
    public static void report() {
        double minGrade = midWeightedScore + finalWeightedScore + homeworkWeightedScore;
        System.out.println("Overall percentage = " + minGrade);

        double GPA;
        if (minGrade >= 85) {
            GPA = 3.0;
            System.out.println("You are Very Good");
        } else if (minGrade >= 75 && minGrade < 85) {
            GPA = 2.0;
            System.out.println("You are Good");
        } else if (minGrade >= 60 && minGrade < 75) {
            GPA = 1.0;
            System.out.println("You are Fairly Good");
        } else {
            GPA = 0.0;
            System.out.println("You are Average");
        }
        System.out.println("Your grade will be at least: " + GPA);
    }
}