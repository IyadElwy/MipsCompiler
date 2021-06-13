package Program;

public class RInstruction {
    private final int indexOutput;
    private final int indexOp1;
    private final int indexOp2;

    public RInstruction(String indexOutput, String indexOp1, String indexOp2) {
        this.indexOutput = Engine.getRegisterIndex(indexOutput);
        this.indexOp1 = Engine.getRegisterIndex(indexOp1);
        this.indexOp2 = Engine.getRegisterIndex(indexOp2);
    }

    public int getIndexOutput() {
        return indexOutput;
    }

    public int getIndexOp1() {
        return indexOp1;
    }

    public int getIndexOp2() {
        return indexOp2;
    }

}
