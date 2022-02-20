import java.util.Scanner;
public class FractionCalculator {
    public static final Scanner input = new Scanner(System.in);

    public static void main(String[] args){
        while(true){
            Fraction input1 = getFraction();
            Fraction input2 = getFraction();
            String operation = getOperation(); //enter operation
            Fraction output = new Fraction(1,1); //declare a variable


            if (operation.equals("-")) {
                output = input1.subtract(input2);
            } else if (operation.equals("*")) {
                output = input1.multiply(input2);
            } else if (operation.equals("/")) {
                output = input1.divide(input2);
            } else {
                output = input1.add(input2);
            }

            output.toLowestTerms(); //lower fraction
            if(output.getDenom() == 1){
                int outInt = output.getNumer();
                System.out.println(input1.toString() + " " + operation + " " + input2.toString() + " = " + outInt);
                continue;
            }
            System.out.println(input1.toString() + " " + operation + " " + input2.toString() + " = " + output);
        }
    }

    public static String getOperation(){
        System.out.print("Please enter an operation +, -, /, *, Q to quit: ");
        String operation = input.nextLine();

        while(!operation.equals("+") && !operation.equals("-") && !operation.equals("/") && !operation.equals("*") && !operation.equalsIgnoreCase("q")){
            System.out.print("Invalid input +, -, /, *, Q to quit: ");
            operation = input.nextLine();
        }
        if (operation.equalsIgnoreCase("q")) {
            System.exit(0); //exit
        }
        return operation;
    }


    public static boolean validFraction(String input) {
        if (input.contains("/")) {
            String[] inputParts = input.split("/"); // inputParts[0] = num, inputParts[1] = denom
            if (inputParts[0].matches("-?\\d+") && inputParts[1].matches("-?\\d+")) { //check 4 integer
                if (Integer.parseInt(inputParts[1]) > 0) {
                    return true;
                } else {
                    return false; //negative denominator
                }
            } else {
                return false;
            }
        } else {
            if (input.matches("-?\\d+")) {
                return true;
            } else { //non integer
                return false;
            }
        }
    }

    public static Fraction getFraction(){
        System.out.print("Enter a/b fraction or integer a: ");
        String inputData = input.nextLine();

        while(!validFraction(inputData)){
            System.out.print("Invalid fraction(-s)");
            inputData = input.nextLine();
        }

        if(inputData.contains("/")){
            String[] inputPart = inputData.split("/"); //convert to integer
            int numInput = Integer.parseInt(inputPart[0]);
            int denInput = Integer.parseInt(inputPart[1]);
            return new Fraction(numInput, denInput);
        } else{
            return new Fraction(Integer.parseInt(inputData), 1);
        }
    }
}
