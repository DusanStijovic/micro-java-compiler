// generated with ast extension for cup
// version 0.8
// 2/0/2021 18:4:17


package rs.ac.bg.etf.pp1.ast;

public class FuncCall extends Factor {

    private Designator Designator;
    private OptioanalActualPars OptioanalActualPars;

    public FuncCall (Designator Designator, OptioanalActualPars OptioanalActualPars) {
        this.Designator=Designator;
        if(Designator!=null) Designator.setParent(this);
        this.OptioanalActualPars=OptioanalActualPars;
        if(OptioanalActualPars!=null) OptioanalActualPars.setParent(this);
    }

    public Designator getDesignator() {
        return Designator;
    }

    public void setDesignator(Designator Designator) {
        this.Designator=Designator;
    }

    public OptioanalActualPars getOptioanalActualPars() {
        return OptioanalActualPars;
    }

    public void setOptioanalActualPars(OptioanalActualPars OptioanalActualPars) {
        this.OptioanalActualPars=OptioanalActualPars;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Designator!=null) Designator.accept(visitor);
        if(OptioanalActualPars!=null) OptioanalActualPars.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Designator!=null) Designator.traverseTopDown(visitor);
        if(OptioanalActualPars!=null) OptioanalActualPars.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Designator!=null) Designator.traverseBottomUp(visitor);
        if(OptioanalActualPars!=null) OptioanalActualPars.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FuncCall(\n");

        if(Designator!=null)
            buffer.append(Designator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(OptioanalActualPars!=null)
            buffer.append(OptioanalActualPars.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FuncCall]");
        return buffer.toString();
    }
}
