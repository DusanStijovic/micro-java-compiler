package rs.ac.bg.etf.pp1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.*;
import rs.etf.pp1.symboltable.concepts.*;

public class SemanticPass extends VisitorAdaptor {

	int printCallCount = 0;
	int varDeclCount = 0;
	Boolean errorDetected = false;

	int numOfVariables = 0;

	// Global variables helper fields
	Struct globalVarType = null;

	Logger log = Logger.getLogger(getClass());

	// Designator Helper
	Obj designatorObj = null;

	// Do Stmt Helper
	int doStmtStarted = 0;

	// Method call helper
	List<Struct> actualParams = new ArrayList<>();
	Stack<List<Struct>> allMethodCallParams = new Stack<>();
	List<Obj> currentMethodParams = new ArrayList<>();
	String currentMethod = "";

	// Method return helper
	Struct methodRetType = Tab.noType;
	Boolean haveReturn = false;

	// Main method helper
	Boolean haveMain = false;

	/*******************************************************************************************************************************/
	// CondFact \\

	public void visit(OneVariableCondition oneVariableCondition) {
		if (!oneVariableCondition.getExpr().struct.equals(Tab.find("bool").getType())) {
			report_error("Izraz u conditionu mora biti tipa bool", oneVariableCondition);
			return;
		}
	}

	public void visit(TwoVariablesCondition twoVariablesCondition) {
		Struct first = twoVariablesCondition.getExpr().struct;
		Struct second = twoVariablesCondition.getExpr1().struct;
		Struct expType = returnConditionRelOpExprType(first, second, twoVariablesCondition);
		checkIfRelOpAllowed(expType, twoVariablesCondition);
	}

	private Struct returnConditionRelOpExprType(Struct first, Struct second, SyntaxNode node) {
		if (!first.equals(second)) {
			report_error("Nisu isti tipovi podataka", node);
			return Tab.noType;
		}
		return first;

	}

	private void checkIfRelOpAllowed(Struct first, TwoVariablesCondition node) {
		RelationalOperator rO = node.getRelationalOperator();
		if (first.getKind() != Struct.Array)
			return;

		if (rO.getClass() == EqualOp.class) {
			return;

		}
		if (rO.getClass() == NotEqualOp.class) {
			return;
		}
		report_error("Za niz se mogu koristiti samo == i != relacioni operatori ", rO);

	}

	/*******************************************************************************************************************************/

	/********************************************************************************************************************************/
	// Expression \\
	public void visit(NumConst numConst) {
		numConst.struct = Tab.intType;
	}

	public void visit(CharConst charConst) {
		charConst.struct = Tab.charType;
	}

	public void visit(BoolConst boolConst) {
		boolConst.struct = Tab.find("bool").getType();
	}

	public void visit(NewOperator newOperator) {
		newOperator.struct = new Struct(Struct.Array, newOperator.getType().struct);
	}

	public void visit(NewNonArrayVariable newNonArrayVariable) {
		report_error("New se mora koristiti za definisanje niza podataka", newNonArrayVariable);
		newNonArrayVariable.struct = Tab.noType;
	}

	public void visit(NewArrayVariable newArrayVariable) {
		newArrayVariable.struct = newArrayVariable.getExpr().struct;
		if (!newArrayVariable.struct.equals(Tab.intType)) {
			report_error("Izraz unutra [] mora biti tipa int", newArrayVariable);
		}
	}

	public void visit(Var var) {
		var.struct = var.getDesignator().struct;
		Obj obj = Tab.find(var.getDesignator().getVariableName());
		if (obj.getKind() == Obj.Meth) {
			var.struct = Tab.noType;
		}
	}

	public void visit(FuncCallFactor funcCall) {
		funcCall.struct = funcCall.getFuncCall().struct;
	}

	public void visit(ExprFactor exprFactor) {
		exprFactor.struct = exprFactor.getExpr().struct;
	}

	public void visit(TermDescription termDescription) {
		termDescription.struct = termDescription.getFactorList().struct;
	}

