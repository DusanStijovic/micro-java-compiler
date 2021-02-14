// generated with ast extension for cup
// version 0.8
// 20/0/2021 22:55:7


package rs.ac.bg.etf.pp1.ast;

public class MethodDecl extends MethodDeclaration {

    private MethodRetName MethodRetName;
    private OptionalMethodFormalParams OptionalMethodFormalParams;
    private OptionalMethodsLocalVariablesDeclaration OptionalMethodsLocalVariablesDeclaration;
    private StatementList StatementList;

    public MethodDecl (MethodRetName MethodRetName, OptionalMethodFormalParams OptionalMethodFormalParams, OptionalMethodsLocalVariablesDeclaration OptionalMethodsLocalVariablesDeclaration, StatementList StatementList) {
        this.MethodRetName=MethodRetName;
        if(MethodRetName!=null) MethodRetName.setParent(this);
        this.OptionalMethodFormalParams=OptionalMethodFormalParams;
        if(OptionalMethodFormalParams!=null) OptionalMethodFormalParams.setParent(this);
        this.OptionalMethodsLocalVariablesDeclaration=OptionalMethodsLocalVariablesDeclaration;
        if(OptionalMethodsLocalVariablesDeclaration!=null) OptionalMethodsLocalVariablesDeclaration.setParent(this);
        this.StatementList=StatementList;
        if(StatementList!=null) StatementList.setParent(this);
    }

    public MethodRetName getMethodRetName() {
        return MethodRetName;
    }

    public void setMethodRetName(MethodRetName MethodRetName) {
        this.MethodRetName=MethodRetName;
    }

    public OptionalMethodFormalParams getOptionalMethodFormalParams() {
        return OptionalMethodFormalParams;
    }

    public void setOptionalMethodFormalParams(OptionalMethodFormalParams OptionalMethodFormalParams) {
        this.OptionalMethodFormalParams=OptionalMethodFormalParams;
    }

    public OptionalMethodsLocalVariablesDeclaration getOptionalMethodsLocalVariablesDeclaration() {
        return OptionalMethodsLocalVariablesDeclaration;
    }

    public void setOptionalMethodsLocalVariablesDeclaration(OptionalMethodsLocalVariablesDeclaration OptionalMethodsLocalVariablesDeclaration) {
        this.OptionalMethodsLocalVariablesDeclaration=OptionalMethodsLocalVariablesDeclaration;
    }

    public StatementList getStatementList() {
        return StatementList;
    }

    public void setStatementList(StatementList StatementList) {
        this.StatementList=StatementList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(MethodRetName!=null) MethodRetName.accept(visitor);
        if(OptionalMethodFormalParams!=null) OptionalMethodFormalParams.accept(visitor);
        if(OptionalMethodsLocalVariablesDeclaration!=null) OptionalMethodsLocalVariablesDeclaration.accept(visitor);
        if(StatementList!=null) StatementList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MethodRetName!=null) MethodRetName.traverseTopDown(visitor);
        if(OptionalMethodFormalParams!=null) OptionalMethodFormalParams.traverseTopDown(visitor);
        if(OptionalMethodsLocalVariablesDeclaration!=null) OptionalMethodsLocalVariablesDeclaration.traverseTopDown(visitor);
        if(StatementList!=null) StatementList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MethodRetName!=null) MethodRetName.traverseBottomUp(visitor);
        if(OptionalMethodFormalParams!=null) OptionalMethodFormalParams.traverseBottomUp(visitor);
        if(OptionalMethodsLocalVariablesDeclaration!=null) OptionalMethodsLocalVariablesDeclaration.traverseBottomUp(visitor);
        if(StatementList!=null) StatementList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MethodDecl(\n");

        if(MethodRetName!=null)
            buffer.append(MethodRetName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(OptionalMethodFormalParams!=null)
            buffer.append(OptionalMethodFormalParams.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(OptionalMethodsLocalVariablesDeclaration!=null)
            buffer.append(OptionalMethodsLocalVariablesDeclaration.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(StatementList!=null)
            buffer.append(StatementList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MethodDecl]");
        return buffer.toString();
    }
}
