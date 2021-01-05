// generated with ast extension for cup
// version 0.8
// 5/0/2021 22:4:16


package rs.ac.bg.etf.pp1.ast;

public class NewOperator extends Factor {

    private Type Type;
    private OptionalSquareNewOp OptionalSquareNewOp;

    public NewOperator (Type Type, OptionalSquareNewOp OptionalSquareNewOp) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.OptionalSquareNewOp=OptionalSquareNewOp;
        if(OptionalSquareNewOp!=null) OptionalSquareNewOp.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public OptionalSquareNewOp getOptionalSquareNewOp() {
        return OptionalSquareNewOp;
    }

    public void setOptionalSquareNewOp(OptionalSquareNewOp OptionalSquareNewOp) {
        this.OptionalSquareNewOp=OptionalSquareNewOp;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(OptionalSquareNewOp!=null) OptionalSquareNewOp.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(OptionalSquareNewOp!=null) OptionalSquareNewOp.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(OptionalSquareNewOp!=null) OptionalSquareNewOp.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("NewOperator(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(OptionalSquareNewOp!=null)
            buffer.append(OptionalSquareNewOp.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [NewOperator]");
        return buffer.toString();
    }
}
