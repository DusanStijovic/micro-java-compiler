// generated with ast extension for cup
// version 0.8
// 16/0/2021 21:30:43


package rs.ac.bg.etf.pp1.ast;

public class ConstIntType extends ConstType {

    private Integer assignedValue;

    public ConstIntType (Integer assignedValue) {
        this.assignedValue=assignedValue;
    }

    public Integer getAssignedValue() {
        return assignedValue;
    }

    public void setAssignedValue(Integer assignedValue) {
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
        buffer.append("ConstIntType(\n");

        buffer.append(" "+tab+assignedValue);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstIntType]");
        return buffer.toString();
    }
}
