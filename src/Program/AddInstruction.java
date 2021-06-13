package Program;

public class AddInstruction extends RInstruction {

    public AddInstruction(String indexOutput, String indexOp1, String indexOp2) {
        super(indexOutput, indexOp1, indexOp2);
    }

    public void calculate() {
        Engine.register[super.getIndexOutput()].setCurrentValue(
                Engine.register[super.getIndexOp1()].getCurrentValue() +
                        Engine.register[super.getIndexOp2()].getCurrentValue());

    }


}
