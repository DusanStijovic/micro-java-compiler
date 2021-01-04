// generated with ast extension for cup
// version 0.8
// 2/0/2021 18:4:17


package rs.ac.bg.etf.pp1.ast;

public class FormalParamDecl implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private Type Type;
    private String formalParamName;
    private OptionalSquare OptionalSquare;

    public FormalParamDecl (Type Type, String formalParamName, OptionalSquare OptionalSquare) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.formalParamName=formalParamName;
        this.OptionalSquare=OptionalSquare;
        if(OptionalSquare!=null) OptionalSquare.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public String getFormalParamName() {
        return formalParamName;
    }

    public void setFormalParamName(String formalParamName) {
        this.formalParamName=formalParamName;
    }

    public OptionalSquare getOptionalSquare() {
        return OptionalSquare;
    }

    public void setOptionalSquare(OptionalSquare OptionalSquare) {
        this.OptionalSquare=OptionalSquare;
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
        if(Type!=null) Type.accept(visitor);
        if(OptionalSquare!=null) OptionalSquare.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(OptionalSquare!=null) OptionalSquare.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(OptionalSquare!=null) OptionalSquare.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FormalParamDecl(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+formalParamName);
        buffer.append("\n");

        if(OptionalSquare!=null)
            buffer.append(OptionalSquare.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FormalParamDecl]");
        return buffer.toString();
    }
}
