// generated with ast extension for cup
// version 0.8
// 16/0/2021 21:30:43


package rs.ac.bg.etf.pp1.ast;

public class MultipleTerms extends TermList {

    private TermList TermList;
    private AddOperator AddOperator;
    private Term Term;

    public MultipleTerms (TermList TermList, AddOperator AddOperator, Term Term) {
        this.TermList=TermList;
        if(TermList!=null) TermList.setParent(this);
        this.AddOperator=AddOperator;
        if(AddOperator!=null) AddOperator.setParent(this);
        this.Term=Term;
        if(Term!=null) Term.setParent(this);
    }

    public TermList getTermList() {
        return TermList;
    }

    public void setTermList(TermList TermList) {
        this.TermList=TermList;
    }

    public AddOperator getAddOperator() {
        return AddOperator;
    }

    public void setAddOperator(AddOperator AddOperator) {
        this.AddOperator=AddOperator;
    }

    public Term getTerm() {
        return Term;
    }

    public void setTerm(Term Term) {
        this.Term=Term;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(TermList!=null) TermList.accept(visitor);
        if(AddOperator!=null) AddOperator.accept(visitor);
        if(Term!=null) Term.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(TermList!=null) TermList.traverseTopDown(visitor);
        if(AddOperator!=null) AddOperator.traverseTopDown(visitor);
        if(Term!=null) Term.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(TermList!=null) TermList.traverseBottomUp(visitor);
        if(AddOperator!=null) AddOperator.traverseBottomUp(visitor);
        if(Term!=null) Term.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MultipleTerms(\n");

        if(TermList!=null)
            buffer.append(TermList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(AddOperator!=null)
            buffer.append(AddOperator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Term!=null)
            buffer.append(Term.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MultipleTerms]");
        return buffer.toString();
    }
}
