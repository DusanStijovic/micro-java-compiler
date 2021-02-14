// generated with ast extension for cup
// version 0.8
// 20/0/2021 22:55:7


package rs.ac.bg.etf.pp1.ast;

public class ConstDeclList extends ConstList {

    private ConstList ConstList;
    private ConstVariableAssginment ConstVariableAssginment;

    public ConstDeclList (ConstList ConstList, ConstVariableAssginment ConstVariableAssginment) {
        this.ConstList=ConstList;
        if(ConstList!=null) ConstList.setParent(this);
        this.ConstVariableAssginment=ConstVariableAssginment;
        if(ConstVariableAssginment!=null) ConstVariableAssginment.setParent(this);
    }

    public ConstList getConstList() {
        return ConstList;
    }

    public void setConstList(ConstList ConstList) {
        this.ConstList=ConstList;
    }

    public ConstVariableAssginment getConstVariableAssginment() {
        return ConstVariableAssginment;
    }

    public void setConstVariableAssginment(ConstVariableAssginment ConstVariableAssginment) {
        this.ConstVariableAssginment=ConstVariableAssginment;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConstList!=null) ConstList.accept(visitor);
        if(ConstVariableAssginment!=null) ConstVariableAssginment.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstList!=null) ConstList.traverseTopDown(visitor);
        if(ConstVariableAssginment!=null) ConstVariableAssginment.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstList!=null) ConstList.traverseBottomUp(visitor);
        if(ConstVariableAssginment!=null) ConstVariableAssginment.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstDeclList(\n");

        if(ConstList!=null)
            buffer.append(ConstList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstVariableAssginment!=null)
            buffer.append(ConstVariableAssginment.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstDeclList]");
        return buffer.toString();
    }
}
