class ExceptionGenerator {

    public void triggerExceptionBasedOnInput(int conditionCode) {
        System.out.println(" -> Entering ExceptionGenerator method with code: " + conditionCode);

        if (conditionCode == 1) {
            System.out.println(" -> Initiating an arithmetic operation that divides by zero...");
            int numerator = 500;
            int denominator = 0;
            int result = numerator / denominator;

        } else if (conditionCode == 2) {
            System.out.println(" -> Initiating an array operation to access an invalid index...");
            int[] dataArray = new int[3];
            dataArray[0] = 10;
            dataArray[1] = 20;
            dataArray[2] = 30;
            int invalidAccess = dataArray[5];

        } else {
            System.out.println(" -> Condition code is safe. Executing normal operations...");
            int safeCalculation = 100 * 5;
            System.out.println(" -> Safe calculation result: " + safeCalculation);
        }
    }
}

public class Task2Main {

    public static void main(String[] args) {
        System.out.println("========== STARTING TASK 2 EXECUTION ==========");

        ExceptionGenerator generator = new ExceptionGenerator();

        int[] testScenarios = {1, 2, 0};

        for (int testValue : testScenarios) {
            System.out.println("\n--- Testing Scenario with Value: " + testValue + " ---");

            try {
                generator.triggerExceptionBasedOnInput(testValue);
                System.out.println("SUCCESS: Method executed completely without throwing any exceptions.");

            } catch (ArithmeticException arithmeticError) {
                System.out.println("EXCEPTION CAUGHT: An ArithmeticException occurred.");
                System.out.println("ERROR MESSAGE: " + arithmeticError.getMessage());

            } catch (ArrayIndexOutOfBoundsException arrayError) {
                System.out.println("EXCEPTION CAUGHT: An ArrayIndexOutOfBoundsException occurred.");
                System.out.println("ERROR MESSAGE: " + arrayError.getMessage());

            } finally {
                System.out.println("FINALLY BLOCK: The finally block happened. Resources can be cleaned up here.");
            }
        }

        System.out.println("\n========== TASK 2 EXECUTION FINISHED ==========");
    }
}