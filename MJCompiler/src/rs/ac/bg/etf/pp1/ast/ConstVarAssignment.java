// generated with ast extension for cup
// version 0.8
// 2/0/2021 18:4:17


package rs.ac.bg.etf.pp1.ast;

public class ConstVarAssignment extends ConstVariable {

    private String VarNum;
    private ConstType ConstType;

    public ConstVarAssignment (String VarNum, ConstType ConstType) {
        this.VarNum=VarNum;
        this.ConstType=ConstType;
        if(ConstType!=null) ConstType.setParent(this);
    }

    public String getVarNum() {
        return VarNum;
    }

    public void setVarNum(String VarNum) {
        this.VarNum=VarNum;
    }

    public ConstType getConstType() {
        return ConstType;
    }

    public void setConstType(ConstType ConstType) {
        this.ConstType=ConstType;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConstType!=null) ConstType.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstType!=null) ConstType.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstType!=null) ConstType.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstVarAssignment(\n");

        buffer.append(" "+tab+VarNum);
        buffer.append("\n");

        if(ConstType!=null)
            buffer.append(ConstType.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstVarAssignment]");
        return buffer.toString();
    }
}
