package Program;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Controller {
    @FXML
    private Button runButton;
    @FXML
    private Button helpButton;
    @FXML
    private Button exitButton;
    @FXML
    private Button clearConsoleButton;
    @FXML
    private TextArea codeEditor;
    @FXML
    private TextArea consoleOutput;

    public static String outPut = "";

    @FXML
    public void exitProgram() {
        System.exit(0);
    }

    @FXML
    public void clearConsole() {
        consoleOutput.setText("");
    }

    @FXML
    public void showHelp() {
        consoleOutput.setText("This is the format of mips code the user has to " +
                "follow: \nADDI $t0,$t2,200\n\nSupported Instructions:\n-ADD" +
                "\n-ADDI\n-SUB\n-LW\n-SW\n-BEQ\n\nBy Iyad Elwy -5000256\n");
    }

    @FXML
    public void runCode() throws IOException {
//        TODO: Change back 'txt source' to original
        MainExecution run = new MainExecution("C:\\Users\\iyade\\IdeaProjects\\Java" +
                "\\MasterClass\\MipsCompiler\\src\\Program\\program.txt");
        try {
            String text = "";
            File myObj = new File("C:\\Users\\iyade\\IdeaProjects\\Java\\" +
                    "MasterClass\\MipsCompiler\\src\\Program\\program.txt");
            FileWriter fileWriter = new FileWriter(myObj, true);
            BufferedWriter bw = new BufferedWriter(fileWriter);

            bw.write(getCode());
            bw.flush();
            bw.close();

        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        run.runProgram();
        printNonEmpty(Engine.register);
        printNonEmptyMemory();
        consoleOutput.setText(outPut);
        clearFile();
    }

    private String getCode() {
        return codeEditor.getText();
    }

    private void clearFile() throws IOException {
        File myObj = new File("C:\\Users\\iyade\\IdeaProjects\\Java\\" +
                "MasterClass\\MipsCompiler\\src\\Program\\program.txt");
        FileWriter fileWriter = new FileWriter(myObj);
        BufferedWriter bw = new BufferedWriter(fileWriter);

        bw.write("");
        bw.flush();
        bw.close();
    }

    public static void printNonEmpty(Register[] array) {
        outPut = outPut + ("\n--------Instruction Start---------\n");
        for (int i = 0; i < 25; i++) {
            if (Engine.register[i].getCurrentValue() != -100 && Engine.register[i].getCurrentValue() != 0) {
                outPut = outPut + ("Register " + Engine.register[i].getName() + " " +
                        "has " + "value: " + Engine.register[i].getCurrentValue() + "\n");
            }
        }
        outPut = outPut + ("--------Instruction Done---------\n");
    }

    public static void printNonEmptyMemory() {
        outPut = outPut + ("\n********Memory Data Start***********\n");
        for (int i = 0; i < Engine.memory.length; i++) {
            if (Engine.memory[i] != -100) {
                outPut = outPut + ("Value " + Engine.memory[i] + " at address " + i + " " +
                        "in memory." + "\n");
            }
        }
        outPut = outPut + ("********Memory Data Done***********\n");
    }

}
