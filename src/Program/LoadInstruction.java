package Program;

public class LoadInstruction extends IInstructionMemory {

    public LoadInstruction(String indexOutput, String offset, String addressRegister) {
        super(indexOutput, offset, addressRegister);
        int memoryLoadLocation =
                super.getOffset() + Engine.register[super.getAddressRegister()].
                        getCurrentValue();
        try {
            if (Engine.memory[memoryLoadLocation] == -100) {
                System.err.println("Can not load from " +
                        "address " + memoryLoadLocation + ". No logical value " +
                        "present. [-100]");
            }
            Engine.register[super.getIndexOutput()].setCurrentValue(Engine.memory[memoryLoadLocation]);
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Memory limit reached. Can not load from address " +
                    memoryLoadLocation + ".");
        }
    }
}
