// generated with ast extension for cup
// version 0.8
// 2/0/2021 18:4:17


package rs.ac.bg.etf.pp1.ast;

public class VarCondition extends ConditionFact {

    private Expr Expr;
    private OptionalSecondCondtionVar OptionalSecondCondtionVar;

    public VarCondition (Expr Expr, OptionalSecondCondtionVar OptionalSecondCondtionVar) {
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
        this.OptionalSecondCondtionVar=OptionalSecondCondtionVar;
        if(OptionalSecondCondtionVar!=null) OptionalSecondCondtionVar.setParent(this);
    }

    public Expr getExpr() {
        return Expr;
    }

    public void setExpr(Expr Expr) {
        this.Expr=Expr;
    }

    public OptionalSecondCondtionVar getOptionalSecondCondtionVar() {
        return OptionalSecondCondtionVar;
    }

    public void setOptionalSecondCondtionVar(OptionalSecondCondtionVar OptionalSecondCondtionVar) {
        this.OptionalSecondCondtionVar=OptionalSecondCondtionVar;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Expr!=null) Expr.accept(visitor);
        if(OptionalSecondCondtionVar!=null) OptionalSecondCondtionVar.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
        if(OptionalSecondCondtionVar!=null) OptionalSecondCondtionVar.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        if(OptionalSecondCondtionVar!=null) OptionalSecondCondtionVar.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarCondition(\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(OptionalSecondCondtionVar!=null)
            buffer.append(OptionalSecondCondtionVar.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarCondition]");
        return buffer.toString();
    }
}
