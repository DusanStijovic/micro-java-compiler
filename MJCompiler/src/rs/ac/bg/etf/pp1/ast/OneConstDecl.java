// generated with ast extension for cup
// version 0.8
// 16/0/2021 21:30:43


package rs.ac.bg.etf.pp1.ast;

public class OneConstDecl extends ConstList {

    private ConstVariableAssginment ConstVariableAssginment;

    public OneConstDecl (ConstVariableAssginment ConstVariableAssginment) {
        this.ConstVariableAssginment=ConstVariableAssginment;
        if(ConstVariableAssginment!=null) ConstVariableAssginment.setParent(this);
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
        if(ConstVariableAssginment!=null) ConstVariableAssginment.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstVariableAssginment!=null) ConstVariableAssginment.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstVariableAssginment!=null) ConstVariableAssginment.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("OneConstDecl(\n");

        if(ConstVariableAssginment!=null)
            buffer.append(ConstVariableAssginment.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [OneConstDecl]");
        return buffer.toString();
    }
}
