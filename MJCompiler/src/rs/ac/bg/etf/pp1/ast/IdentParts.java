// generated with ast extension for cup
// version 0.8
// 16/0/2021 21:30:43


package rs.ac.bg.etf.pp1.ast;

public class IdentParts extends OptionalSpecifeIdentPartList {

    private SpecifeIdentPart SpecifeIdentPart;

    public IdentParts (SpecifeIdentPart SpecifeIdentPart) {
        this.SpecifeIdentPart=SpecifeIdentPart;
        if(SpecifeIdentPart!=null) SpecifeIdentPart.setParent(this);
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
        if(SpecifeIdentPart!=null) SpecifeIdentPart.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(SpecifeIdentPart!=null) SpecifeIdentPart.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(SpecifeIdentPart!=null) SpecifeIdentPart.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("IdentParts(\n");

        if(SpecifeIdentPart!=null)
            buffer.append(SpecifeIdentPart.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [IdentParts]");
        return buffer.toString();
    }
}
