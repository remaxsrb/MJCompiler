// generated with ast extension for cup
// version 0.8
// 2/1/2024 19:20:1


package rs.ac.bg.etf.pp1.ast;

public class Expr implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    public rs.etf.pp1.symboltable.concepts.Struct struct = null;

    private AddOpList AddOpList;

    public Expr (AddOpList AddOpList) {
        this.AddOpList=AddOpList;
        if(AddOpList!=null) AddOpList.setParent(this);
    }

    public AddOpList getAddOpList() {
        return AddOpList;
    }

    public void setAddOpList(AddOpList AddOpList) {
        this.AddOpList=AddOpList;
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
        if(AddOpList!=null) AddOpList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(AddOpList!=null) AddOpList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(AddOpList!=null) AddOpList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Expr(\n");

        if(AddOpList!=null)
            buffer.append(AddOpList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Expr]");
        return buffer.toString();
    }
}
