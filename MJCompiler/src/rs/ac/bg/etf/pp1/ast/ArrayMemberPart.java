// generated with ast extension for cup
// version 0.8
// 20/0/2021 22:55:7


package rs.ac.bg.etf.pp1.ast;

public class ArrayMemberPart extends SpecifeIdentPart {

    private LsquareStart LsquareStart;
    private Expr Expr;

    public ArrayMemberPart (LsquareStart LsquareStart, Expr Expr) {
        this.LsquareStart=LsquareStart;
        if(LsquareStart!=null) LsquareStart.setParent(this);
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
    }

    public LsquareStart getLsquareStart() {
        return LsquareStart;
    }

    public void setLsquareStart(LsquareStart LsquareStart) {
        this.LsquareStart=LsquareStart;
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
        if(LsquareStart!=null) LsquareStart.accept(visitor);
        if(Expr!=null) Expr.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(LsquareStart!=null) LsquareStart.traverseTopDown(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(LsquareStart!=null) LsquareStart.traverseBottomUp(visitor);
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ArrayMemberPart(\n");

        if(LsquareStart!=null)
            buffer.append(LsquareStart.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ArrayMemberPart]");
        return buffer.toString();
    }
}
