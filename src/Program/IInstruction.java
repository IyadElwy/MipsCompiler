package Program;

public class IInstruction {
    private final int indexOutput;
    private final int indexOp1;
    private final int immediate;

    public IInstruction(String indexOutput, String indexOp1, String immediate) {
        this.indexOutput = Engine.getRegisterIndex(indexOutput);
        this.indexOp1 = Engine.getRegisterIndex(indexOp1);
        this.immediate = Integer.parseInt(immediate);
    }


    public int getIndexOutput() {
        return indexOutput;
    }

    public int getIndexOp1() {
        return indexOp1;
    }

    public int getImmediate() {
        return immediate;
    }
}
