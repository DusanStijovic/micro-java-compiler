// generated with ast extension for cup
// version 0.8
// 16/0/2021 21:30:43


package rs.ac.bg.etf.pp1.ast;

public class TernarExpr extends Expr {

    private TernarStart TernarStart;
    private Expr1 Expr1;
    private TernarDivider TernarDivider;
    private Expr1 Expr11;

    public TernarExpr (TernarStart TernarStart, Expr1 Expr1, TernarDivider TernarDivider, Expr1 Expr11) {
        this.TernarStart=TernarStart;
        if(TernarStart!=null) TernarStart.setParent(this);
        this.Expr1=Expr1;
        if(Expr1!=null) Expr1.setParent(this);
        this.TernarDivider=TernarDivider;
        if(TernarDivider!=null) TernarDivider.setParent(this);
        this.Expr11=Expr11;
        if(Expr11!=null) Expr11.setParent(this);
    }

    public TernarStart getTernarStart() {
        return TernarStart;
    }

    public void setTernarStart(TernarStart TernarStart) {
        this.TernarStart=TernarStart;
    }

    public Expr1 getExpr1() {
        return Expr1;
    }

    public void setExpr1(Expr1 Expr1) {
        this.Expr1=Expr1;
    }

    public TernarDivider getTernarDivider() {
        return TernarDivider;
    }

    public void setTernarDivider(TernarDivider TernarDivider) {
        this.TernarDivider=TernarDivider;
    }

    public Expr1 getExpr11() {
        return Expr11;
    }

    public void setExpr11(Expr1 Expr11) {
        this.Expr11=Expr11;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(TernarStart!=null) TernarStart.accept(visitor);
        if(Expr1!=null) Expr1.accept(visitor);
        if(TernarDivider!=null) TernarDivider.accept(visitor);
        if(Expr11!=null) Expr11.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(TernarStart!=null) TernarStart.traverseTopDown(visitor);
        if(Expr1!=null) Expr1.traverseTopDown(visitor);
        if(TernarDivider!=null) TernarDivider.traverseTopDown(visitor);
        if(Expr11!=null) Expr11.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(TernarStart!=null) TernarStart.traverseBottomUp(visitor);
        if(Expr1!=null) Expr1.traverseBottomUp(visitor);
        if(TernarDivider!=null) TernarDivider.traverseBottomUp(visitor);
        if(Expr11!=null) Expr11.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("TernarExpr(\n");

        if(TernarStart!=null)
            buffer.append(TernarStart.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Expr1!=null)
            buffer.append(Expr1.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(TernarDivider!=null)
            buffer.append(TernarDivider.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Expr11!=null)
            buffer.append(Expr11.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [TernarExpr]");
        return buffer.toString();
    }
}
