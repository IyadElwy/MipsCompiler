package Program;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MainExecution {

    public String path;

    public MainExecution(String path) {
        this.path = path;
        Engine.initializeEmpty(Engine.memory);
        Engine.initializeArrayList();
        Engine.initializeArrayList();
    }

    public void runProgram() {
        int line = 0;
        try {
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);
            int lineToBranch = 0;
            while (myReader.hasNextLine()) {
                line++;

                String data = myReader.nextLine();
                if (BeqInstruction.isBranchInstructionLine(data)) {
                    if (BeqInstruction.checkIfEqual(data)) {
                        lineToBranch = BeqInstruction.getLabelLine(data) + 1;

                    }
                } else {
                    if (line >= lineToBranch) {
                        Engine.runInstruction(data);
                    }
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
