// generated with ast extension for cup
// version 0.8
// 20/0/2021 22:55:7


package rs.ac.bg.etf.pp1.ast;

public class AssignmentExpr extends AssignmentStatement {

    private AssignmentOperator AssignmentOperator;
    private Expr Expr;

    public AssignmentExpr (AssignmentOperator AssignmentOperator, Expr Expr) {
        this.AssignmentOperator=AssignmentOperator;
        if(AssignmentOperator!=null) AssignmentOperator.setParent(this);
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
    }

    public AssignmentOperator getAssignmentOperator() {
        return AssignmentOperator;
    }

    public void setAssignmentOperator(AssignmentOperator AssignmentOperator) {
        this.AssignmentOperator=AssignmentOperator;
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
        if(AssignmentOperator!=null) AssignmentOperator.accept(visitor);
        if(Expr!=null) Expr.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(AssignmentOperator!=null) AssignmentOperator.traverseTopDown(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(AssignmentOperator!=null) AssignmentOperator.traverseBottomUp(visitor);
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("AssignmentExpr(\n");

        if(AssignmentOperator!=null)
            buffer.append(AssignmentOperator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [AssignmentExpr]");
        return buffer.toString();
    }
}
