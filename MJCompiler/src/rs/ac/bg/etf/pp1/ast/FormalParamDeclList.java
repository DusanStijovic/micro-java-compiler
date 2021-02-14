// generated with ast extension for cup
// version 0.8
// 20/0/2021 22:55:7


package rs.ac.bg.etf.pp1.ast;

public class FormalParamDeclList extends FormalParamDeclarationList {

    private FormalParamDeclarationList FormalParamDeclarationList;
    private FormalParamDeclaration FormalParamDeclaration;

    public FormalParamDeclList (FormalParamDeclarationList FormalParamDeclarationList, FormalParamDeclaration FormalParamDeclaration) {
        this.FormalParamDeclarationList=FormalParamDeclarationList;
        if(FormalParamDeclarationList!=null) FormalParamDeclarationList.setParent(this);
        this.FormalParamDeclaration=FormalParamDeclaration;
        if(FormalParamDeclaration!=null) FormalParamDeclaration.setParent(this);
    }

    public FormalParamDeclarationList getFormalParamDeclarationList() {
        return FormalParamDeclarationList;
    }

    public void setFormalParamDeclarationList(FormalParamDeclarationList FormalParamDeclarationList) {
        this.FormalParamDeclarationList=FormalParamDeclarationList;
    }

    public FormalParamDeclaration getFormalParamDeclaration() {
        return FormalParamDeclaration;
    }

    public void setFormalParamDeclaration(FormalParamDeclaration FormalParamDeclaration) {
        this.FormalParamDeclaration=FormalParamDeclaration;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(FormalParamDeclarationList!=null) FormalParamDeclarationList.accept(visitor);
        if(FormalParamDeclaration!=null) FormalParamDeclaration.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FormalParamDeclarationList!=null) FormalParamDeclarationList.traverseTopDown(visitor);
        if(FormalParamDeclaration!=null) FormalParamDeclaration.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FormalParamDeclarationList!=null) FormalParamDeclarationList.traverseBottomUp(visitor);
        if(FormalParamDeclaration!=null) FormalParamDeclaration.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FormalParamDeclList(\n");

        if(FormalParamDeclarationList!=null)
            buffer.append(FormalParamDeclarationList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FormalParamDeclaration!=null)
            buffer.append(FormalParamDeclaration.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FormalParamDeclList]");
        return buffer.toString();
    }
}
