// generated with ast extension for cup
// version 0.8
// 2/1/2024 19:20:1


package rs.ac.bg.etf.pp1.ast;

public class DesignatorStatement_Smth extends DesignatorStatementSingle {

    private DesignatorStmtList DesignatorStmtList;
    private Designator Designator;
    private Designator Designator1;

    public DesignatorStatement_Smth (DesignatorStmtList DesignatorStmtList, Designator Designator, Designator Designator1) {
        this.DesignatorStmtList=DesignatorStmtList;
        if(DesignatorStmtList!=null) DesignatorStmtList.setParent(this);
        this.Designator=Designator;
        if(Designator!=null) Designator.setParent(this);
        this.Designator1=Designator1;
        if(Designator1!=null) Designator1.setParent(this);
    }

    public DesignatorStmtList getDesignatorStmtList() {
        return DesignatorStmtList;
    }

    public void setDesignatorStmtList(DesignatorStmtList DesignatorStmtList) {
        this.DesignatorStmtList=DesignatorStmtList;
    }

    public Designator getDesignator() {
        return Designator;
    }

    public void setDesignator(Designator Designator) {
        this.Designator=Designator;
    }

    public Designator getDesignator1() {
        return Designator1;
    }

    public void setDesignator1(Designator Designator1) {
        this.Designator1=Designator1;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorStmtList!=null) DesignatorStmtList.accept(visitor);
        if(Designator!=null) Designator.accept(visitor);
        if(Designator1!=null) Designator1.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorStmtList!=null) DesignatorStmtList.traverseTopDown(visitor);
        if(Designator!=null) Designator.traverseTopDown(visitor);
        if(Designator1!=null) Designator1.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorStmtList!=null) DesignatorStmtList.traverseBottomUp(visitor);
        if(Designator!=null) Designator.traverseBottomUp(visitor);
        if(Designator1!=null) Designator1.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorStatement_Smth(\n");

        if(DesignatorStmtList!=null)
            buffer.append(DesignatorStmtList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Designator!=null)
            buffer.append(Designator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Designator1!=null)
            buffer.append(Designator1.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorStatement_Smth]");
        return buffer.toString();
    }
}
