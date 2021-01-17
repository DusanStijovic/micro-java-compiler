// generated with ast extension for cup
// version 0.8
// 16/0/2021 21:30:43


package rs.ac.bg.etf.pp1.ast;

public class ConditionListAnd extends ConditionTerm {

    private LeftAnd LeftAnd;
    private ConditionFact ConditionFact;

    public ConditionListAnd (LeftAnd LeftAnd, ConditionFact ConditionFact) {
        this.LeftAnd=LeftAnd;
        if(LeftAnd!=null) LeftAnd.setParent(this);
        this.ConditionFact=ConditionFact;
        if(ConditionFact!=null) ConditionFact.setParent(this);
    }

    public LeftAnd getLeftAnd() {
        return LeftAnd;
    }

    public void setLeftAnd(LeftAnd LeftAnd) {
        this.LeftAnd=LeftAnd;
    }

    public ConditionFact getConditionFact() {
        return ConditionFact;
    }

    public void setConditionFact(ConditionFact ConditionFact) {
        this.ConditionFact=ConditionFact;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(LeftAnd!=null) LeftAnd.accept(visitor);
        if(ConditionFact!=null) ConditionFact.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(LeftAnd!=null) LeftAnd.traverseTopDown(visitor);
        if(ConditionFact!=null) ConditionFact.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(LeftAnd!=null) LeftAnd.traverseBottomUp(visitor);
        if(ConditionFact!=null) ConditionFact.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConditionListAnd(\n");

        if(LeftAnd!=null)
            buffer.append(LeftAnd.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConditionFact!=null)
            buffer.append(ConditionFact.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConditionListAnd]");
        return buffer.toString();
    }
}
