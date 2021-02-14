// generated with ast extension for cup
// version 0.8
// 20/0/2021 22:55:7


package rs.ac.bg.etf.pp1.ast;

public class ActualParamDeclList extends ActualParamDeclarationList {

    private ActualParamDeclarationList ActualParamDeclarationList;
    private Expr Expr;

    public ActualParamDeclList (ActualParamDeclarationList ActualParamDeclarationList, Expr Expr) {
        this.ActualParamDeclarationList=ActualParamDeclarationList;
        if(ActualParamDeclarationList!=null) ActualParamDeclarationList.setParent(this);
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
    }

    public ActualParamDeclarationList getActualParamDeclarationList() {
        return ActualParamDeclarationList;
    }

    public void setActualParamDeclarationList(ActualParamDeclarationList ActualParamDeclarationList) {
        this.ActualParamDeclarationList=ActualParamDeclarationList;
    }

    public Expr getExpr() {
        return Expr;
    }

    public void setExpr(Expr Expr) {
        this.Expr=Expr;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ActualParamDeclarationList!=null) ActualParamDeclarationList.accept(visitor);
        if(Expr!=null) Expr.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ActualParamDeclarationList!=null) ActualParamDeclarationList.traverseTopDown(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ActualParamDeclarationList!=null) ActualParamDeclarationList.traverseBottomUp(visitor);
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ActualParamDeclList(\n");

        if(ActualParamDeclarationList!=null)
            buffer.append(ActualParamDeclarationList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ActualParamDeclList]");
        return buffer.toString();
    }
}
