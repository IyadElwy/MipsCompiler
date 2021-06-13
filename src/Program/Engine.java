package Program;

import java.util.Arrays;

public class Engine {
    public static int[] memory = new int[1000];
    public static Register[] register = new Register[32];

    public static void initializeArrayList() {
        register[0] = new Register("$zero", 0);
        register[1] = new Register("$at", -100);
        register[2] = new Register("$v0", -100);
        register[3] = new Register("$v1", -100);
        register[4] = new Register("$a0", -100);
        register[5] = new Register("$a1", -100);
        register[6] = new Register("$a2", -100);
        register[7] = new Register("$a3", -100);
        register[8] = new Register("$t0", -100);
        register[9] = new Register("$t1", -100);
        register[10] = new Register("$t2", -100);
        register[11] = new Register("$t3", -100);
        register[12] = new Register("$t4", -100);
        register[13] = new Register("$t5", -100);
        register[14] = new Register("$t6", -100);
        register[15] = new Register("$t7", -100);
        register[16] = new Register("$s0", -100);
        register[17] = new Register("$s1", -100);
        register[18] = new Register("$s2", -100);
        register[19] = new Register("$s3", -100);
        register[20] = new Register("$s4", -100);
        register[21] = new Register("$s5", -100);
        register[22] = new Register("$s6", -100);
        register[23] = new Register("$s7", -100);
        register[24] = new Register("$t8", -100);
        register[25] = new Register("$t9", -100);
    }


    public static void initializeEmpty(int[] array) {
        Arrays.fill(array, -100);
    }

    public static void printNonEmpty(Register[] array) {
        for (int i = 0; i < 25; i++) {
            if (register[i].getCurrentValue() != -100 && register[i].getCurrentValue() != 0) {
                System.out.println("Register " + register[i].getName() + " has " +
                        "value: " + register[i].getCurrentValue());
            }
        }

    }

    public static void printNonEmptyMemory() {
        for (int i = 0; i < memory.length; i++) {
            if (memory[i] != -100) {
                System.out.println("Value " + memory[i] + " at address " + i + " " +
                        "in memory.");
            }
        }
    }

    public static int getRegisterIndex(String registerName) {
        int result = 0;

        if (registerName.equals("$zero"))
            return 0;
        if (registerName.equals("$at"))
            return 1;

        if (registerName.equals("$v0"))
            return 2;

        if (registerName.equals("$v1"))
            return 3;

        if (registerName.equals("$a0"))
            return 4;

        if (registerName.equals("$a1"))
            return 5;

        if (registerName.equals("$a2"))
            return 6;

        if (registerName.equals("$a3"))
            return 7;

        if (registerName.equals("$t0"))
            return 8;

        if (registerName.equals("$t1"))
            return 9;

        if (registerName.equals("$t2"))
            return 10;

        if (registerName.equals("$t3"))
            return 11;

        if (registerName.equals("$t4"))
            return 12;

        if (registerName.equals("$t5"))
            return 13;

        if (registerName.equals("$t6"))
            return 14;

        if (registerName.equals("$t7"))
            return 15;

        if (registerName.equals("$s0"))
            return 16;

        if (registerName.equals("$s1"))
            return 17;

        if (registerName.equals("$s2"))
            return 18;

        if (registerName.equals("$s3"))
            return 19;

        if (registerName.equals("$s4"))
            return 20;

        if (registerName.equals("$s5"))
            return 21;

        if (registerName.equals("$s6"))
            return 22;

        if (registerName.equals("$s7"))
            return 23;

        if (registerName.equals("$t8"))
            return 24;

        if (registerName.equals("$t9"))
            return 25;

        return result;
    }

    public static void runInstruction(String instruction) {
        String[] parts = instruction.split(" ");
        String operand = parts[0];
        String[] operands = new String[4];
        try {
            operands = parts[1].split(",");
        } catch (ArrayIndexOutOfBoundsException e) {

        }


        switch (operand) {
            case "ADD":
                AddInstruction addInstruction = new AddInstruction(operands[0],
                        operands[1], operands[2]);
                addInstruction.calculate();
                break;
            case "ADDI":
                AddImmediateInstruction addImInstruction =
                        new AddImmediateInstruction(operands[0], operands[1],
                                operands[2]);
                addImInstruction.calculate();
                break;
            case "SUB":
                SubInstruction subInstruction = new SubInstruction(operands[0], operands[1],
                        operands[2]);
                subInstruction.calculate();
                break;
            case "SW":
                String offsetStore = operands[1].substring(0, 2);
                String registerWithAddressStr = operands[1].substring(3, 6);
                try {
                    Integer.parseInt(offsetStore);
                } catch (NumberFormatException e) {
                    offsetStore = operands[1].substring(0, 1);
                    registerWithAddressStr = operands[1].substring(2, 5);
                }
                StoreInstruction storeInstruction =
                        new StoreInstruction(operands[0], offsetStore,
                                registerWithAddressStr);
                break;
            case "LW":
                String offsetLoad = operands[1].substring(0, 2);
                String registerWithAddressLwd = operands[1].substring(3, 6);
                try {
                    Integer.parseInt(offsetLoad);
                } catch (NumberFormatException e) {
                    offsetLoad = operands[1].substring(0, 1);
                    registerWithAddressLwd = operands[1].substring(2, 5);
                }
                LoadInstruction loadInstruction = new LoadInstruction(operands[0],
                        offsetLoad, registerWithAddressLwd);
                break;

        }

    }
}
