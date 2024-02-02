package rs.ac.bg.etf.pp1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.concepts.*;

public class DesignatorCounter extends VisitorAdaptor {
	
	List<Obj> finalactDesignatorList = new ArrayList<>();
	
	Stack<List<Obj>> designatorLists = new Stack<>();
	
	@Override
	public void visit (DesignatorStmtListBegin designatorStmtListBegin) {
		designatorLists.push(new ArrayList<>());
	}
	
	@Override
	public void visit (DesignatorOption_Yes designatorOption_Yes) {
		designatorLists.peek().add(designatorOption_Yes.getDesignator().obj);
	}
	
	@Override
	public void visit (DesignatorStmtList_List designatorStmtList_List) {
		finalactDesignatorList = designatorLists.pop();
	}
	
	@Override
	public void visit (DesignatorStmtList_Epsilon designatorStmtList_Epsilon) {
		finalactDesignatorList = designatorLists.pop();
	}

}
