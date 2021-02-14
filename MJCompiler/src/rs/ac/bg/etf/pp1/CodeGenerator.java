package rs.ac.bg.etf.pp1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Stack;

import rs.ac.bg.etf.pp1.ast.*;
import rs.ac.bg.etf.pp1.ast.VisitorAdaptor;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.*;

public class CodeGenerator extends VisitorAdaptor {

	private int mainPC;
	private String currentMethodDeclaration = null;;

	public int getMainPC() {
		return mainPC;
	}

	Obj programObj;
	Stack<Boolean> ternarCond = new Stack<>();
	Boolean currentTernarCond = false;

	/*********************************************************************************************************/
	// Method declaration

	public void visit(MethodRetName methodRetName) {
		if ("main".equals(methodRetName.getMethodName())) {
			mainPC = Code.pc;
		}
		Obj obj = methodRetName.obj;
		currentMethodDeclaration = methodRetName.getMethodName();
		obj.setAdr(Code.pc);
		Code.put(Code.enter);
		Code.put(obj.getLevel());
		Code.put(obj.getLocalSymbols().size());
	}

	public void visit(MethodDecl methodDecl) {
		Obj obj = methodDecl.getMethodRetName().obj;
		if (obj.getType().equals(Tab.noType)) {
			Code.put(Code.exit);
			Code.put(Code.return_);
		} else {
			Code.put(Code.trap);
			Code.put(Code.const_n);
		}

	}

	public void visit(ReturnExpr returnExpr) {
		Code.put(Code.exit);
		Code.put(Code.return_);
	}

	public void visit(ReturnNoExpr returnNoExpr) {
		Code.put(Code.exit);
		Code.put(Code.return_);
	}

	/***********************************************************************************/

	/***********************************************************************************/
	// Print statement

	public void visit(PrintStmt printStmt) {
		Code.loadConst(printStmt.getOptionalPrintParam().struct.getKind());
		if (printStmt.getExpr().struct.getKind() == Struct.Char) {
			Code.put(Code.bprint);
		} else {
			Code.put(Code.print);
		}
	}

	public void visit(AditionalParamPrint aditionalParamPrint) {
		aditionalParamPrint.struct = new Struct(aditionalParamPrint.getN1());
	}

	public void visit(NoAditionalParamPrint noAditionalParamPrint) {
		PrintStmt stmt = (PrintStmt) noAditionalParamPrint.getParent();
		switch (stmt.getExpr().struct.getKind()) {
		case Struct.Int:
			noAditionalParamPrint.struct = new Struct(10);
			break;
		case Struct.Bool:
			noAditionalParamPrint.struct = new Struct(1);
			break;
		case Struct.Char:
			noAditionalParamPrint.struct = new Struct(1);
			break;
		default:
			break;
		}
	}

	/*******************************************************************************************/

	/*******************************************************************************************/
	// Factor

	public void visit(BoolConst constBooleanType) {
		Obj con = Tab.insert(Obj.Con, "$", constBooleanType.struct);
		con.setLevel(0);
		con.setAdr(constBooleanType.getB1().equals("true") ? 1 : 0);
		Code.load(con);
	}

	public void visit(CharConst constCharType) {
		Obj con = Tab.insert(Obj.Con, "$", constCharType.struct);
		con.setLevel(0);
		con.setAdr(constCharType.getC1());
		Code.load(con);
	}

	public void visit(NumConst conIntType) {
		Obj con = Tab.insert(Obj.Con, "$", conIntType.struct);
		con.setLevel(0);
		con.setAdr(conIntType.getN1());
		Code.load(con);
	}

	public void visit(Var var) {
		Struct struct = var.getDesignator().struct;
		Obj obj = findSymbol(currentMethodDeclaration, var.getDesignator().getVariableName());
		if (struct.getKind() != Struct.Array && obj.getType().getElemType() != null)
			obj = new Obj(Obj.Elem, "$", obj.getType().getElemType());
		Code.load(obj);
	}

	public void visit(MultipleFactors multipleFactors) {
		if (multipleFactors.getMultiplyOperator().getClass() == MultiplyOp.class) {
			Code.put(Code.mul);
		}
		if (multipleFactors.getMultiplyOperator().getClass() == DivideOp.class) {
			Code.put(Code.div);
		}
		if (multipleFactors.getMultiplyOperator().getClass() == ModuloOp.class) {
			Code.put(Code.rem);
		}
	}

