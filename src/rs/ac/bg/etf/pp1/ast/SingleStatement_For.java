// generated with ast extension for cup
// version 0.8
// 2/1/2024 19:20:1


package rs.ac.bg.etf.pp1.ast;

public class SingleStatement_For extends SingleStatement {

    private ForNonTerm ForNonTerm;
    private DesignatorStatements DesignatorStatements;
    private CondFactForBegin CondFactForBegin;
    private CondFactFor CondFactFor;
    private ForCountBegin ForCountBegin;
    private ForCount ForCount;
    private ForBodyBegin ForBodyBegin;
    private ForBody ForBody;

    public SingleStatement_For (ForNonTerm ForNonTerm, DesignatorStatements DesignatorStatements, CondFactForBegin CondFactForBegin, CondFactFor CondFactFor, ForCountBegin ForCountBegin, ForCount ForCount, ForBodyBegin ForBodyBegin, ForBody ForBody) {
        this.ForNonTerm=ForNonTerm;
        if(ForNonTerm!=null) ForNonTerm.setParent(this);
        this.DesignatorStatements=DesignatorStatements;
        if(DesignatorStatements!=null) DesignatorStatements.setParent(this);
        this.CondFactForBegin=CondFactForBegin;
        if(CondFactForBegin!=null) CondFactForBegin.setParent(this);
        this.CondFactFor=CondFactFor;
        if(CondFactFor!=null) CondFactFor.setParent(this);
        this.ForCountBegin=ForCountBegin;
        if(ForCountBegin!=null) ForCountBegin.setParent(this);
        this.ForCount=ForCount;
        if(ForCount!=null) ForCount.setParent(this);
        this.ForBodyBegin=ForBodyBegin;
        if(ForBodyBegin!=null) ForBodyBegin.setParent(this);
        this.ForBody=ForBody;
        if(ForBody!=null) ForBody.setParent(this);
    }

    public ForNonTerm getForNonTerm() {
        return ForNonTerm;
    }

    public void setForNonTerm(ForNonTerm ForNonTerm) {
        this.ForNonTerm=ForNonTerm;
    }

    public DesignatorStatements getDesignatorStatements() {
        return DesignatorStatements;
    }

    public void setDesignatorStatements(DesignatorStatements DesignatorStatements) {
        this.DesignatorStatements=DesignatorStatements;
    }

    public CondFactForBegin getCondFactForBegin() {
        return CondFactForBegin;
    }

    public void setCondFactForBegin(CondFactForBegin CondFactForBegin) {
        this.CondFactForBegin=CondFactForBegin;
    }

    public CondFactFor getCondFactFor() {
        return CondFactFor;
    }

    public void setCondFactFor(CondFactFor CondFactFor) {
        this.CondFactFor=CondFactFor;
    }

    public ForCountBegin getForCountBegin() {
        return ForCountBegin;
    }

    public void setForCountBegin(ForCountBegin ForCountBegin) {
        this.ForCountBegin=ForCountBegin;
    }

    public ForCount getForCount() {
        return ForCount;
    }

    public void setForCount(ForCount ForCount) {
        this.ForCount=ForCount;
    }

    public ForBodyBegin getForBodyBegin() {
        return ForBodyBegin;
    }

    public void setForBodyBegin(ForBodyBegin ForBodyBegin) {
        this.ForBodyBegin=ForBodyBegin;
    }

    public ForBody getForBody() {
        return ForBody;
    }

    public void setForBody(ForBody ForBody) {
        this.ForBody=ForBody;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ForNonTerm!=null) ForNonTerm.accept(visitor);
        if(DesignatorStatements!=null) DesignatorStatements.accept(visitor);
        if(CondFactForBegin!=null) CondFactForBegin.accept(visitor);
        if(CondFactFor!=null) CondFactFor.accept(visitor);
        if(ForCountBegin!=null) ForCountBegin.accept(visitor);
        if(ForCount!=null) ForCount.accept(visitor);
        if(ForBodyBegin!=null) ForBodyBegin.accept(visitor);
        if(ForBody!=null) ForBody.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ForNonTerm!=null) ForNonTerm.traverseTopDown(visitor);
        if(DesignatorStatements!=null) DesignatorStatements.traverseTopDown(visitor);
        if(CondFactForBegin!=null) CondFactForBegin.traverseTopDown(visitor);
        if(CondFactFor!=null) CondFactFor.traverseTopDown(visitor);
        if(ForCountBegin!=null) ForCountBegin.traverseTopDown(visitor);
        if(ForCount!=null) ForCount.traverseTopDown(visitor);
        if(ForBodyBegin!=null) ForBodyBegin.traverseTopDown(visitor);
        if(ForBody!=null) ForBody.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ForNonTerm!=null) ForNonTerm.traverseBottomUp(visitor);
        if(DesignatorStatements!=null) DesignatorStatements.traverseBottomUp(visitor);
        if(CondFactForBegin!=null) CondFactForBegin.traverseBottomUp(visitor);
        if(CondFactFor!=null) CondFactFor.traverseBottomUp(visitor);
        if(ForCountBegin!=null) ForCountBegin.traverseBottomUp(visitor);
        if(ForCount!=null) ForCount.traverseBottomUp(visitor);
        if(ForBodyBegin!=null) ForBodyBegin.traverseBottomUp(visitor);
        if(ForBody!=null) ForBody.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("SingleStatement_For(\n");

        if(ForNonTerm!=null)
            buffer.append(ForNonTerm.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DesignatorStatements!=null)
            buffer.append(DesignatorStatements.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(CondFactForBegin!=null)
            buffer.append(CondFactForBegin.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(CondFactFor!=null)
            buffer.append(CondFactFor.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ForCountBegin!=null)
            buffer.append(ForCountBegin.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ForCount!=null)
            buffer.append(ForCount.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ForBodyBegin!=null)
            buffer.append(ForBodyBegin.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ForBody!=null)
            buffer.append(ForBody.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [SingleStatement_For]");
        return buffer.toString();
    }
}
