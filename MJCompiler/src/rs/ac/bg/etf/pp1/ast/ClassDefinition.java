// generated with ast extension for cup
// version 0.8
// 2/0/2021 18:4:17


package rs.ac.bg.etf.pp1.ast;

public class ClassDefinition extends ClassDecl {

    private String className;
    private ExtendClassOption ExtendClassOption;
    private VarDeclList VarDeclList;
    private OptionalMethodsList OptionalMethodsList;

    public ClassDefinition (String className, ExtendClassOption ExtendClassOption, VarDeclList VarDeclList, OptionalMethodsList OptionalMethodsList) {
        this.className=className;
        this.ExtendClassOption=ExtendClassOption;
        if(ExtendClassOption!=null) ExtendClassOption.setParent(this);
        this.VarDeclList=VarDeclList;
        if(VarDeclList!=null) VarDeclList.setParent(this);
        this.OptionalMethodsList=OptionalMethodsList;
        if(OptionalMethodsList!=null) OptionalMethodsList.setParent(this);
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className=className;
    }

    public ExtendClassOption getExtendClassOption() {
        return ExtendClassOption;
    }

    public void setExtendClassOption(ExtendClassOption ExtendClassOption) {
        this.ExtendClassOption=ExtendClassOption;
    }

    public VarDeclList getVarDeclList() {
        return VarDeclList;
    }

    public void setVarDeclList(VarDeclList VarDeclList) {
        this.VarDeclList=VarDeclList;
    }

    public OptionalMethodsList getOptionalMethodsList() {
        return OptionalMethodsList;
    }

    public void setOptionalMethodsList(OptionalMethodsList OptionalMethodsList) {
        this.OptionalMethodsList=OptionalMethodsList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ExtendClassOption!=null) ExtendClassOption.accept(visitor);
        if(VarDeclList!=null) VarDeclList.accept(visitor);
        if(OptionalMethodsList!=null) OptionalMethodsList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ExtendClassOption!=null) ExtendClassOption.traverseTopDown(visitor);
        if(VarDeclList!=null) VarDeclList.traverseTopDown(visitor);
        if(OptionalMethodsList!=null) OptionalMethodsList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ExtendClassOption!=null) ExtendClassOption.traverseBottomUp(visitor);
        if(VarDeclList!=null) VarDeclList.traverseBottomUp(visitor);
        if(OptionalMethodsList!=null) OptionalMethodsList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ClassDefinition(\n");

        buffer.append(" "+tab+className);
        buffer.append("\n");

        if(ExtendClassOption!=null)
            buffer.append(ExtendClassOption.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclList!=null)
            buffer.append(VarDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(OptionalMethodsList!=null)
            buffer.append(OptionalMethodsList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ClassDefinition]");
        return buffer.toString();
    }
}
