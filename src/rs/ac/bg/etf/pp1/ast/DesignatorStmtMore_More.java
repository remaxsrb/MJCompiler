// generated with ast extension for cup
// version 0.8
// 2/1/2024 19:20:1


package rs.ac.bg.etf.pp1.ast;

public class DesignatorStmtMore_More extends DesignatorStmtMore {

    private DesignatorOption DesignatorOption;
    private DesignatorStmtMore DesignatorStmtMore;

    public DesignatorStmtMore_More (DesignatorOption DesignatorOption, DesignatorStmtMore DesignatorStmtMore) {
        this.DesignatorOption=DesignatorOption;
        if(DesignatorOption!=null) DesignatorOption.setParent(this);
        this.DesignatorStmtMore=DesignatorStmtMore;
        if(DesignatorStmtMore!=null) DesignatorStmtMore.setParent(this);
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
        if(DesignatorOption!=null) DesignatorOption.accept(visitor);
        if(DesignatorStmtMore!=null) DesignatorStmtMore.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorOption!=null) DesignatorOption.traverseTopDown(visitor);
        if(DesignatorStmtMore!=null) DesignatorStmtMore.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorOption!=null) DesignatorOption.traverseBottomUp(visitor);
        if(DesignatorStmtMore!=null) DesignatorStmtMore.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorStmtMore_More(\n");

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
        buffer.append(") [DesignatorStmtMore_More]");
        return buffer.toString();
    }
}
