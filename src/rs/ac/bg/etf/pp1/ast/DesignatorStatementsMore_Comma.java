// generated with ast extension for cup
// version 0.8
// 2/1/2024 19:20:1


package rs.ac.bg.etf.pp1.ast;

public class DesignatorStatementsMore_Comma extends DesignatorStatementsMore {

    private DesignatorStatement DesignatorStatement;
    private DesignatorStatementsMore DesignatorStatementsMore;

    public DesignatorStatementsMore_Comma (DesignatorStatement DesignatorStatement, DesignatorStatementsMore DesignatorStatementsMore) {
        this.DesignatorStatement=DesignatorStatement;
        if(DesignatorStatement!=null) DesignatorStatement.setParent(this);
        this.DesignatorStatementsMore=DesignatorStatementsMore;
        if(DesignatorStatementsMore!=null) DesignatorStatementsMore.setParent(this);
    }

    public DesignatorStatement getDesignatorStatement() {
        return DesignatorStatement;
    }

    public void setDesignatorStatement(DesignatorStatement DesignatorStatement) {
        this.DesignatorStatement=DesignatorStatement;
    }

    public DesignatorStatementsMore getDesignatorStatementsMore() {
        return DesignatorStatementsMore;
    }

    public void setDesignatorStatementsMore(DesignatorStatementsMore DesignatorStatementsMore) {
        this.DesignatorStatementsMore=DesignatorStatementsMore;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorStatement!=null) DesignatorStatement.accept(visitor);
        if(DesignatorStatementsMore!=null) DesignatorStatementsMore.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorStatement!=null) DesignatorStatement.traverseTopDown(visitor);
        if(DesignatorStatementsMore!=null) DesignatorStatementsMore.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorStatement!=null) DesignatorStatement.traverseBottomUp(visitor);
        if(DesignatorStatementsMore!=null) DesignatorStatementsMore.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorStatementsMore_Comma(\n");

        if(DesignatorStatement!=null)
            buffer.append(DesignatorStatement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DesignatorStatementsMore!=null)
            buffer.append(DesignatorStatementsMore.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorStatementsMore_Comma]");
        return buffer.toString();
    }
}
