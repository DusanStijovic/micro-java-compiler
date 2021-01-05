// generated with ast extension for cup
// version 0.8
// 5/0/2021 21:43:43


package rs.ac.bg.etf.pp1.ast;

public class FormalParamDecl extends FormalParamDeclaration {

    private Type Type;
    private String formalParamName;
    private OptionalSquareMethodFormalParam OptionalSquareMethodFormalParam;

    public FormalParamDecl (Type Type, String formalParamName, OptionalSquareMethodFormalParam OptionalSquareMethodFormalParam) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.formalParamName=formalParamName;
        this.OptionalSquareMethodFormalParam=OptionalSquareMethodFormalParam;
        if(OptionalSquareMethodFormalParam!=null) OptionalSquareMethodFormalParam.setParent(this);
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

    public OptionalSquareMethodFormalParam getOptionalSquareMethodFormalParam() {
        return OptionalSquareMethodFormalParam;
    }

    public void setOptionalSquareMethodFormalParam(OptionalSquareMethodFormalParam OptionalSquareMethodFormalParam) {
        this.OptionalSquareMethodFormalParam=OptionalSquareMethodFormalParam;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(OptionalSquareMethodFormalParam!=null) OptionalSquareMethodFormalParam.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(OptionalSquareMethodFormalParam!=null) OptionalSquareMethodFormalParam.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(OptionalSquareMethodFormalParam!=null) OptionalSquareMethodFormalParam.traverseBottomUp(visitor);
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

        if(OptionalSquareMethodFormalParam!=null)
            buffer.append(OptionalSquareMethodFormalParam.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FormalParamDecl]");
        return buffer.toString();
    }
}
