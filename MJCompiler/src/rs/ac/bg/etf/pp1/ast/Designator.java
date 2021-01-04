// generated with ast extension for cup
// version 0.8
// 2/0/2021 18:4:17


package rs.ac.bg.etf.pp1.ast;

public class Designator implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private String name;
    private SpecifeIdentPartList SpecifeIdentPartList;

    public Designator (String name, SpecifeIdentPartList SpecifeIdentPartList) {
        this.name=name;
        this.SpecifeIdentPartList=SpecifeIdentPartList;
        if(SpecifeIdentPartList!=null) SpecifeIdentPartList.setParent(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name=name;
    }

    public SpecifeIdentPartList getSpecifeIdentPartList() {
        return SpecifeIdentPartList;
    }

    public void setSpecifeIdentPartList(SpecifeIdentPartList SpecifeIdentPartList) {
        this.SpecifeIdentPartList=SpecifeIdentPartList;
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
        if(SpecifeIdentPartList!=null) SpecifeIdentPartList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(SpecifeIdentPartList!=null) SpecifeIdentPartList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(SpecifeIdentPartList!=null) SpecifeIdentPartList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Designator(\n");

        buffer.append(" "+tab+name);
        buffer.append("\n");

        if(SpecifeIdentPartList!=null)
            buffer.append(SpecifeIdentPartList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Designator]");
        return buffer.toString();
    }
}
