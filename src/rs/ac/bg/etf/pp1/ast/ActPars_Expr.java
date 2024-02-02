// generated with ast extension for cup
// version 0.8
// 2/1/2024 19:20:1


package rs.ac.bg.etf.pp1.ast;

public class ActPars_Expr extends ActPars {

    private ActParListBegin ActParListBegin;
    private ActPar ActPar;
    private ActParsMore ActParsMore;

    public ActPars_Expr (ActParListBegin ActParListBegin, ActPar ActPar, ActParsMore ActParsMore) {
        this.ActParListBegin=ActParListBegin;
        if(ActParListBegin!=null) ActParListBegin.setParent(this);
        this.ActPar=ActPar;
        if(ActPar!=null) ActPar.setParent(this);
        this.ActParsMore=ActParsMore;
        if(ActParsMore!=null) ActParsMore.setParent(this);
    }

    public ActParListBegin getActParListBegin() {
        return ActParListBegin;
    }

    public void setActParListBegin(ActParListBegin ActParListBegin) {
        this.ActParListBegin=ActParListBegin;
    }

    public ActPar getActPar() {
        return ActPar;
    }

    public void setActPar(ActPar ActPar) {
        this.ActPar=ActPar;
    }

    public ActParsMore getActParsMore() {
        return ActParsMore;
    }

    public void setActParsMore(ActParsMore ActParsMore) {
        this.ActParsMore=ActParsMore;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ActParListBegin!=null) ActParListBegin.accept(visitor);
        if(ActPar!=null) ActPar.accept(visitor);
        if(ActParsMore!=null) ActParsMore.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ActParListBegin!=null) ActParListBegin.traverseTopDown(visitor);
        if(ActPar!=null) ActPar.traverseTopDown(visitor);
        if(ActParsMore!=null) ActParsMore.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ActParListBegin!=null) ActParListBegin.traverseBottomUp(visitor);
        if(ActPar!=null) ActPar.traverseBottomUp(visitor);
        if(ActParsMore!=null) ActParsMore.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ActPars_Expr(\n");

        if(ActParListBegin!=null)
            buffer.append(ActParListBegin.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ActPar!=null)
            buffer.append(ActPar.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ActParsMore!=null)
            buffer.append(ActParsMore.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ActPars_Expr]");
        return buffer.toString();
    }
}
