// generated with ast extension for cup
// version 0.8
// 20/0/2021 22:55:7


package rs.ac.bg.etf.pp1.ast;

public class DoStmt extends Matched {

    private StartDoStmt StartDoStmt;
    private Statement Statement;
    private DoCondition DoCondition;

    public DoStmt (StartDoStmt StartDoStmt, Statement Statement, DoCondition DoCondition) {
        this.StartDoStmt=StartDoStmt;
        if(StartDoStmt!=null) StartDoStmt.setParent(this);
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
        this.DoCondition=DoCondition;
        if(DoCondition!=null) DoCondition.setParent(this);
    }

    public StartDoStmt getStartDoStmt() {
        return StartDoStmt;
    }

    public void setStartDoStmt(StartDoStmt StartDoStmt) {
        this.StartDoStmt=StartDoStmt;
    }

    public Statement getStatement() {
        return Statement;
    }

    public void setStatement(Statement Statement) {
        this.Statement=Statement;
    }

    public DoCondition getDoCondition() {
        return DoCondition;
    }

    public void setDoCondition(DoCondition DoCondition) {
        this.DoCondition=DoCondition;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(StartDoStmt!=null) StartDoStmt.accept(visitor);
        if(Statement!=null) Statement.accept(visitor);
        if(DoCondition!=null) DoCondition.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(StartDoStmt!=null) StartDoStmt.traverseTopDown(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
        if(DoCondition!=null) DoCondition.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(StartDoStmt!=null) StartDoStmt.traverseBottomUp(visitor);
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        if(DoCondition!=null) DoCondition.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DoStmt(\n");

        if(StartDoStmt!=null)
            buffer.append(StartDoStmt.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Statement!=null)
            buffer.append(Statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DoCondition!=null)
            buffer.append(DoCondition.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DoStmt]");
        return buffer.toString();
    }
}
