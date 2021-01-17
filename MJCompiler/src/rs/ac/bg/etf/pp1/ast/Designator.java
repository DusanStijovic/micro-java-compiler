// generated with ast extension for cup
// version 0.8
// 16/0/2021 21:30:43


package rs.ac.bg.etf.pp1.ast;

public class Designator implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    public rs.etf.pp1.symboltable.concepts.Struct struct = null;

    private String variableName;
    private OptionalSpecifeIdentPartList OptionalSpecifeIdentPartList;

    public Designator (String variableName, OptionalSpecifeIdentPartList OptionalSpecifeIdentPartList) {
        this.variableName=variableName;
        this.OptionalSpecifeIdentPartList=OptionalSpecifeIdentPartList;
        if(OptionalSpecifeIdentPartList!=null) OptionalSpecifeIdentPartList.setParent(this);
    }

    public String getVariableName() {
        return variableName;
    }

    public void setVariableName(String variableName) {
        this.variableName=variableName;
    }

    public OptionalSpecifeIdentPartList getOptionalSpecifeIdentPartList() {
        return OptionalSpecifeIdentPartList;
    }

    public void setOptionalSpecifeIdentPartList(OptionalSpecifeIdentPartList OptionalSpecifeIdentPartList) {
        this.OptionalSpecifeIdentPartList=OptionalSpecifeIdentPartList;
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
        if(OptionalSpecifeIdentPartList!=null) OptionalSpecifeIdentPartList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(OptionalSpecifeIdentPartList!=null) OptionalSpecifeIdentPartList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(OptionalSpecifeIdentPartList!=null) OptionalSpecifeIdentPartList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Designator(\n");

        buffer.append(" "+tab+variableName);
        buffer.append("\n");

        if(OptionalSpecifeIdentPartList!=null)
            buffer.append(OptionalSpecifeIdentPartList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Designator]");
        return buffer.toString();
    }
}