	public void visit(MultipleTerms multipleTerms) {
		if (multipleTerms.getAddOperator().getClass() == PlusOp.class) {
			Code.put(Code.add);
		}
		if (multipleTerms.getAddOperator().getClass() == MinusOp.class) {
			Code.put(Code.sub);
		}
	}

	public void visit(NewOperator newOperator) {
		int arrayType = 1;
		if (newOperator.getType().struct.equals(Tab.charType))
			arrayType = 0;
		Code.put(Code.newarray);
		Code.put(arrayType);
	}

	public void visit(OneTerm oneTerm) {
		SyntaxNode sN = oneTerm;
		while (true) {
			if (sN.getClass() == BasicExpressionWithMinus.class) {
				Code.put(Code.neg);
				break;
			}
			if (sN.getClass() == BasicExpressionWithOutMinus.class) {
				break;
			}
			sN = sN.getParent();
		}
	}

	/**********************************************************************************************************/

	public void visit(ProgramName progName) {
		programObj = Tab.find(progName.getProgramName());
		addLenMethod();
		addChrMethod();
		addOrdMethod();
	}

	private void addLenMethod() {
		Obj obj = findSymbol(null, "len");
		obj.setAdr(Code.pc);
		Code.put(Code.enter);
		Code.put(obj.getLevel());
		Code.put(obj.getLocalSymbols().size());
		Code.put(Code.load_n);
		Code.put(Code.arraylength);
		Code.put(Code.exit);
		Code.put(Code.return_);
	}

	private void addChrMethod() {
		Obj obj = findSymbol(null, "chr");
		obj.setAdr(Code.pc);
		Code.put(Code.enter);
		Code.put(obj.getLevel());
		Code.put(obj.getLocalSymbols().size());
		Code.put(Code.load_n);
		Code.put(Code.exit);
		Code.put(Code.return_);
	}

	private void addOrdMethod() {
		Obj obj = findSymbol(null, "ord");
		obj.setAdr(Code.pc);
		Code.put(Code.enter);
		Code.put(obj.getLevel());
		Code.put(obj.getLocalSymbols().size());
		Code.put(Code.load_n);
		Code.put(Code.exit);
		Code.put(Code.return_);
	}

	private Obj findSymbol(String methodName, String varName) {
		Collection<Obj> symbols = null;
		if (methodName != null) {
			symbols = programObj.getLocalSymbols().stream().filter((Obj obj) -> {
				return obj.getName().equals(methodName);
			}).findFirst().orElse(new Obj(Obj.Meth, "$", Tab.noType)).getLocalSymbols();
			if (symbols != null) {
				Obj help = symbols.stream().filter((Obj obj) -> {
					return obj.getName().equals(varName);
				}).findFirst().orElse(null);
				if (help != null)
					return help;
			}
		}
		symbols = programObj.getLocalSymbols();
		Obj symbol = symbols.stream().filter((Obj obj) -> {
			return obj.getName().equals(varName);
		}).findFirst().orElse(null);
		if (symbol == null) {
			symbol = Tab.find(varName);
		}
		return symbol;
	}

	/*************************************************************************************************************/
	// Designator statement

	public void visit(IncrementDesignator increment) {
		Struct struct = increment.getDesignator().struct;
		Obj obj = findSymbol(currentMethodDeclaration, increment.getDesignator().getVariableName());
		if (struct.getKind() != Struct.Array && obj.getType().getElemType() != null) {
			Obj helpElem = new Obj(Obj.Elem, "$", obj.getType().getElemType());
			Code.put(Code.dup2);
			Code.load(helpElem);
			Code.put(Code.const_1);
			Code.put(Code.add);
			Code.store(helpElem);
		} else {
			Code.load(obj);
			Code.put(Code.const_1);
			Code.put(Code.add);
			Code.store(obj);
		}
	}

	public void visit(DecrementDesignator increment) {
		Struct struct = increment.getDesignator().struct;
		Obj obj = findSymbol(currentMethodDeclaration, increment.getDesignator().getVariableName());
		if (struct.getKind() != Struct.Array && obj.getType().getElemType() != null) {
			Obj helpElem = new Obj(Obj.Elem, "$", obj.getType().getElemType());
			Code.put(Code.dup2);
			Code.load(helpElem);
			Code.put(Code.const_1);
			Code.put(Code.sub);
			Code.store(helpElem);
		} else {
			Code.load(obj);
			Code.put(Code.const_1);
			Code.put(Code.sub);
			Code.store(obj);
		}
	}

