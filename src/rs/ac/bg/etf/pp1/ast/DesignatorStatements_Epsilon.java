// generated with ast extension for cup
// version 0.8
// 2/1/2024 19:20:1


package rs.ac.bg.etf.pp1.ast;

public class DesignatorStatements_Epsilon extends DesignatorStatements {

    private DesignatorStatementListBegin DesignatorStatementListBegin;

    public DesignatorStatements_Epsilon (DesignatorStatementListBegin DesignatorStatementListBegin) {
        this.DesignatorStatementListBegin=DesignatorStatementListBegin;
        if(DesignatorStatementListBegin!=null) DesignatorStatementListBegin.setParent(this);
    }

    public DesignatorStatementListBegin getDesignatorStatementListBegin() {
        return DesignatorStatementListBegin;
    }

    public void setDesignatorStatementListBegin(DesignatorStatementListBegin DesignatorStatementListBegin) {
        this.DesignatorStatementListBegin=DesignatorStatementListBegin;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorStatementListBegin!=null) DesignatorStatementListBegin.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorStatementListBegin!=null) DesignatorStatementListBegin.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorStatementListBegin!=null) DesignatorStatementListBegin.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorStatements_Epsilon(\n");

        if(DesignatorStatementListBegin!=null)
            buffer.append(DesignatorStatementListBegin.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorStatements_Epsilon]");
        return buffer.toString();
    }
}
