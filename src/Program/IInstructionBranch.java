package Program;

public class IInstructionBranch {
    private final int valReg1;
    private final int valReg2;
    private BranchLabel label;

    public IInstructionBranch(String valReg1, String valReg2, BranchLabel label) {
        this.valReg1 = Engine.getRegisterIndex(valReg1);
        this.valReg2 = Engine.getRegisterIndex(valReg2);
        this.label = label;
    }


    public int getValReg1() {
        return valReg1;
    }

    public int getValReg2() {
        return valReg2;
    }

    public BranchLabel getLabel() {
        return label;
    }

}
