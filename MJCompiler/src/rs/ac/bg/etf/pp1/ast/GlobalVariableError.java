// generated with ast extension for cup
// version 0.8
// 16/0/2021 21:30:43


package rs.ac.bg.etf.pp1.ast;

public class GlobalVariableError extends GlobalVariable {

    public GlobalVariableError () {
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
        buffer.append("GlobalVariableError(\n");

        buffer.append(tab);
        buffer.append(") [GlobalVariableError]");
        return buffer.toString();
    }
}
