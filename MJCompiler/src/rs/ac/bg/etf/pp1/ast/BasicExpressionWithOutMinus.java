// generated with ast extension for cup
// version 0.8
// 16/0/2021 21:30:43


package rs.ac.bg.etf.pp1.ast;

public class BasicExpressionWithOutMinus extends Expr1 {

    private TermList TermList;

    public BasicExpressionWithOutMinus (TermList TermList) {
        this.TermList=TermList;
        if(TermList!=null) TermList.setParent(this);
    }

    public TermList getTermList() {
        return TermList;
    }

    public void setTermList(TermList TermList) {
        this.TermList=TermList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(TermList!=null) TermList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(TermList!=null) TermList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(TermList!=null) TermList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("BasicExpressionWithOutMinus(\n");

        if(TermList!=null)
            buffer.append(TermList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [BasicExpressionWithOutMinus]");
        return buffer.toString();
    }
}
