// generated with ast extension for cup
// version 0.8
// 20/0/2021 22:55:7


package rs.ac.bg.etf.pp1.ast;

public class NoMethodLocalVariableDecl extends OptionalMethodsLocalVariablesDeclaration {

    public NoMethodLocalVariableDecl () {
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
        buffer.append("NoMethodLocalVariableDecl(\n");

        buffer.append(tab);
        buffer.append(") [NoMethodLocalVariableDecl]");
        return buffer.toString();
    }
}
