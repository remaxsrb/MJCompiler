// generated with ast extension for cup
// version 0.8
// 2/1/2024 19:20:1


package rs.ac.bg.etf.pp1.ast;

public class DesignatorStmtList_Epsilon extends DesignatorStmtList {

    private DesignatorStmtListBegin DesignatorStmtListBegin;

    public DesignatorStmtList_Epsilon (DesignatorStmtListBegin DesignatorStmtListBegin) {
        this.DesignatorStmtListBegin=DesignatorStmtListBegin;
        if(DesignatorStmtListBegin!=null) DesignatorStmtListBegin.setParent(this);
    }

    public DesignatorStmtListBegin getDesignatorStmtListBegin() {
        return DesignatorStmtListBegin;
    }

    public void setDesignatorStmtListBegin(DesignatorStmtListBegin DesignatorStmtListBegin) {
        this.DesignatorStmtListBegin=DesignatorStmtListBegin;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorStmtListBegin!=null) DesignatorStmtListBegin.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorStmtListBegin!=null) DesignatorStmtListBegin.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorStmtListBegin!=null) DesignatorStmtListBegin.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorStmtList_Epsilon(\n");

        if(DesignatorStmtListBegin!=null)
            buffer.append(DesignatorStmtListBegin.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorStmtList_Epsilon]");
        return buffer.toString();
    }
}