	public void visit(OneFactor oneFactor) {
		oneFactor.struct = oneFactor.getFactor().struct;
	}

	public void visit(MultipleFactors multpleFactors) {
		Struct first = multpleFactors.getFactorList().struct;
		Struct second = multpleFactors.getFactor().struct;
		multpleFactors.struct = returnExprType(first, second, multpleFactors);
	}

	public void visit(OneTerm oneTerm) {
		oneTerm.struct = oneTerm.getTerm().struct;
	}

	public void visit(MultipleTerms multipleTerms) {
		Struct first = multipleTerms.getTermList().struct;
		Struct second = multipleTerms.getTerm().struct;
		multipleTerms.struct = returnExprType(first, second, multipleTerms);
	}

	public void visit(BasicExpressionWithMinus basicExpressionWithMinus) {
		basicExpressionWithMinus.struct = basicExpressionWithMinus.getTermList().struct;
		if (!basicExpressionWithMinus.struct.equals(Tab.intType)) {
			report_error("Minus se moze staviti samo ispred promenjivih tipa int", basicExpressionWithMinus);
		}
	}

	public void visit(BasicExpressionWithOutMinus basicExpressionWithOutMinus) {
		basicExpressionWithOutMinus.struct = basicExpressionWithOutMinus.getTermList().struct;
	}

	public void visit(NoTernarExpression noTernarExpression) {
		noTernarExpression.struct = noTernarExpression.getExpr1().struct;
	}

	public void visit(TernarExpr ternarExpr) {
		Struct first = ternarExpr.getTernarStart().struct;
		Struct second = ternarExpr.getExpr1().struct;
		Struct third = ternarExpr.getExpr11().struct;
		if (!second.equals(third)) {
			report_info("Drugi i treci izraz moraju biti istog tipa", ternarExpr);
		}
		if (!first.equals(Tab.find("bool").getType())) {
			report_info("Izraz mora biti tipa bool", ternarExpr);
		}
		ternarExpr.struct = second;

	}

	public void visit(TernarStart ternarStart) {
		ternarStart.struct = ternarStart.getExpr1().struct;
	}

	private Struct returnExprType(Struct first, Struct second, SyntaxNode node) {
		if (!first.equals(second)) {
			report_error("Nisu isti tipovi podataka", node);
			return Tab.noType;
		}
		if (!first.equals(Tab.intType)) {
			report_error("U racunskim izrazima se mora koristiti int", node);
			return Tab.noType;
		}
		return first;

	}

	/***************************************************************************************************************************/

	/****************************************************************************************************************************/
	// Designator \\

	public void visit(Designator designator) {
		Tab.dump();
		String varName = designator.getVariableName();
		Obj help = Tab.find(varName);
		if (help == Tab.noObj) {
			report_error("Promenjiva sa datim imenom ne postoji", designator);
			designator.struct = Tab.noType;
			return;
		}
		Struct optionalPart = designator.getOptionalSpecifeIdentPartList().struct;
		if (optionalPart.getKind() == Struct.Array) {
			if (help.getType().getKind() != Struct.Array) {
				designator.struct = Tab.noType;
				report_error("Ne mozete koristiti indeksiranje za promenjivu koja nije tipa niz", designator);
				return;
			}
			report_info("Pristup elementu niza", designator);
			printObjNode(help);
			designator.struct = help.getType().getElemType();
		} else {
			report_info("Pristup promenljivoj, metodi, konstanti", designator);
			printObjNode(help);
			designator.struct = help.getType();
		}
	}

	public void visit(ArrayMemberPart arrayMemberPart) {
		arrayMemberPart.struct = new Struct(Struct.Array, Tab.noType);
		if (!arrayMemberPart.getExpr().struct.equals(Tab.intType)) {
			report_error("Tip izraza za indeksiranje mora biti int", arrayMemberPart);
		}
	}

	public void visit(NoIdentParts noIdentParts) {
		noIdentParts.struct = Tab.noType;
	}

