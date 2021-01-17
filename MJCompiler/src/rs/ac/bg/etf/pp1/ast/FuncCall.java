// generated with ast extension for cup
// version 0.8
// 16/0/2021 21:30:43


package rs.ac.bg.etf.pp1.ast;

public class FuncCall implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    public rs.etf.pp1.symboltable.concepts.Struct struct = null;

    private FuncCallStart FuncCallStart;
    private OptionalMethodActualParameters OptionalMethodActualParameters;

    public FuncCall (FuncCallStart FuncCallStart, OptionalMethodActualParameters OptionalMethodActualParameters) {
        this.FuncCallStart=FuncCallStart;
        if(FuncCallStart!=null) FuncCallStart.setParent(this);
        this.OptionalMethodActualParameters=OptionalMethodActualParameters;
        if(OptionalMethodActualParameters!=null) OptionalMethodActualParameters.setParent(this);
    }

    public FuncCallStart getFuncCallStart() {
        return FuncCallStart;
    }

    public void setFuncCallStart(FuncCallStart FuncCallStart) {
        this.FuncCallStart=FuncCallStart;
    }

    public OptionalMethodActualParameters getOptionalMethodActualParameters() {
        return OptionalMethodActualParameters;
    }

    public void setOptionalMethodActualParameters(OptionalMethodActualParameters OptionalMethodActualParameters) {
        this.OptionalMethodActualParameters=OptionalMethodActualParameters;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(FuncCallStart!=null) FuncCallStart.accept(visitor);
        if(OptionalMethodActualParameters!=null) OptionalMethodActualParameters.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FuncCallStart!=null) FuncCallStart.traverseTopDown(visitor);
        if(OptionalMethodActualParameters!=null) OptionalMethodActualParameters.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FuncCallStart!=null) FuncCallStart.traverseBottomUp(visitor);
        if(OptionalMethodActualParameters!=null) OptionalMethodActualParameters.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FuncCall(\n");

        if(FuncCallStart!=null)
            buffer.append(FuncCallStart.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(OptionalMethodActualParameters!=null)
            buffer.append(OptionalMethodActualParameters.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FuncCall]");
        return buffer.toString();
    }
}
