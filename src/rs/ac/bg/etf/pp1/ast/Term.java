// generated with ast extension for cup
// version 0.8
// 2/1/2024 19:20:1


package rs.ac.bg.etf.pp1.ast;

public class Term implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    public rs.etf.pp1.symboltable.concepts.Struct struct = null;

    private MulOpList MulOpList;

    public Term (MulOpList MulOpList) {
        this.MulOpList=MulOpList;
        if(MulOpList!=null) MulOpList.setParent(this);
    }

    public MulOpList getMulOpList() {
        return MulOpList;
    }

    public void setMulOpList(MulOpList MulOpList) {
        this.MulOpList=MulOpList;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(MulOpList!=null) MulOpList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MulOpList!=null) MulOpList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MulOpList!=null) MulOpList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Term(\n");

        if(MulOpList!=null)
            buffer.append(MulOpList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Term]");
        return buffer.toString();
    }
}
