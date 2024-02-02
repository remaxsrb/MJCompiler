// generated with ast extension for cup
// version 0.8
// 2/1/2024 19:20:1


package rs.ac.bg.etf.pp1.ast;

public class MethodDecl implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private MethodReturnAndName MethodReturnAndName;
    private FormParList FormParList;
    private LocalVarDeclList LocalVarDeclList;
    private StatementList StatementList;

    public MethodDecl (MethodReturnAndName MethodReturnAndName, FormParList FormParList, LocalVarDeclList LocalVarDeclList, StatementList StatementList) {
        this.MethodReturnAndName=MethodReturnAndName;
        if(MethodReturnAndName!=null) MethodReturnAndName.setParent(this);
        this.FormParList=FormParList;
        if(FormParList!=null) FormParList.setParent(this);
        this.LocalVarDeclList=LocalVarDeclList;
        if(LocalVarDeclList!=null) LocalVarDeclList.setParent(this);
        this.StatementList=StatementList;
        if(StatementList!=null) StatementList.setParent(this);
    }

    public MethodReturnAndName getMethodReturnAndName() {
        return MethodReturnAndName;
    }

    public void setMethodReturnAndName(MethodReturnAndName MethodReturnAndName) {
        this.MethodReturnAndName=MethodReturnAndName;
    }

    public FormParList getFormParList() {
        return FormParList;
    }

    public void setFormParList(FormParList FormParList) {
        this.FormParList=FormParList;
    }

    public LocalVarDeclList getLocalVarDeclList() {
        return LocalVarDeclList;
    }

    public void setLocalVarDeclList(LocalVarDeclList LocalVarDeclList) {
        this.LocalVarDeclList=LocalVarDeclList;
    }

    public StatementList getStatementList() {
        return StatementList;
    }

    public void setStatementList(StatementList StatementList) {
        this.StatementList=StatementList;
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
        if(MethodReturnAndName!=null) MethodReturnAndName.accept(visitor);
        if(FormParList!=null) FormParList.accept(visitor);
        if(LocalVarDeclList!=null) LocalVarDeclList.accept(visitor);
        if(StatementList!=null) StatementList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MethodReturnAndName!=null) MethodReturnAndName.traverseTopDown(visitor);
        if(FormParList!=null) FormParList.traverseTopDown(visitor);
        if(LocalVarDeclList!=null) LocalVarDeclList.traverseTopDown(visitor);
        if(StatementList!=null) StatementList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MethodReturnAndName!=null) MethodReturnAndName.traverseBottomUp(visitor);
        if(FormParList!=null) FormParList.traverseBottomUp(visitor);
        if(LocalVarDeclList!=null) LocalVarDeclList.traverseBottomUp(visitor);
        if(StatementList!=null) StatementList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MethodDecl(\n");

        if(MethodReturnAndName!=null)
            buffer.append(MethodReturnAndName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FormParList!=null)
            buffer.append(FormParList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(LocalVarDeclList!=null)
            buffer.append(LocalVarDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(StatementList!=null)
            buffer.append(StatementList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MethodDecl]");
        return buffer.toString();
    }
}
