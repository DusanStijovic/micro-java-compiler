// generated with ast extension for cup
// version 0.8
// 16/0/2021 21:30:43


package rs.ac.bg.etf.pp1.ast;

public class MethodFormalParams extends OptionalMethodFormalParams {

    private FormalParamDeclarationList FormalParamDeclarationList;

    public MethodFormalParams (FormalParamDeclarationList FormalParamDeclarationList) {
        this.FormalParamDeclarationList=FormalParamDeclarationList;
        if(FormalParamDeclarationList!=null) FormalParamDeclarationList.setParent(this);
    }

    public FormalParamDeclarationList getFormalParamDeclarationList() {
        return FormalParamDeclarationList;
    }

    public void setFormalParamDeclarationList(FormalParamDeclarationList FormalParamDeclarationList) {
        this.FormalParamDeclarationList=FormalParamDeclarationList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(FormalParamDeclarationList!=null) FormalParamDeclarationList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FormalParamDeclarationList!=null) FormalParamDeclarationList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FormalParamDeclarationList!=null) FormalParamDeclarationList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MethodFormalParams(\n");

        if(FormalParamDeclarationList!=null)
            buffer.append(FormalParamDeclarationList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MethodFormalParams]");
        return buffer.toString();
    }
}
