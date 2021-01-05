// generated with ast extension for cup
// version 0.8
// 5/0/2021 21:43:43


package rs.ac.bg.etf.pp1.ast;

public class SwithStmt extends Matched {

    private Expr Expr;
    private CaseStatementList CaseStatementList;

    public SwithStmt (Expr Expr, CaseStatementList CaseStatementList) {
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
        this.CaseStatementList=CaseStatementList;
        if(CaseStatementList!=null) CaseStatementList.setParent(this);
    }

    public Expr getExpr() {
        return Expr;
    }

    public void setExpr(Expr Expr) {
        this.Expr=Expr;
    }

    public CaseStatementList getCaseStatementList() {
        return CaseStatementList;
    }

    public void setCaseStatementList(CaseStatementList CaseStatementList) {
        this.CaseStatementList=CaseStatementList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Expr!=null) Expr.accept(visitor);
        if(CaseStatementList!=null) CaseStatementList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
        if(CaseStatementList!=null) CaseStatementList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        if(CaseStatementList!=null) CaseStatementList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("SwithStmt(\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(CaseStatementList!=null)
            buffer.append(CaseStatementList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [SwithStmt]");
        return buffer.toString();
    }
}
