// generated with ast extension for cup
// version 0.8
// 16/0/2021 21:30:43


package rs.ac.bg.etf.pp1.ast;

public class GlobalArrrayVariable extends GlobalVariable {

    private String globalVarName;

    public GlobalArrrayVariable (String globalVarName) {
        this.globalVarName=globalVarName;
    }

    public String getGlobalVarName() {
        return globalVarName;
    }

    public void setGlobalVarName(String globalVarName) {
        this.globalVarName=globalVarName;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("GlobalArrrayVariable(\n");

        buffer.append(" "+tab+globalVarName);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [GlobalArrrayVariable]");
        return buffer.toString();
    }
}
