// generated with ast extension for cup
// version 0.8
// 5/0/2021 22:4:16


package rs.ac.bg.etf.pp1.ast;

public class MetodCall extends DesignatorPart {

    private OptionalMethodActualParameters OptionalMethodActualParameters;

    public MetodCall (OptionalMethodActualParameters OptionalMethodActualParameters) {
        this.OptionalMethodActualParameters=OptionalMethodActualParameters;
        if(OptionalMethodActualParameters!=null) OptionalMethodActualParameters.setParent(this);
    }

    public OptionalMethodActualParameters getOptionalMethodActualParameters() {
        return OptionalMethodActualParameters;
    }

    public void setOptionalMethodActualParameters(OptionalMethodActualParameters OptionalMethodActualParameters) {
        this.OptionalMethodActualParameters=OptionalMethodActualParameters;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(OptionalMethodActualParameters!=null) OptionalMethodActualParameters.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(OptionalMethodActualParameters!=null) OptionalMethodActualParameters.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(OptionalMethodActualParameters!=null) OptionalMethodActualParameters.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MetodCall(\n");

        if(OptionalMethodActualParameters!=null)
            buffer.append(OptionalMethodActualParameters.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MetodCall]");
        return buffer.toString();
    }
}
