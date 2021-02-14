// generated with ast extension for cup
// version 0.8
// 20/0/2021 22:55:7


package rs.ac.bg.etf.pp1.ast;

public class ForStmt extends Matched {

    private StartFor StartFor;
    private ForCondition ForCondition;
    private DesignatorStatement DesignatorStatement;
    private BeginingStmtFor BeginingStmtFor;
    private StatementList StatementList;

    public ForStmt (StartFor StartFor, ForCondition ForCondition, DesignatorStatement DesignatorStatement, BeginingStmtFor BeginingStmtFor, StatementList StatementList) {
        this.StartFor=StartFor;
        if(StartFor!=null) StartFor.setParent(this);
        this.ForCondition=ForCondition;
        if(ForCondition!=null) ForCondition.setParent(this);
        this.DesignatorStatement=DesignatorStatement;
        if(DesignatorStatement!=null) DesignatorStatement.setParent(this);
        this.BeginingStmtFor=BeginingStmtFor;
        if(BeginingStmtFor!=null) BeginingStmtFor.setParent(this);
        this.StatementList=StatementList;
        if(StatementList!=null) StatementList.setParent(this);
    }

    public StartFor getStartFor() {
        return StartFor;
    }

    public void setStartFor(StartFor StartFor) {
        this.StartFor=StartFor;
    }

    public ForCondition getForCondition() {
        return ForCondition;
    }

    public void setForCondition(ForCondition ForCondition) {
        this.ForCondition=ForCondition;
    }

    public DesignatorStatement getDesignatorStatement() {
        return DesignatorStatement;
    }

    public void setDesignatorStatement(DesignatorStatement DesignatorStatement) {
        this.DesignatorStatement=DesignatorStatement;
    }

    public BeginingStmtFor getBeginingStmtFor() {
        return BeginingStmtFor;
    }

    public void setBeginingStmtFor(BeginingStmtFor BeginingStmtFor) {
        this.BeginingStmtFor=BeginingStmtFor;
    }

    public StatementList getStatementList() {
        return StatementList;
    }

    public void setStatementList(StatementList StatementList) {
        this.StatementList=StatementList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(StartFor!=null) StartFor.accept(visitor);
        if(ForCondition!=null) ForCondition.accept(visitor);
        if(DesignatorStatement!=null) DesignatorStatement.accept(visitor);
        if(BeginingStmtFor!=null) BeginingStmtFor.accept(visitor);
        if(StatementList!=null) StatementList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(StartFor!=null) StartFor.traverseTopDown(visitor);
        if(ForCondition!=null) ForCondition.traverseTopDown(visitor);
        if(DesignatorStatement!=null) DesignatorStatement.traverseTopDown(visitor);
        if(BeginingStmtFor!=null) BeginingStmtFor.traverseTopDown(visitor);
        if(StatementList!=null) StatementList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(StartFor!=null) StartFor.traverseBottomUp(visitor);
        if(ForCondition!=null) ForCondition.traverseBottomUp(visitor);
        if(DesignatorStatement!=null) DesignatorStatement.traverseBottomUp(visitor);
        if(BeginingStmtFor!=null) BeginingStmtFor.traverseBottomUp(visitor);
        if(StatementList!=null) StatementList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ForStmt(\n");

        if(StartFor!=null)
            buffer.append(StartFor.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ForCondition!=null)
            buffer.append(ForCondition.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DesignatorStatement!=null)
            buffer.append(DesignatorStatement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(BeginingStmtFor!=null)
            buffer.append(BeginingStmtFor.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(StatementList!=null)
            buffer.append(StatementList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ForStmt]");
        return buffer.toString();
    }
}
