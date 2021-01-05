// generated with ast extension for cup
// version 0.8
// 5/0/2021 22:4:16


package rs.ac.bg.etf.pp1.ast;

public class IdentPartList extends SpecifeIdentPartList {

    private SpecifeIdentPartList SpecifeIdentPartList;
    private SpecifeIdentPart SpecifeIdentPart;

    public IdentPartList (SpecifeIdentPartList SpecifeIdentPartList, SpecifeIdentPart SpecifeIdentPart) {
        this.SpecifeIdentPartList=SpecifeIdentPartList;
        if(SpecifeIdentPartList!=null) SpecifeIdentPartList.setParent(this);
        this.SpecifeIdentPart=SpecifeIdentPart;
        if(SpecifeIdentPart!=null) SpecifeIdentPart.setParent(this);
    }

    public SpecifeIdentPartList getSpecifeIdentPartList() {
        return SpecifeIdentPartList;
    }

    public void setSpecifeIdentPartList(SpecifeIdentPartList SpecifeIdentPartList) {
        this.SpecifeIdentPartList=SpecifeIdentPartList;
    }

    public SpecifeIdentPart getSpecifeIdentPart() {
        return SpecifeIdentPart;
    }

    public void setSpecifeIdentPart(SpecifeIdentPart SpecifeIdentPart) {
        this.SpecifeIdentPart=SpecifeIdentPart;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(SpecifeIdentPartList!=null) SpecifeIdentPartList.accept(visitor);
        if(SpecifeIdentPart!=null) SpecifeIdentPart.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(SpecifeIdentPartList!=null) SpecifeIdentPartList.traverseTopDown(visitor);
        if(SpecifeIdentPart!=null) SpecifeIdentPart.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(SpecifeIdentPartList!=null) SpecifeIdentPartList.traverseBottomUp(visitor);
        if(SpecifeIdentPart!=null) SpecifeIdentPart.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("IdentPartList(\n");

        if(SpecifeIdentPartList!=null)
            buffer.append(SpecifeIdentPartList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(SpecifeIdentPart!=null)
            buffer.append(SpecifeIdentPart.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [IdentPartList]");
        return buffer.toString();
    }
}
