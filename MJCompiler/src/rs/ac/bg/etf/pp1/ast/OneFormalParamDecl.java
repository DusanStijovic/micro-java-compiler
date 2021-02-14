// generated with ast extension for cup
// version 0.8
// 20/0/2021 22:55:7


package rs.ac.bg.etf.pp1.ast;

public class OneFormalParamDecl extends FormalParamDeclarationList {

    private FormalParamDeclaration FormalParamDeclaration;

    public OneFormalParamDecl (FormalParamDeclaration FormalParamDeclaration) {
        this.FormalParamDeclaration=FormalParamDeclaration;
        if(FormalParamDeclaration!=null) FormalParamDeclaration.setParent(this);
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
        if(FormalParamDeclaration!=null) FormalParamDeclaration.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FormalParamDeclaration!=null) FormalParamDeclaration.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FormalParamDeclaration!=null) FormalParamDeclaration.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("OneFormalParamDecl(\n");

        if(FormalParamDeclaration!=null)
            buffer.append(FormalParamDeclaration.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [OneFormalParamDecl]");
        return buffer.toString();
    }
}
