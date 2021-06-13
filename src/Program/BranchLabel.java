package Program;

public class BranchLabel {
    private final String labelName;
    private int LabelPosition;

    public BranchLabel(String labelName) {
        this.labelName = labelName;
    }

    public String getLabelName() {
        return labelName;
    }

    public int getLabelPosition() {
        return LabelPosition;
    }

    public void setLabelPosition(int labelPosition) {
        LabelPosition = labelPosition;
    }
}
