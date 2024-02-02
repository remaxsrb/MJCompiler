// generated with ast extension for cup
// version 0.8
// 2/1/2024 19:20:1


package rs.ac.bg.etf.pp1.ast;

public class Designator_Namespace_var extends Designator {

    private DesignatorNamespaceName DesignatorNamespaceName;
    private DesignatorVarName DesignatorVarName;

    public Designator_Namespace_var (DesignatorNamespaceName DesignatorNamespaceName, DesignatorVarName DesignatorVarName) {
        this.DesignatorNamespaceName=DesignatorNamespaceName;
        if(DesignatorNamespaceName!=null) DesignatorNamespaceName.setParent(this);
        this.DesignatorVarName=DesignatorVarName;
        if(DesignatorVarName!=null) DesignatorVarName.setParent(this);
    }

    public DesignatorNamespaceName getDesignatorNamespaceName() {
        return DesignatorNamespaceName;
    }

    public void setDesignatorNamespaceName(DesignatorNamespaceName DesignatorNamespaceName) {
        this.DesignatorNamespaceName=DesignatorNamespaceName;
    }

    public DesignatorVarName getDesignatorVarName() {
        return DesignatorVarName;
    }

    public void setDesignatorVarName(DesignatorVarName DesignatorVarName) {
        this.DesignatorVarName=DesignatorVarName;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorNamespaceName!=null) DesignatorNamespaceName.accept(visitor);
        if(DesignatorVarName!=null) DesignatorVarName.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorNamespaceName!=null) DesignatorNamespaceName.traverseTopDown(visitor);
        if(DesignatorVarName!=null) DesignatorVarName.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorNamespaceName!=null) DesignatorNamespaceName.traverseBottomUp(visitor);
        if(DesignatorVarName!=null) DesignatorVarName.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Designator_Namespace_var(\n");

        if(DesignatorNamespaceName!=null)
            buffer.append(DesignatorNamespaceName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DesignatorVarName!=null)
            buffer.append(DesignatorVarName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Designator_Namespace_var]");
        return buffer.toString();
    }
}
