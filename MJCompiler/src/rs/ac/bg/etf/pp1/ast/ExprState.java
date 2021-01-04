// generated with ast extension for cup
// version 0.8
// 2/0/2021 18:4:17


package rs.ac.bg.etf.pp1.ast;

public class ExprState extends Expr1 {

    private OptionalMinusVar OptionalMinusVar;
    private Term Term;
    private TermList TermList;

    public ExprState (OptionalMinusVar OptionalMinusVar, Term Term, TermList TermList) {
        this.OptionalMinusVar=OptionalMinusVar;
        if(OptionalMinusVar!=null) OptionalMinusVar.setParent(this);
        this.Term=Term;
        if(Term!=null) Term.setParent(this);
        this.TermList=TermList;
        if(TermList!=null) TermList.setParent(this);
    }

    public OptionalMinusVar getOptionalMinusVar() {
        return OptionalMinusVar;
    }

    public void setOptionalMinusVar(OptionalMinusVar OptionalMinusVar) {
        this.OptionalMinusVar=OptionalMinusVar;
    }

    public Term getTerm() {
        return Term;
    }

    public void setTerm(Term Term) {
        this.Term=Term;
    }

    public TermList getTermList() {
        return TermList;
    }

    public void setTermList(TermList TermList) {
        this.TermList=TermList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(OptionalMinusVar!=null) OptionalMinusVar.accept(visitor);
        if(Term!=null) Term.accept(visitor);
        if(TermList!=null) TermList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(OptionalMinusVar!=null) OptionalMinusVar.traverseTopDown(visitor);
        if(Term!=null) Term.traverseTopDown(visitor);
        if(TermList!=null) TermList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(OptionalMinusVar!=null) OptionalMinusVar.traverseBottomUp(visitor);
        if(Term!=null) Term.traverseBottomUp(visitor);
        if(TermList!=null) TermList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ExprState(\n");

        if(OptionalMinusVar!=null)
            buffer.append(OptionalMinusVar.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Term!=null)
            buffer.append(Term.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(TermList!=null)
            buffer.append(TermList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ExprState]");
        return buffer.toString();
    }
}
