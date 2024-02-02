// generated with ast extension for cup
// version 0.8
// 2/1/2024 19:20:1


package rs.ac.bg.etf.pp1.ast;

public class Designator_Var_solo extends Designator {

    private DesignatorVarName DesignatorVarName;

    public Designator_Var_solo (DesignatorVarName DesignatorVarName) {
        this.DesignatorVarName=DesignatorVarName;
        if(DesignatorVarName!=null) DesignatorVarName.setParent(this);
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
        if(DesignatorVarName!=null) DesignatorVarName.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorVarName!=null) DesignatorVarName.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorVarName!=null) DesignatorVarName.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Designator_Var_solo(\n");

        if(DesignatorVarName!=null)
            buffer.append(DesignatorVarName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Designator_Var_solo]");
        return buffer.toString();
    }
}
