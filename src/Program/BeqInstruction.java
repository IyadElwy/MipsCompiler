package Program;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BeqInstruction extends IInstructionBranch {


    public BeqInstruction(String valReg1, String valReg2, BranchLabel label) {
        super(valReg1, valReg2, label);
    }

    public static boolean checkIfEqual(String dataLine) {
        String[] parts = dataLine.split(" ");
        String[] operands = parts[1].split(",");
        BeqInstruction beqInstruction = new BeqInstruction(operands[0],
                operands[1], new BranchLabel(operands[2]));
        int val1 = Engine.register[beqInstruction.getValReg1()].getCurrentValue();
        int val2 = Engine.register[beqInstruction.getValReg2()].getCurrentValue();

        return val1 == val2;
    }

    public static boolean isBranchInstructionLine(String dataLine) {

        return dataLine.contains("BEQ");
    }

    public static int getLabelLine(String dataLine) {
        int line = 0;
        String[] parts = dataLine.split(" ");
        String[] operands = parts[1].split(",");
        String label = operands[2];
        try {
            File myObj = new File("C:\\Users\\iyade\\IdeaProjects\\Java\\" +
                    "MasterClass\\MipsCompiler\\src\\Program\\program.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                line++;
                String data = myReader.nextLine();
                if (data.contains(label) && !data.contains("BEQ")) {
                    return line;
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return 0;
    }

}
