// generated with ast extension for cup
// version 0.8
// 2/1/2024 19:20:1


package rs.ac.bg.etf.pp1.ast;

public class DesignatorStatement_S extends DesignatorStatement {

    private DesignatorStatementSingle DesignatorStatementSingle;

    public DesignatorStatement_S (DesignatorStatementSingle DesignatorStatementSingle) {
        this.DesignatorStatementSingle=DesignatorStatementSingle;
        if(DesignatorStatementSingle!=null) DesignatorStatementSingle.setParent(this);
    }

    public DesignatorStatementSingle getDesignatorStatementSingle() {
        return DesignatorStatementSingle;
    }

    public void setDesignatorStatementSingle(DesignatorStatementSingle DesignatorStatementSingle) {
        this.DesignatorStatementSingle=DesignatorStatementSingle;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorStatementSingle!=null) DesignatorStatementSingle.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorStatementSingle!=null) DesignatorStatementSingle.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorStatementSingle!=null) DesignatorStatementSingle.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorStatement_S(\n");

        if(DesignatorStatementSingle!=null)
            buffer.append(DesignatorStatementSingle.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorStatement_S]");
        return buffer.toString();
    }
}
