package Program;

public class StoreInstruction extends IInstructionMemory {


    public StoreInstruction(String indexOutput, String offset, String addressRegister) {
        super(indexOutput, offset, addressRegister);
        int memoryStoreLocation =
                super.getOffset() + Engine.register[super.getAddressRegister()].
                        getCurrentValue();
        try {
            Engine.memory[memoryStoreLocation] =
                    Engine.register[super.getIndexOutput()].getCurrentValue();
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Memory limit reached. Can not store at address " +
                    memoryStoreLocation + ".");
        }
    }

}
