// generated with ast extension for cup
// version 0.8
// 2/1/2024 19:20:1


package rs.ac.bg.etf.pp1.ast;

public class DesignatorStmtList_List extends DesignatorStmtList {

    private DesignatorStmtListBegin DesignatorStmtListBegin;
    private DesignatorOption DesignatorOption;
    private DesignatorStmtMore DesignatorStmtMore;

    public DesignatorStmtList_List (DesignatorStmtListBegin DesignatorStmtListBegin, DesignatorOption DesignatorOption, DesignatorStmtMore DesignatorStmtMore) {
        this.DesignatorStmtListBegin=DesignatorStmtListBegin;
        if(DesignatorStmtListBegin!=null) DesignatorStmtListBegin.setParent(this);
        this.DesignatorOption=DesignatorOption;
        if(DesignatorOption!=null) DesignatorOption.setParent(this);
        this.DesignatorStmtMore=DesignatorStmtMore;
        if(DesignatorStmtMore!=null) DesignatorStmtMore.setParent(this);
    }

    public DesignatorStmtListBegin getDesignatorStmtListBegin() {
        return DesignatorStmtListBegin;
    }

    public void setDesignatorStmtListBegin(DesignatorStmtListBegin DesignatorStmtListBegin) {
        this.DesignatorStmtListBegin=DesignatorStmtListBegin;
    }

    public DesignatorOption getDesignatorOption() {
        return DesignatorOption;
    }

    public void setDesignatorOption(DesignatorOption DesignatorOption) {
        this.DesignatorOption=DesignatorOption;
    }

    public DesignatorStmtMore getDesignatorStmtMore() {
        return DesignatorStmtMore;
    }

    public void setDesignatorStmtMore(DesignatorStmtMore DesignatorStmtMore) {
        this.DesignatorStmtMore=DesignatorStmtMore;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorStmtListBegin!=null) DesignatorStmtListBegin.accept(visitor);
        if(DesignatorOption!=null) DesignatorOption.accept(visitor);
        if(DesignatorStmtMore!=null) DesignatorStmtMore.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorStmtListBegin!=null) DesignatorStmtListBegin.traverseTopDown(visitor);
        if(DesignatorOption!=null) DesignatorOption.traverseTopDown(visitor);
        if(DesignatorStmtMore!=null) DesignatorStmtMore.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorStmtListBegin!=null) DesignatorStmtListBegin.traverseBottomUp(visitor);
        if(DesignatorOption!=null) DesignatorOption.traverseBottomUp(visitor);
        if(DesignatorStmtMore!=null) DesignatorStmtMore.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorStmtList_List(\n");

        if(DesignatorStmtListBegin!=null)
            buffer.append(DesignatorStmtListBegin.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DesignatorOption!=null)
            buffer.append(DesignatorOption.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DesignatorStmtMore!=null)
            buffer.append(DesignatorStmtMore.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorStmtList_List]");
        return buffer.toString();
    }
}
