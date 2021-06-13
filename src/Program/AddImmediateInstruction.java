package Program;

public class AddImmediateInstruction extends IInstruction {

    public AddImmediateInstruction(String indexOutput, String indexOp1, String immediate) {
        super(indexOutput, indexOp1, immediate);
    }

    public void calculate() {
        Engine.register[super.getIndexOutput()].setCurrentValue(
                Engine.register[super.getIndexOp1()].getCurrentValue() +
                        super.getImmediate());
    }

}