	/*
	 * public void visit(OneIdentPart oneIdentPart) { oneIdentPart.struct =
	 * oneIdentPart.getSpecifeIdentPart().struct; }
	 * 
	 * public void visit(IdentPartList identPartList) {
	 * report_error("Dozvoljeno je indeksiranje samo jednog nivoa", identPartList);
	 * identPartList.struct = identPartList.getSpecifeIdentPart().struct; }
	 */

	public void visit(IdentParts identParts) {
		identParts.struct = identParts.getSpecifeIdentPart().struct;
	}

	/******************************************************************************************************************************/
	// Designator inc/dec \\
	public void visit(IncrementDesignator inc) {
		if (inc.getDesignator().struct.getKind() == Struct.Array) {
			report_error("Ne mozete inkrementirati niz, vec samo njegove elemente", inc);
			return;
		}
		if (!inc.getDesignator().struct.equals(Tab.intType)) {
			report_error("Inc se moze koristiti samo za promenjiva tipa int", inc);
			return;
		}
		Obj obj = Tab.find(inc.getDesignator().getVariableName());
		if (obj.getKind() != Obj.Var) {
			report_error("Inc se moze koristiti samo za promenjive, ne za konstante, imena metoda", inc);
		}
		report_info("Koriscenje promenjive za inc", inc);
		printObjNode(obj);

	}

	public void visit(DecrementDesignator dec) {
		if (dec.getDesignator().struct.getKind() == Struct.Array) {
			report_error("Dec mozete inkrementirati niz, vec samo njegove elemente", dec);
			return;
		}
		if (!dec.getDesignator().struct.equals(Tab.intType)) {
			report_error("Dec se moze koristiti samo za promenjiva tipa int", dec);
			return;
		}
		Obj obj = Tab.find(dec.getDesignator().getVariableName());
		if (obj.getKind() != Obj.Var) {
			report_error("Inc/Dec se moze koristiti samo za promenjive tipa int, ne za konstante, imena metoda", dec);
		}
		report_info("Koriscenje promenjive za dec", dec);
		printObjNode(obj);
	}

	/******************************************************************************************************************************/
	// Designator assignment statement \\
	public void visit(AssignmentStmt assignmentStmt) {
		if (!assignmentStmt.getAssignmentStatement().struct.assignableTo(assignmentStmt.getDesignator().struct)) {
			report_error("Ne mozete dodeliti jedan tip drugom, nisu kompatibilni", assignmentStmt);
		}
	}

	public void visit(AssignmentExpr assignmentExpr) {
		assignmentExpr.struct = assignmentExpr.getExpr().struct;
	}

	public void visit(AssignmentError assignmentError) {
		assignmentError.struct = Tab.noType;
	}

	/******************************************************************************************************************************/

	/******************************************************************************************************************************/
	// Do statement and break and continue \\
	public void visit(StartDoStmt startDoStmt) {
		doStmtStarted++;
	}

	public void visit(BreakStmt breakStmt) {
		loopOnlyStmt("Break se moze koristiti samo u okviru do-while petlje", breakStmt.getParent());
	}
	
	public void visit(StartFor startFor) {
		doStmtStarted++;
	}
	
	public void visit(ForStmt forStmt) {
		doStmtStarted--;
	}

	public void visit(ContinueStmt continueStmt) {
		loopOnlyStmt("Continue se moze koristiti samo u okviru do-while petlje", continueStmt.getParent());
	}

	private void loopOnlyStmt(String message, SyntaxNode matchedStmt) {
		if (doStmtStarted == 0) {
			report_error(message, matchedStmt);
			return;
		}
	}

	public void visit(DoStmt dostmt) {
		doStmtStarted--;
	}

	/******************************************************************************************************************************/

	/*******************************************************************************************************************************/
	// Read stmt \\
	public void visit(ReadStmt readStmt) {
		Obj obj = Tab.find(readStmt.getDesignator().getVariableName());
		if (readStmt.getDesignator().struct.getKind() == Struct.Array) {
			report_error("Ne mozete procitati niz, samo element niza ili promenjivu", readStmt);
		}
		if (obj.getKind() != Obj.Var) {
			report_error("Moze se koristiti samo promenjiva, ne konstanta ili ime metode", readStmt);
		}
		report_info("Poziv funkcije read", readStmt);
	}

