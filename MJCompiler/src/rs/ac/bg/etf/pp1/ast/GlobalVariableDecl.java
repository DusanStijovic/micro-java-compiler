// generated with ast extension for cup
// version 0.8
// 16/0/2021 21:30:43


package rs.ac.bg.etf.pp1.ast;

public class GlobalVariableDecl extends ConstVarClassDeclaration {

    private GlobalVariableDeclaration GlobalVariableDeclaration;

    public GlobalVariableDecl (GlobalVariableDeclaration GlobalVariableDeclaration) {
        this.GlobalVariableDeclaration=GlobalVariableDeclaration;
        if(GlobalVariableDeclaration!=null) GlobalVariableDeclaration.setParent(this);
    }

    public GlobalVariableDeclaration getGlobalVariableDeclaration() {
        return GlobalVariableDeclaration;
    }

    public void setGlobalVariableDeclaration(GlobalVariableDeclaration GlobalVariableDeclaration) {
        this.GlobalVariableDeclaration=GlobalVariableDeclaration;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(GlobalVariableDeclaration!=null) GlobalVariableDeclaration.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(GlobalVariableDeclaration!=null) GlobalVariableDeclaration.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(GlobalVariableDeclaration!=null) GlobalVariableDeclaration.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("GlobalVariableDecl(\n");

        if(GlobalVariableDeclaration!=null)
            buffer.append(GlobalVariableDeclaration.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [GlobalVariableDecl]");
        return buffer.toString();
    }
}
