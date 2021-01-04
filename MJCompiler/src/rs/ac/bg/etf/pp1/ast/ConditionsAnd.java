// generated with ast extension for cup
// version 0.8
// 2/0/2021 18:4:17


package rs.ac.bg.etf.pp1.ast;

public class ConditionsAnd extends ConditionTerm {

    private ConditionFact ConditionFact;
    private ConditionFactList ConditionFactList;

    public ConditionsAnd (ConditionFact ConditionFact, ConditionFactList ConditionFactList) {
        this.ConditionFact=ConditionFact;
        if(ConditionFact!=null) ConditionFact.setParent(this);
        this.ConditionFactList=ConditionFactList;
        if(ConditionFactList!=null) ConditionFactList.setParent(this);
    }

    public ConditionFact getConditionFact() {
        return ConditionFact;
    }

    public void setConditionFact(ConditionFact ConditionFact) {
        this.ConditionFact=ConditionFact;
    }

    public ConditionFactList getConditionFactList() {
        return ConditionFactList;
    }

    public void setConditionFactList(ConditionFactList ConditionFactList) {
        this.ConditionFactList=ConditionFactList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConditionFact!=null) ConditionFact.accept(visitor);
        if(ConditionFactList!=null) ConditionFactList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConditionFact!=null) ConditionFact.traverseTopDown(visitor);
        if(ConditionFactList!=null) ConditionFactList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConditionFact!=null) ConditionFact.traverseBottomUp(visitor);
        if(ConditionFactList!=null) ConditionFactList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConditionsAnd(\n");

        if(ConditionFact!=null)
            buffer.append(ConditionFact.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConditionFactList!=null)
            buffer.append(ConditionFactList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConditionsAnd]");
        return buffer.toString();
    }
}
