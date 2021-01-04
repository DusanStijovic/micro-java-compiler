// generated with ast extension for cup
// version 0.8
// 2/0/2021 18:4:17


package rs.ac.bg.etf.pp1.ast;

public class GroupVarDeclarations extends GroupDeclList {

    private GroupDeclList GroupDeclList;
    private VarType VarType;

    public GroupVarDeclarations (GroupDeclList GroupDeclList, VarType VarType) {
        this.GroupDeclList=GroupDeclList;
        if(GroupDeclList!=null) GroupDeclList.setParent(this);
        this.VarType=VarType;
        if(VarType!=null) VarType.setParent(this);
    }

    public GroupDeclList getGroupDeclList() {
        return GroupDeclList;
    }

    public void setGroupDeclList(GroupDeclList GroupDeclList) {
        this.GroupDeclList=GroupDeclList;
    }

    public VarType getVarType() {
        return VarType;
    }

    public void setVarType(VarType VarType) {
        this.VarType=VarType;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(GroupDeclList!=null) GroupDeclList.accept(visitor);
        if(VarType!=null) VarType.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(GroupDeclList!=null) GroupDeclList.traverseTopDown(visitor);
        if(VarType!=null) VarType.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(GroupDeclList!=null) GroupDeclList.traverseBottomUp(visitor);
        if(VarType!=null) VarType.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("GroupVarDeclarations(\n");

        if(GroupDeclList!=null)
            buffer.append(GroupDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarType!=null)
            buffer.append(VarType.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [GroupVarDeclarations]");
        return buffer.toString();
    }
}
