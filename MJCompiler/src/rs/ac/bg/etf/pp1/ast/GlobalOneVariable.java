// generated with ast extension for cup
// version 0.8
// 16/0/2021 21:30:43


package rs.ac.bg.etf.pp1.ast;

public class GlobalOneVariable extends GlobalVarList {

    private GlobalVariable GlobalVariable;

    public GlobalOneVariable (GlobalVariable GlobalVariable) {
        this.GlobalVariable=GlobalVariable;
        if(GlobalVariable!=null) GlobalVariable.setParent(this);
    }

    public GlobalVariable getGlobalVariable() {
        return GlobalVariable;
    }

    public void setGlobalVariable(GlobalVariable GlobalVariable) {
        this.GlobalVariable=GlobalVariable;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(GlobalVariable!=null) GlobalVariable.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(GlobalVariable!=null) GlobalVariable.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(GlobalVariable!=null) GlobalVariable.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("GlobalOneVariable(\n");

        if(GlobalVariable!=null)
            buffer.append(GlobalVariable.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [GlobalOneVariable]");
        return buffer.toString();
    }
}