	public void visit(PrintStmt printStmt) {
		printCallCount++;
		Struct exprType = printStmt.getExpr().struct;
		if (exprType.getKind() == Struct.Array) {
			report_error("Ne mozete ispisivati niz", printStmt);
		}
		if (exprType.getKind() == Struct.None) {
			report_error("Ne mozete ispisati metodu. Ne mozete ispisati promenjivu koja nije definisana", printStmt);
		}
		report_info("Poziv funkcije print", printStmt);
	}

	/******************************************************************************************************************************/

	/******************************************************************************************************************************/
	// FormalParam function \\

	public void visit(FormalParamDecl formalParamDecl) {
		String formalParamName = formalParamDecl.getFormalParamName();
		Obj obj = Tab.find(formalParamName);
		if (obj == Tab.noObj || obj.getLevel() == 0) {
			Obj inserted = Tab.insert(Obj.Var, formalParamName,
					formalParamDecl.getOptionalSquareMethodFormalParam().struct);
			inserted.setFpPos(Tab.currentScope.getnVars());
			currentMethodParams.add(inserted);
			report_info("Deklaracija formalnog parametra", formalParamDecl);
			printObjNode(inserted);
		} else {
			errorDetected = true;
			report_error("Formalni parametar sa datim imenom je vec definisan", formalParamDecl);
		}
	}

	public void visit(ArrayFormalParam array) {
		array.struct = new Struct(Struct.Array, globalVarType);
	}

	public void visit(NoArrayFormalParam noArray) {
		noArray.struct = globalVarType;
	}

	/******************************************************************************************************************************/
	// Function declaration \\
	public void visit(MethodRetName methodRetName) {
		Obj obj = Tab.find(methodRetName.getMethodName());
		methodRetType = methodRetName.getReturnType().struct;
		if (obj == Tab.noObj) {
			if (methodRetName.getMethodName().equals("main")) {
				if (!methodRetType.equals(Tab.noType)) {
					report_error("Povratna vrednost za main mora biti void", methodRetName);
				}
			}
			obj = Tab.insert(Obj.Meth, methodRetName.getMethodName(), methodRetName.getReturnType().struct);
			Tab.openScope();
			methodRetName.obj = obj;
			// report_info("Definisana globalna metoda", methodRetName);
			// printObjNode(obj);

		} else {
			report_error("Metoda ili promenjiva sa datim imenom je vec definisana", methodRetName);
			Tab.openScope();
			methodRetName.obj = Tab.noObj;
			printObjNode(obj);
		}
		currentMethod = methodRetName.getMethodName();
	}

	public void visit(NoReturnType noRetType) {
		noRetType.struct = Tab.noType;
	}

	public void visit(FunctionReturnType retType) {
		retType.struct = retType.getType().struct;
	}

	public void visit(MethodDecl methodDecl) {
		Obj obj = methodDecl.getMethodRetName().obj;
		if (obj != Tab.noObj) {
			Tab.chainLocalSymbols(obj);
			List<Obj> help = new ArrayList<>(obj.getLocalSymbols());
			if (help.size() > 0) {
				Obj helpObj = help.stream().max((Obj o1, Obj o2) -> {
					return o1.getFpPos() - o2.getFpPos();
				}).get();
				obj.setLevel(helpObj.getFpPos());
				for (int i = 0; i < obj.getLevel(); i++) {
					help.get(i).setFpPos(help.get(i).getFpPos() - 1);
				}
			} else {
				obj.setLevel(0);
			}
			report_info("Definicija globalne metode", methodDecl);
			printObjNode(obj);
		}
		Tab.closeScope();
		if (obj.getName().equals("main") && obj.getLevel() != 0) {
			report_error("Metoda main ne sme imati formalne parametre", methodDecl);
		} else {
			haveMain = true;
		}
//		if (!haveReturn && !obj.getType().equals(Tab.noType)) {
//			report_error("Povratni tip metode nije void tako da mora imati return izraz u sebi", methodDecl);
//		}
		haveReturn = false;
		methodRetType = Tab.noType;
		currentMethodParams.clear();
		currentMethod = "";
	}

