// generated with ast extension for cup
// version 0.8
// 20/0/2021 22:55:7


package rs.ac.bg.etf.pp1.ast;

public class ConditionListOr extends Condition {

    private LeftOr LeftOr;
    private ConditionTerm ConditionTerm;

    public ConditionListOr (LeftOr LeftOr, ConditionTerm ConditionTerm) {
        this.LeftOr=LeftOr;
        if(LeftOr!=null) LeftOr.setParent(this);
        this.ConditionTerm=ConditionTerm;
        if(ConditionTerm!=null) ConditionTerm.setParent(this);
    }

    public LeftOr getLeftOr() {
        return LeftOr;
    }

    public void setLeftOr(LeftOr LeftOr) {
        this.LeftOr=LeftOr;
    }

    public ConditionTerm getConditionTerm() {
        return ConditionTerm;
    }

    public void setConditionTerm(ConditionTerm ConditionTerm) {
        this.ConditionTerm=ConditionTerm;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(LeftOr!=null) LeftOr.accept(visitor);
        if(ConditionTerm!=null) ConditionTerm.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(LeftOr!=null) LeftOr.traverseTopDown(visitor);
        if(ConditionTerm!=null) ConditionTerm.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(LeftOr!=null) LeftOr.traverseBottomUp(visitor);
        if(ConditionTerm!=null) ConditionTerm.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConditionListOr(\n");

        if(LeftOr!=null)
            buffer.append(LeftOr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConditionTerm!=null)
            buffer.append(ConditionTerm.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConditionListOr]");
        return buffer.toString();
    }
}
