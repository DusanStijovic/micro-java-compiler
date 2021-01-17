// generated with ast extension for cup
// version 0.8
// 16/0/2021 21:30:43


package rs.ac.bg.etf.pp1.ast;

public class MethodActualParams extends OptionalMethodActualParameters {

    private ActualParamDeclarationList ActualParamDeclarationList;

    public MethodActualParams (ActualParamDeclarationList ActualParamDeclarationList) {
        this.ActualParamDeclarationList=ActualParamDeclarationList;
        if(ActualParamDeclarationList!=null) ActualParamDeclarationList.setParent(this);
    }

    public ActualParamDeclarationList getActualParamDeclarationList() {
        return ActualParamDeclarationList;
    }

    public void setActualParamDeclarationList(ActualParamDeclarationList ActualParamDeclarationList) {
        this.ActualParamDeclarationList=ActualParamDeclarationList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ActualParamDeclarationList!=null) ActualParamDeclarationList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ActualParamDeclarationList!=null) ActualParamDeclarationList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ActualParamDeclarationList!=null) ActualParamDeclarationList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MethodActualParams(\n");

        if(ActualParamDeclarationList!=null)
            buffer.append(ActualParamDeclarationList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MethodActualParams]");
        return buffer.toString();
    }
}
