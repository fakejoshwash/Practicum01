import java.util.Scanner;

public class SafeInput {
    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String retString = "";
        do {
            System.out.print("\n" + prompt + ": ");
            retString = pipe.nextLine();
        } while(retString.length() == 0);
        return retString;
    }

    public static int getInt(Scanner pipe, String prompt) {
        int retInt = -1;        // if it somehow errors out it'll just spew -1
        boolean isInt = false;
        do {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextInt()) {
                retInt = pipe.nextInt();
                isInt = true;
            } else {
                isInt = false;
            }
            pipe.nextLine();
        } while(!isInt);
        return retInt;
    }

    public static double getDouble(Scanner pipe, String prompt) {
        double retDouble = -1;
        boolean isDouble = false;
        do {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextDouble()) {
                retDouble = pipe.nextDouble();
                isDouble = true;
            } else {
                isDouble = false;
            }
            pipe.nextLine();
        } while(!isDouble);
        return retDouble;
    }
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int retInt = -1;
        boolean isValid = false;
        do {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextInt()) {
                retInt = pipe.nextInt();
                if (retInt <= high && retInt >= low) {
                    isValid = true;
                }
                else {
                    System.out.println("Input out of range...");
                }
            }
            else {
                isValid = false;
            }
            pipe.nextLine();
        } while(!isValid);
        return retInt;
    }

    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {
        double retDouble = -1;
        boolean isValid = false;
        do {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextDouble()) {
                retDouble = pipe.nextDouble();
                if (retDouble <= high && retDouble >= low) {
                    isValid = true;
                }
                else {
                    System.out.println("Input out of range...");
                }
            }
            else {
                isValid = false;
            }
            pipe.nextLine();
        } while(!isValid);
        return retDouble;
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        boolean retBoo = false;
        boolean isValid = false;
        String answer;
        do {
            System.out.print("\n" + prompt + ": ");
            answer = pipe.nextLine();
            if (answer.equalsIgnoreCase("Y")) {
                retBoo = true;
                isValid = true;
            } else if (answer.equalsIgnoreCase("N")) {
                retBoo = false;
                isValid = true;
            } else {
                System.out.println("Invalid response...");
            }
        } while(!isValid);
        return retBoo;
    }

    public static String getRegExString(Scanner pipe, String prompt, String regEx) {
        boolean isValid = false;
        String answer;
        do {
            System.out.print("\n" + prompt + ": ");
            answer = pipe.nextLine();
            if (answer.equals(regEx)) {
                isValid = true;
            } else {
                System.out.println("Invalid response...");
                isValid = false;
            }
        } while(!isValid);
        return answer;
    }
    public static void prettyHeader(String msg) {
        double lengthRemain = 54 - msg.length();
        for (int x = 1; x <= 60; x++) {
            System.out.print("*");
        }
        System.out.print("\n***");
        for (int x = 1; x <= 54; x++) {
            System.out.print(" ");
        }
        System.out.print("***\n***");
        for (int x = 1; x <= lengthRemain / 2; x++) {
            System.out.print(" ");
        }
        System.out.print(msg);
        for (int x = 1; x <= lengthRemain / 2; x++) {
            System.out.print(" ");
        }
        System.out.print("***\n***");
        for (int x = 1; x <= 54; x++) {
            System.out.print(" ");
        }
        System.out.print("***\n");
        for (int x = 1; x <= 60; x++) {
            System.out.print("*");
        }
    }
}