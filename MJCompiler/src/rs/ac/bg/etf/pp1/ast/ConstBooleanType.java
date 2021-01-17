// generated with ast extension for cup
// version 0.8
// 16/0/2021 21:30:43


package rs.ac.bg.etf.pp1.ast;

public class ConstBooleanType extends ConstType {

    private String assignedValue;

    public ConstBooleanType (String assignedValue) {
        this.assignedValue=assignedValue;
    }

    public String getAssignedValue() {
        return assignedValue;
    }

    public void setAssignedValue(String assignedValue) {
        this.assignedValue=assignedValue;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstBooleanType(\n");

        buffer.append(" "+tab+assignedValue);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstBooleanType]");
        return buffer.toString();
    }
}
