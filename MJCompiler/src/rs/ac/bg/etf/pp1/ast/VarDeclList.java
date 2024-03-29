// generated with ast extension for cup
// version 0.8
// 20/0/2021 22:55:7


package rs.ac.bg.etf.pp1.ast;

public class VarDeclList extends VariableDeclarationList {

    private VariableDeclarationList VariableDeclarationList;
    private VariableDeclaration VariableDeclaration;

    public VarDeclList (VariableDeclarationList VariableDeclarationList, VariableDeclaration VariableDeclaration) {
        this.VariableDeclarationList=VariableDeclarationList;
        if(VariableDeclarationList!=null) VariableDeclarationList.setParent(this);
        this.VariableDeclaration=VariableDeclaration;
        if(VariableDeclaration!=null) VariableDeclaration.setParent(this);
    }

    public VariableDeclarationList getVariableDeclarationList() {
        return VariableDeclarationList;
    }

    public void setVariableDeclarationList(VariableDeclarationList VariableDeclarationList) {
        this.VariableDeclarationList=VariableDeclarationList;
    }

    public VariableDeclaration getVariableDeclaration() {
        return VariableDeclaration;
    }

    public void setVariableDeclaration(VariableDeclaration VariableDeclaration) {
        this.VariableDeclaration=VariableDeclaration;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(VariableDeclarationList!=null) VariableDeclarationList.accept(visitor);
        if(VariableDeclaration!=null) VariableDeclaration.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VariableDeclarationList!=null) VariableDeclarationList.traverseTopDown(visitor);
        if(VariableDeclaration!=null) VariableDeclaration.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VariableDeclarationList!=null) VariableDeclarationList.traverseBottomUp(visitor);
        if(VariableDeclaration!=null) VariableDeclaration.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclList(\n");

        if(VariableDeclarationList!=null)
            buffer.append(VariableDeclarationList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VariableDeclaration!=null)
            buffer.append(VariableDeclaration.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDeclList]");
        return buffer.toString();
    }
}
