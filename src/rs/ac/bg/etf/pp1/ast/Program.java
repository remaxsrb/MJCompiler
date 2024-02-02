// generated with ast extension for cup
// version 0.8
// 2/1/2024 19:20:1


package rs.ac.bg.etf.pp1.ast;

public class Program implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private ProgramName ProgramName;
    private NamespaceDeclList NamespaceDeclList;
    private DeclList DeclList;
    private MethodDeclList MethodDeclList;

    public Program (ProgramName ProgramName, NamespaceDeclList NamespaceDeclList, DeclList DeclList, MethodDeclList MethodDeclList) {
        this.ProgramName=ProgramName;
        if(ProgramName!=null) ProgramName.setParent(this);
        this.NamespaceDeclList=NamespaceDeclList;
        if(NamespaceDeclList!=null) NamespaceDeclList.setParent(this);
        this.DeclList=DeclList;
        if(DeclList!=null) DeclList.setParent(this);
        this.MethodDeclList=MethodDeclList;
        if(MethodDeclList!=null) MethodDeclList.setParent(this);
    }

    public ProgramName getProgramName() {
        return ProgramName;
    }

    public void setProgramName(ProgramName ProgramName) {
        this.ProgramName=ProgramName;
    }

    public NamespaceDeclList getNamespaceDeclList() {
        return NamespaceDeclList;
    }

    public void setNamespaceDeclList(NamespaceDeclList NamespaceDeclList) {
        this.NamespaceDeclList=NamespaceDeclList;
    }

    public DeclList getDeclList() {
        return DeclList;
    }

    public void setDeclList(DeclList DeclList) {
        this.DeclList=DeclList;
    }

    public MethodDeclList getMethodDeclList() {
        return MethodDeclList;
    }

    public void setMethodDeclList(MethodDeclList MethodDeclList) {
        this.MethodDeclList=MethodDeclList;
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
        if(ProgramName!=null) ProgramName.accept(visitor);
        if(NamespaceDeclList!=null) NamespaceDeclList.accept(visitor);
        if(DeclList!=null) DeclList.accept(visitor);
        if(MethodDeclList!=null) MethodDeclList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ProgramName!=null) ProgramName.traverseTopDown(visitor);
        if(NamespaceDeclList!=null) NamespaceDeclList.traverseTopDown(visitor);
        if(DeclList!=null) DeclList.traverseTopDown(visitor);
        if(MethodDeclList!=null) MethodDeclList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ProgramName!=null) ProgramName.traverseBottomUp(visitor);
        if(NamespaceDeclList!=null) NamespaceDeclList.traverseBottomUp(visitor);
        if(DeclList!=null) DeclList.traverseBottomUp(visitor);
        if(MethodDeclList!=null) MethodDeclList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Program(\n");

        if(ProgramName!=null)
            buffer.append(ProgramName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(NamespaceDeclList!=null)
            buffer.append(NamespaceDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DeclList!=null)
            buffer.append(DeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MethodDeclList!=null)
            buffer.append(MethodDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Program]");
        return buffer.toString();
    }
}
