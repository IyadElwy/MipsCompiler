package Program;

public class IInstructionMemory {
    private final int indexOutput;
    private final int offset;
    private final int addressRegister;

    public IInstructionMemory(String indexOutput, String offset, String addressRegister) {
        this.indexOutput = Engine.getRegisterIndex(indexOutput);
        this.offset = Integer.parseInt(offset);
        this.addressRegister = Engine.getRegisterIndex(addressRegister);
    }


    public int getIndexOutput() {
        return indexOutput;
    }

    public int getOffset() {
        return offset;
    }

    public int getAddressRegister() {
        return addressRegister;
    }
}
