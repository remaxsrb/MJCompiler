package rs.ac.bg.etf.pp1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.concepts.*;

public class DesignatorCounter extends VisitorAdaptor {
	
	List<Obj> designatorList = new ArrayList<>();
	
	int designator_option_no_counter = 0 ;
		
	
	@Override
	public void visit (DesignatorOption_Yes designatorOption_Yes) {
		designatorList.add(designatorOption_Yes.getDesignator().obj);
	}
	
	@Override
	public void visit (DesignatorOption_No designatorOption_No) {
		designator_option_no_counter++;
	}
	
	
}
