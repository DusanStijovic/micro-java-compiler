// generated with ast extension for cup
// version 0.8
// 16/0/2021 21:30:43


package rs.ac.bg.etf.pp1.ast;

public class MultipleFactors extends FactorList {

    private FactorList FactorList;
    private MultiplyOperator MultiplyOperator;
    private Factor Factor;

    public MultipleFactors (FactorList FactorList, MultiplyOperator MultiplyOperator, Factor Factor) {
        this.FactorList=FactorList;
        if(FactorList!=null) FactorList.setParent(this);
        this.MultiplyOperator=MultiplyOperator;
        if(MultiplyOperator!=null) MultiplyOperator.setParent(this);
        this.Factor=Factor;
        if(Factor!=null) Factor.setParent(this);
    }

    public FactorList getFactorList() {
        return FactorList;
    }

    public void setFactorList(FactorList FactorList) {
        this.FactorList=FactorList;
    }

    public MultiplyOperator getMultiplyOperator() {
        return MultiplyOperator;
    }

    public void setMultiplyOperator(MultiplyOperator MultiplyOperator) {
        this.MultiplyOperator=MultiplyOperator;
    }

    public Factor getFactor() {
        return Factor;
    }

    public void setFactor(Factor Factor) {
        this.Factor=Factor;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(FactorList!=null) FactorList.accept(visitor);
        if(MultiplyOperator!=null) MultiplyOperator.accept(visitor);
        if(Factor!=null) Factor.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FactorList!=null) FactorList.traverseTopDown(visitor);
        if(MultiplyOperator!=null) MultiplyOperator.traverseTopDown(visitor);
        if(Factor!=null) Factor.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FactorList!=null) FactorList.traverseBottomUp(visitor);
        if(MultiplyOperator!=null) MultiplyOperator.traverseBottomUp(visitor);
        if(Factor!=null) Factor.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MultipleFactors(\n");

        if(FactorList!=null)
            buffer.append(FactorList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MultiplyOperator!=null)
            buffer.append(MultiplyOperator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Factor!=null)
            buffer.append(Factor.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MultipleFactors]");
        return buffer.toString();
    }
}