	/******************************************************************************************************************************/

	/******************************************************************************************************************************/
	// Function call \\
	public void visit(FuncCall funcCall) {
		funcCall.struct = funcCall.getFuncCallStart().getDesignator().struct;
		String methodName = funcCall.getFuncCallStart().getDesignator().getVariableName();
		Obj obj = Tab.find(methodName);
		if (obj != Tab.noObj && obj.getKind() != Obj.Meth) {
			report_error("Promenjiva nije callable, mozete pozivati samo imena funkcija", funcCall);
			funcCall.struct = Tab.noType;
		} else {
			checkActualFormalCompatibility(actualParams, obj, funcCall);
		}
		report_info("Poziv funckije", funcCall);
		printObjNode(obj);
	}

	public void visit(FuncCallStart funcCallStart) {
		allMethodCallParams.push(actualParams);
		actualParams = new ArrayList<>();
	}

	private void checkActualFormalCompatibility(List<Struct> actual, Obj method, SyntaxNode funcCall) {
		List<Obj> locals = new ArrayList<>(method.getLocalSymbols());
		int numToGo = actual.size();
		if (method.getName().equals(currentMethod)) {
			locals = currentMethodParams;
			if (actual.size() != locals.size()) {
				report_error("Broj formalnih i stvarnih parametara se razlikuje", funcCall);
			}
			if (numToGo > locals.size())
				numToGo = locals.size();
		} else {
			if (actual.size() != method.getLevel()) {
				report_error("Broj formalnih i stvarnih parametara se razlikuje", funcCall);
			}
			if (numToGo > method.getLevel())
				numToGo = method.getLevel();
		}
		Struct arrayNoType = new Struct(Struct.Array, Tab.noType);
		for (int actualParamNumber = 0; actualParamNumber < numToGo; actualParamNumber++) {
			if (!locals.get(actualParamNumber).getType().equals(actual.get(actualParamNumber))
					&& !locals.get(actualParamNumber).getType().equals(arrayNoType)) {
				report_error("Aktielni i formalni parametar se ne slazu po tipu", funcCall);
				printObjNode(locals.get(actualParamNumber));
			}
			report_info("Formalni parameter funkcije", funcCall);
			printObjNode(locals.get(actualParamNumber));
		}
		actualParams.clear();
		actualParams = allMethodCallParams.pop();
	}

	public void visit(ReturnExpr returnExpr) {
		if (!returnExpr.getExpr().struct.equals(methodRetType)) {
			report_error("Povratni tip metode nije isti kao tip iraza u return naredbi", returnExpr);
		}
		haveReturn = true;
	}

	public void visit(ReturnNoExpr returnNoExpr) {
		if (!methodRetType.equals(Tab.noType)) {
			report_error("Povratni tip metode nije isti kao tip iraza u return naredbi", returnNoExpr);
		}
		haveReturn = true;
	}

	/******************************************************************************************************************************/

	/******************************************************************************************************************************/
	// Acutal params \\

	public void visit(OneActualParamDecl oneActualParamDecl) {
		Struct actual = oneActualParamDecl.getExpr().struct;
		actualParams.add(actual);
	}

	public void visit(ActualParamDeclList actualParamDeclList) {
		Struct actual = actualParamDeclList.getExpr().struct;
		actualParams.add(actual);
	}

	/******************************************************************************************************************************/

	/******************************************************************************************************************************/
	// Global var declaration \\
	public void visit(GlobalNoArrayVariable globalVarDeclNoArray) {
		Obj obj = Tab.find(globalVarDeclNoArray.getGlobalVarName());
		if (obj == Tab.noObj) {
			Obj inserted = Tab.insert(Obj.Var, globalVarDeclNoArray.getGlobalVarName(), globalVarType);
			varDeclCount++;
			report_info("Definicija globalne promenjive", globalVarDeclNoArray);
			printObjNode(inserted);
		} else {
			report_error("Proemnjiva sa datim imenom je vec definisana u trenutnon scope-u", globalVarDeclNoArray);
		}
	}