	public void visit(FuncCall funcCall) {
		Obj functionObj = findSymbol(currentMethodDeclaration,
				funcCall.getFuncCallStart().getDesignator().getVariableName());
		int offset = functionObj.getAdr() - Code.pc;
		Code.put(Code.call);
		Code.put2(offset);
	}

	public void visit(DesignatorStatementFunctionCall des) {
		String methodName = des.getFuncCall().getFuncCallStart().getDesignator().getVariableName();
		Obj obj = findSymbol(currentMethodDeclaration, methodName);
		if (obj.getType().getKind() != Struct.None) {
			Code.put(Code.pop);
		}
	}

	public void visit(LsquareStart lsquareStart) {
		Designator designator = (Designator) lsquareStart.getParent().getParent().getParent();
		Obj obj = findSymbol(currentMethodDeclaration, designator.getVariableName());
		Code.load(obj);
	}

	public void visit(AssignmentStmt assignStmt) {
		Struct struct = assignStmt.getDesignator().struct;
		Obj obj = findSymbol(currentMethodDeclaration, assignStmt.getDesignator().getVariableName());
		if (struct.getKind() != Struct.Array && obj.getType().getElemType() != null) {
			Obj helpElem = new Obj(Obj.Elem, "$", obj.getType().getElemType());
			Code.store(helpElem);
		} else {
			Code.store(obj);
		}

	}

	public void visit(ReadStmt readStmt) {
		// Pogledati
		String varName = readStmt.getDesignator().getVariableName();
		Struct struct = readStmt.getDesignator().struct;
		Obj obj = findSymbol(currentMethodDeclaration, varName);
		if (readStmt.getDesignator().struct.getKind() == Struct.Char) {
			Code.put(Code.bread);
		} else {
			Code.put(Code.read);
		}
		if (struct.getKind() != Struct.Array && obj.getType().getElemType() != null) {
			Obj help = new Obj(Obj.Elem, "$", obj.getType().getElemType());
			Code.store(help);
		} else {
			Code.store(obj);
		}
	}

	/**************************************************************************************************************/

	
	/*************************************************************************************
	 * Condtition
	 * 
	 */

	public void visit(TwoVariablesCondition twoVariablesCondition) {
		RelationalOperator relationalOperator = twoVariablesCondition.getRelationalOperator();
		if (relationalOperator.getClass() == EqualOp.class) {
			Code.put(Code.jcc + Code.inverse[Code.eq]);
		}
		if (relationalOperator.getClass() == NotEqualOp.class) {
			Code.put(Code.jcc + Code.inverse[Code.ne]);
		}
		if (relationalOperator.getClass() == GreaterOp.class) {
			Code.put(Code.jcc + Code.inverse[Code.gt]);
		}
		if (relationalOperator.getClass() == GreaterEqualOp.class) {
			Code.put(Code.jcc + Code.inverse[Code.ge]);
		}
		if (relationalOperator.getClass() == LessOp.class) {
			Code.put(Code.jcc + Code.inverse[Code.lt]);
		}
		if (relationalOperator.getClass() == LessEqualOp.class) {
			Code.put(Code.jcc + Code.inverse[Code.le]);
		}
		Code.put2(7);
		Code.put(Code.const_1);
		Code.put(Code.jmp);
		Code.put2(4);
		Code.put(Code.const_n);
	}

	private Stack<Integer> leftAndToFixUp = new Stack<>();

	public void visit(LeftAnd leftAnd) {
		Code.put(Code.dup);
		Code.put(Code.const_1);
		leftAndToFixUp.push(Code.pc + 1);
		Code.putFalseJump(Code.eq, Code.pc);
		Code.put(Code.pop);
	}

	public void visit(ConditionListAnd conditionListAnd) {
		Code.fixup(leftAndToFixUp.pop());
	}

	private Stack<Integer> leftOrToFixUp = new Stack<>();

	public void visit(LeftOr leftOr) {
		Code.put(Code.dup);
		Code.put(Code.const_n);
		leftOrToFixUp.push(Code.pc + 1);
		Code.putFalseJump(Code.eq, Code.pc);
		Code.put(Code.pop);
	}

	public void visit(ConditionListOr conditionListOr) {
		Code.fixup(leftOrToFixUp.pop());
	}

	/*************************************************************************************/

	/*************************************************************************************
	 * If statement
	 */
	Stack<Integer> ifStackFixPatch = new Stack<>();

	public void visit(IFCondition ifCondition) {
		Code.put(Code.const_1);
		ifStackFixPatch.push(Code.pc + 1);
		Code.putFalseJump(Code.eq, Code.pc);
	}

