// generated with ast extension for cup
// version 0.8
// 5/0/2021 21:43:43


package rs.ac.bg.etf.pp1.ast;

public class Program implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private String programName;
    private ConstVarClassDeclarationList ConstVarClassDeclarationList;
    private MethodDeclarationList MethodDeclarationList;

    public Program (String programName, ConstVarClassDeclarationList ConstVarClassDeclarationList, MethodDeclarationList MethodDeclarationList) {
        this.programName=programName;
        this.ConstVarClassDeclarationList=ConstVarClassDeclarationList;
        if(ConstVarClassDeclarationList!=null) ConstVarClassDeclarationList.setParent(this);
        this.MethodDeclarationList=MethodDeclarationList;
        if(MethodDeclarationList!=null) MethodDeclarationList.setParent(this);
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName=programName;
    }

    public ConstVarClassDeclarationList getConstVarClassDeclarationList() {
        return ConstVarClassDeclarationList;
    }

    public void setConstVarClassDeclarationList(ConstVarClassDeclarationList ConstVarClassDeclarationList) {
        this.ConstVarClassDeclarationList=ConstVarClassDeclarationList;
    }

    public MethodDeclarationList getMethodDeclarationList() {
        return MethodDeclarationList;
    }

    public void setMethodDeclarationList(MethodDeclarationList MethodDeclarationList) {
        this.MethodDeclarationList=MethodDeclarationList;
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
        if(ConstVarClassDeclarationList!=null) ConstVarClassDeclarationList.accept(visitor);
        if(MethodDeclarationList!=null) MethodDeclarationList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstVarClassDeclarationList!=null) ConstVarClassDeclarationList.traverseTopDown(visitor);
        if(MethodDeclarationList!=null) MethodDeclarationList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstVarClassDeclarationList!=null) ConstVarClassDeclarationList.traverseBottomUp(visitor);
        if(MethodDeclarationList!=null) MethodDeclarationList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Program(\n");

        buffer.append(" "+tab+programName);
        buffer.append("\n");

        if(ConstVarClassDeclarationList!=null)
            buffer.append(ConstVarClassDeclarationList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MethodDeclarationList!=null)
            buffer.append(MethodDeclarationList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Program]");
        return buffer.toString();
    }
}