	public void visit(GlobalArrrayVariable globalVarDeclArray) {
		Obj obj = Tab.find(globalVarDeclArray.getGlobalVarName());
		if (obj == Tab.noObj) {
			Struct arrayType = new Struct(Struct.Array, globalVarType);
			Obj inserted = Tab.insert(Obj.Var, globalVarDeclArray.getGlobalVarName(), arrayType);
			report_info("Definicja globalne promenjive", globalVarDeclArray);
			printObjNode(inserted);
		} else {
			report_error("Promenjiva sa datim imenom je vec definisana u trenutnom scope-u", globalVarDeclArray);
		}
	}

	/******************************************************************************************************************************/

	/******************************************************************************************************************************/
	// Global const declaration \\
	public void visit(ConstVariableAssginment constVarAssign) {
		Obj obj = Tab.find(constVarAssign.getVarName());
		if (obj == Tab.noObj) {
			if (constVarAssign.getConstType().struct.assignableTo(globalVarType)) {
				Obj inserted = Tab.insert(Obj.Con, constVarAssign.getVarName(), globalVarType);
				setConstValue(constVarAssign.getConstType(), inserted);
				report_info("Definisan konst", constVarAssign);
				printObjNode(inserted);
			} else {
				report_error("Tip konstante i vrednost koja joj se dodeljuje su nekomatibilne", constVarAssign);
			}
		} else {
			report_error("Konstanta sa datim imenom je vec definisana u trenutnom scope-u", constVarAssign);
		}
	}

	private void setConstValue(ConstType constType, Obj obj) {
		if (constType.getClass() == ConstIntType.class) {
			ConstIntType cit = (ConstIntType) constType;
			obj.setAdr(cit.getAssignedValue());
		}
		if (constType.getClass() == ConstCharType.class) {
			ConstCharType cit = (ConstCharType) constType;
			obj.setAdr(cit.getAssignedValue());
		}
		if (constType.getClass() == ConstBooleanType.class) {
			ConstBooleanType cit = (ConstBooleanType) constType;
			obj.setAdr(cit.getAssignedValue().equals("true") ? 1 : 0);
		}

	}

	public void visit(ConstIntType constIntType) {
		constIntType.struct = Tab.intType;
	}

	public void visit(ConstCharType constCharType) {
		constCharType.struct = Tab.charType;
	}

	public void visit(ConstBooleanType constBooleanType) {
		Obj boolObj = Tab.find("bool");
		constBooleanType.struct = boolObj.getType();
	}

	/******************************************************************************************************************************/

	/******************************************************************************************************************************/
	// Local var declaration \\

	public void visit(ArrrayVariable oneVariable) {
		Obj obj = Tab.find(oneVariable.getVarName());
		if (obj == Tab.noObj || obj.getLevel() == 0) {
			Struct newStruct = new Struct(Struct.Array, globalVarType);
			Obj inserted = Tab.insert(Obj.Var, oneVariable.getVarName(), newStruct);
			report_info("Definicija lokalne promenjive metode", oneVariable);
			printObjNode(inserted);
		} else {
			report_error("Lokalna promenjiva metode sa datim imenom je vec definisana", oneVariable);
			printObjNode(obj);
		}
	}

	public void visit(NoArrayVariable noArrayVariable) {
		Obj obj = Tab.find(noArrayVariable.getVarName());
		if (obj == Tab.noObj || obj.getLevel() == 0) {
			Obj inserted = Tab.insert(Obj.Var, noArrayVariable.getVarName(), globalVarType);
			report_info("Definicija lokalne promenjive metode", noArrayVariable);
			printObjNode(inserted);
		} else {
			report_error("Lokalna promenjiva metode sa datim imenom je vec definisana", noArrayVariable);
			printObjNode(obj);
		}
	}

	/******************************************************************************************************************************/

