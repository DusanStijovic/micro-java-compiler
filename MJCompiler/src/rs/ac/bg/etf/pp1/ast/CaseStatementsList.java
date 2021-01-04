// generated with ast extension for cup
// version 0.8
// 2/0/2021 18:4:17


package rs.ac.bg.etf.pp1.ast;

public class CaseStatementsList extends CaseStatementList {

    private CaseStatementList CaseStatementList;
    private CaseStatement CaseStatement;

    public CaseStatementsList (CaseStatementList CaseStatementList, CaseStatement CaseStatement) {
        this.CaseStatementList=CaseStatementList;
        if(CaseStatementList!=null) CaseStatementList.setParent(this);
        this.CaseStatement=CaseStatement;
        if(CaseStatement!=null) CaseStatement.setParent(this);
    }

    public CaseStatementList getCaseStatementList() {
        return CaseStatementList;
    }

    public void setCaseStatementList(CaseStatementList CaseStatementList) {
        this.CaseStatementList=CaseStatementList;
    }

    public CaseStatement getCaseStatement() {
        return CaseStatement;
    }

    public void setCaseStatement(CaseStatement CaseStatement) {
        this.CaseStatement=CaseStatement;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(CaseStatementList!=null) CaseStatementList.accept(visitor);
        if(CaseStatement!=null) CaseStatement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(CaseStatementList!=null) CaseStatementList.traverseTopDown(visitor);
        if(CaseStatement!=null) CaseStatement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(CaseStatementList!=null) CaseStatementList.traverseBottomUp(visitor);
        if(CaseStatement!=null) CaseStatement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("CaseStatementsList(\n");

        if(CaseStatementList!=null)
            buffer.append(CaseStatementList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(CaseStatement!=null)
            buffer.append(CaseStatement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [CaseStatementsList]");
        return buffer.toString();
    }
}
