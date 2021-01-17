// generated with ast extension for cup
// version 0.8
// 16/0/2021 21:30:43


package rs.ac.bg.etf.pp1.ast;

public class ConstVarClassDeclList extends ConstVarClassDeclarationList {

    private ConstVarClassDeclarationList ConstVarClassDeclarationList;
    private ConstVarClassDeclaration ConstVarClassDeclaration;

    public ConstVarClassDeclList (ConstVarClassDeclarationList ConstVarClassDeclarationList, ConstVarClassDeclaration ConstVarClassDeclaration) {
        this.ConstVarClassDeclarationList=ConstVarClassDeclarationList;
        if(ConstVarClassDeclarationList!=null) ConstVarClassDeclarationList.setParent(this);
        this.ConstVarClassDeclaration=ConstVarClassDeclaration;
        if(ConstVarClassDeclaration!=null) ConstVarClassDeclaration.setParent(this);
    }

    public ConstVarClassDeclarationList getConstVarClassDeclarationList() {
        return ConstVarClassDeclarationList;
    }

    public void setConstVarClassDeclarationList(ConstVarClassDeclarationList ConstVarClassDeclarationList) {
        this.ConstVarClassDeclarationList=ConstVarClassDeclarationList;
    }

    public ConstVarClassDeclaration getConstVarClassDeclaration() {
        return ConstVarClassDeclaration;
    }

    public void setConstVarClassDeclaration(ConstVarClassDeclaration ConstVarClassDeclaration) {
        this.ConstVarClassDeclaration=ConstVarClassDeclaration;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConstVarClassDeclarationList!=null) ConstVarClassDeclarationList.accept(visitor);
        if(ConstVarClassDeclaration!=null) ConstVarClassDeclaration.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstVarClassDeclarationList!=null) ConstVarClassDeclarationList.traverseTopDown(visitor);
        if(ConstVarClassDeclaration!=null) ConstVarClassDeclaration.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstVarClassDeclarationList!=null) ConstVarClassDeclarationList.traverseBottomUp(visitor);
        if(ConstVarClassDeclaration!=null) ConstVarClassDeclaration.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstVarClassDeclList(\n");

        if(ConstVarClassDeclarationList!=null)
            buffer.append(ConstVarClassDeclarationList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstVarClassDeclaration!=null)
            buffer.append(ConstVarClassDeclaration.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstVarClassDeclList]");
        return buffer.toString();
    }
}
