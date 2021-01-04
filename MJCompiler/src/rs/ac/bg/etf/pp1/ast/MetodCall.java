// generated with ast extension for cup
// version 0.8
// 2/0/2021 18:4:17


package rs.ac.bg.etf.pp1.ast;

public class MetodCall extends DesignatorPart {

    private OptioanalActualPars OptioanalActualPars;

    public MetodCall (OptioanalActualPars OptioanalActualPars) {
        this.OptioanalActualPars=OptioanalActualPars;
        if(OptioanalActualPars!=null) OptioanalActualPars.setParent(this);
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
        if(OptioanalActualPars!=null) OptioanalActualPars.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(OptioanalActualPars!=null) OptioanalActualPars.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(OptioanalActualPars!=null) OptioanalActualPars.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MetodCall(\n");

        if(OptioanalActualPars!=null)
            buffer.append(OptioanalActualPars.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MetodCall]");
        return buffer.toString();
    }
}
