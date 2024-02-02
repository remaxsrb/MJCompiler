// generated with ast extension for cup
// version 0.8
// 2/1/2024 19:20:1


package rs.ac.bg.etf.pp1.ast;

public class ForCount implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private DesignatorStatements DesignatorStatements;

    public ForCount (DesignatorStatements DesignatorStatements) {
        this.DesignatorStatements=DesignatorStatements;
        if(DesignatorStatements!=null) DesignatorStatements.setParent(this);
    }

    public DesignatorStatements getDesignatorStatements() {
        return DesignatorStatements;
    }

    public void setDesignatorStatements(DesignatorStatements DesignatorStatements) {
        this.DesignatorStatements=DesignatorStatements;
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
        if(DesignatorStatements!=null) DesignatorStatements.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorStatements!=null) DesignatorStatements.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorStatements!=null) DesignatorStatements.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ForCount(\n");

        if(DesignatorStatements!=null)
            buffer.append(DesignatorStatements.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ForCount]");
        return buffer.toString();
    }
}