	public void visit(ElseStart elseStart) {
		int jumpToFix = ifStackFixPatch.pop();
		ifStackFixPatch.push(Code.pc + 1);
		Code.putJump(Code.pc);
		Code.fixup(jumpToFix);
	}

	public void visit(UnmatchedIf unmatched) {
		int jumpToFix = ifStackFixPatch.pop();
		Code.fixup(jumpToFix);
	}

	public void visit(UnmatchedIfElse unmatchedIfElse) {
		int jumpToFix = ifStackFixPatch.pop();
		Code.fixup(jumpToFix);
	}

	public void visit(MatchedStatement matchedStatement) {
		int jumpToFix = ifStackFixPatch.pop();
		Code.fixup(jumpToFix);
	}

	/**************************************************************************************/

	/*****************************************************************************************
	 * Ternar expression
	 */

	Stack<Integer> ternarAddressFixPatch = new Stack<>();

	public void visit(TernarStart ternarStart) {
		Code.put(Code.const_1);
		ternarAddressFixPatch.push(Code.pc + 1);
		Code.putFalseJump(Code.eq, Code.pc);
	}

	public void visit(TernarDivider ternarDivider) {
		int addressToFixUp = ternarAddressFixPatch.pop();
		ternarAddressFixPatch.push(Code.pc + 1);
		Code.putJump(Code.pc);
		Code.fixup(addressToFixUp);
	}

	public void visit(TernarExpr ternarExpr) {
		Code.fixup(ternarAddressFixPatch.pop());
	}

	/*****************************************************************************************/

	/******************************************************************************************
	 * Do while stmt
	 */

	Stack<Integer> doWhileAddressStart = new Stack<>();
	Stack<Integer> doWhileConditionStart = new Stack<>();

	Stack<Integer> forAdressStart = new Stack<>();

	public void visit(StartDoStmt startDoStmt) {
		doWhileAddressStart.push(Code.pc);
		breakPatchAddress.push(new ArrayList<>());
		continuePatchAddress.push(new ArrayList<>());
	}

	public void visit(DoCondition doCondition) {
		Code.put(Code.const_1);
		Code.put(Code.jcc + Code.eq);
		Code.put2(doWhileAddressStart.pop() - Code.pc + 1);

	}

	public void visit(DoConditionStart doConditionStart) {
		for (int address : continuePatchAddress.pop()) {
			Code.fixup(address);
		}
	}

	Stack<List<Integer>> breakPatchAddress = new Stack<>();
	Stack<List<Integer>> continuePatchAddress = new Stack<>();

	public void visit(BreakStmt breakStmt) {
		breakPatchAddress.peek().add(Code.pc + 1);
		Code.putJump(Code.pc);
	}

	public void visit(ContinueStmt continueStmt) {
		continuePatchAddress.peek().add(Code.pc + 1);
		Code.putJump(0);
	}

	public void visit(DoStmt doStmt) {
		for (int address : breakPatchAddress.pop()) {
			Code.fixup(address);
		}
	}

	/**********************************************************************************************/

	Stack<Integer> fixUpEntryFor = new Stack<Integer>();
	Stack<Integer> fixUpEndFor = new Stack<Integer>();
	Stack<Integer> beginingEndFor = new Stack<Integer>();

	public void visit(ForCondition forCondition) {
		Code.put(Code.const_1);
		fixUpEntryFor.push(Code.pc + 1);
		Code.putFalseJump(Code.eq, Code.pc);// Za kraj petlje

		fixUpEndFor.push(Code.pc + 1);
		Code.putJump(Code.pc);
		beginingEndFor.push(Code.pc);// Pocetak uslova
	}

	public void visit(StartFor startFor) {
		doWhileAddressStart.push(Code.pc);
		breakPatchAddress.push(new ArrayList<>());
		continuePatchAddress.push(new ArrayList<>());

	}

	public void visit(BeginingStmtFor beginingStmtFor) {
		Code.putJump(doWhileAddressStart.pop());
		Code.fixup(fixUpEndFor.pop());
	}

	public void visit(ForStmt forStmt) {
		int saveBegining = beginingEndFor.pop();
		Code.putJump(saveBegining);
		Code.fixup(fixUpEntryFor.pop());

		for (int address : breakPatchAddress.pop()) {
			Code.fixup(address);
		}

		for (int address : continuePatchAddress.pop()) {
			int oldPC = Code.get2(address);
			Code.put2(address, saveBegining + oldPC );
		}

	}

}