	/******************************************************************************************************************************/
	// Program \\
	public void visit(Program program) {
		numOfVariables = Tab.currentScope.getnVars();
		Tab.chainLocalSymbols(program.getProgramName().obj);
		Tab.closeScope();
		// System.out.print(globalVarDeclInfo);
		// System.out.print(globalConstDeclInfo);
		if (!haveMain) {
			report_error("Program mora imati globalnu metodu main", program);
		}
		Tab.dump();
		if (errorDetected) {
			log.info("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ ");
			log.info("                                 GRESKE: 							            ");
			log.info("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ ");
			log.info(allErrors.toString());
			report_error("Semanticka analiza neuspesna", program);
		} else {
			report_info("Semanticka analiza uspesno zavrsena", program);

		}

	}

	public void visit(ProgramName progName) {
		progName.obj = Tab.insert(Obj.Prog, progName.getProgramName(), Tab.noType);
		Tab.openScope();
	}

	/******************************************************************************************************************************/

	/******************************************************************************************************************************/
	// Type \\

	public void visit(Type type) {
		Obj typeNode = Tab.find(type.getTypeName());
		if (typeNode == Tab.noObj) {
			report_error("Nije pronadjen tip " + type.getTypeName() + " u tabeli simbola! ", null);
			type.struct = Tab.noType;
			globalVarType = Tab.noType;
		} else {
			if (Obj.Type == typeNode.getKind()) {
				type.struct = typeNode.getType();
				globalVarType = typeNode.getType();
			} else {
				report_error("Greska: Ime " + type.getTypeName() + " ne predstavlja tip!", type);
				type.struct = Tab.noType;
				globalVarType = Tab.noType;
			}
		}
	}

	/******************************************************************************************************************************/

	/******************************************************************************************************************************/
	// Helper function for printing \\
	private void printObjNode(Obj var) {
		StringBuilder printObj = new StringBuilder();
		printObj.append(initializefoundGlobal(var));
		System.out.print(printObj);
	}

	private StringBuilder initializefoundGlobal(Obj var) {
		StringBuilder builderString = new StringBuilder("");
		builderString.append("ime:" + var.getName() + " \n");
		builderString.append(makeObjString(var));
		builderString.append("_ _ _ _ _ _ _ _ _ _ _ _ _ _ \n");
		return builderString;
	}

	private StringBuilder makeObjString(Obj var) {
		StringBuilder builderString = new StringBuilder("");
		builderString.append("objNodeDescription: \n");
		builderString.append("kind: " + translateToObjKind[var.getKind()] + "\n");
		builderString.append((var.getKind() == Obj.Con ? "value" : "addr") + ": " + var.getAdr() + "\n");
		builderString.append("scopeLevel: " + var.getLevel() + "\n");
		builderString.append("type: " + makeTypeString(var.getType()) + "\n");
		builderString.append("fpPos: " + var.getFpPos() + "\n");
		return builderString;
	}

	private StringBuilder makeTypeString(Struct type) {
		StringBuilder builderString = new StringBuilder(type.getKind());
		switch (type.getKind()) {
		case Struct.Array:
			builderString.append("Array of " + translateToStructKind[type.getElemType().getKind()]);
			break;
		case Struct.Class:
			builderString.append("Class");
			break;
		default:
			builderString.append(translateToStructKind[type.getKind()]);
		}
		return builderString;
	}

	String[] translateToObjKind = { "Con", "Var", "Type", "Meth", "Fld", "Elem", "Prog" };
	String[] translateToStructKind = { "None", "Int", "Char", "Array", "Class", "Bool" };

	public boolean passed() {
		return errorDetected == false;
	}

	StringBuilder allErrors = new StringBuilder();

	public void report_error(String message, SyntaxNode info) {
		errorDetected = true;
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0 : info.getLine();
		if (line != 0)
			msg.append(" na liniji ").append(line);
		allErrors.append("\n");
		allErrors.append(msg);
		log.error(msg.toString());
	}

	public void report_info(String message, SyntaxNode info) {
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0 : info.getLine();
		if (line != 0)
			msg.append(" na liniji ").append(line);
		log.info(msg.toString());
	}

	/******************************************************************************************************************************/
}
