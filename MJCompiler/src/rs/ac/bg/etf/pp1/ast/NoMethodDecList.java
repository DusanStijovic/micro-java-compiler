// generated with ast extension for cup
// version 0.8
// 20/0/2021 22:55:7


package rs.ac.bg.etf.pp1.ast;

public class NoMethodDecList extends MethodDeclarationList {

    public NoMethodDecList () {
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
        buffer.append("NoMethodDecList(\n");

        buffer.append(tab);
        buffer.append(") [NoMethodDecList]");
        return buffer.toString();
    }
}
