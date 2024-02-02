// generated with ast extension for cup
// version 0.8
// 2/1/2024 19:20:1


package rs.ac.bg.etf.pp1.ast;

public class FormParMore_comma extends FormParMore {

    private FormPar FormPar;
    private FormParMore FormParMore;

    public FormParMore_comma (FormPar FormPar, FormParMore FormParMore) {
        this.FormPar=FormPar;
        if(FormPar!=null) FormPar.setParent(this);
        this.FormParMore=FormParMore;
        if(FormParMore!=null) FormParMore.setParent(this);
    }

    public FormPar getFormPar() {
        return FormPar;
    }

    public void setFormPar(FormPar FormPar) {
        this.FormPar=FormPar;
    }

    public FormParMore getFormParMore() {
        return FormParMore;
    }

    public void setFormParMore(FormParMore FormParMore) {
        this.FormParMore=FormParMore;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(FormPar!=null) FormPar.accept(visitor);
        if(FormParMore!=null) FormParMore.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FormPar!=null) FormPar.traverseTopDown(visitor);
        if(FormParMore!=null) FormParMore.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FormPar!=null) FormPar.traverseBottomUp(visitor);
        if(FormParMore!=null) FormParMore.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FormParMore_comma(\n");

        if(FormPar!=null)
            buffer.append(FormPar.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FormParMore!=null)
            buffer.append(FormParMore.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FormParMore_comma]");
        return buffer.toString();
    }
}
