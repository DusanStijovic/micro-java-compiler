// generated with ast extension for cup
// version 0.8
// 5/0/2021 22:4:16


package rs.ac.bg.etf.pp1.ast;

public class ConstVarType extends ConstType {

    private Integer assignedValue;

    public ConstVarType (Integer assignedValue) {
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
        buffer.append("ConstVarType(\n");

        buffer.append(" "+tab+assignedValue);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstVarType]");
        return buffer.toString();
    }
}
