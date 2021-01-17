// generated with ast extension for cup
// version 0.8
// 16/0/2021 21:30:43


package rs.ac.bg.etf.pp1.ast;

public interface Visitor { 

    public void visit(OptionalClassVarDeclaration OptionalClassVarDeclaration);
    public void visit(DesignatorPart DesignatorPart);
    public void visit(Factor Factor);
    public void visit(Statement Statement);
    public void visit(ConstList ConstList);
    public void visit(OptionalSquareMethodFormalParam OptionalSquareMethodFormalParam);
    public void visit(OptionalSquareNewOp OptionalSquareNewOp);
    public void visit(OptionalMinusVar OptionalMinusVar);
    public void visit(DesignatorStart DesignatorStart);
    public void visit(OptionalMethodActualParameters OptionalMethodActualParameters);
    public void visit(MethodDeclaration MethodDeclaration);
    public void visit(Variable Variable);
    public void visit(ClassVarList ClassVarList);
    public void visit(Expr Expr);
    public void visit(FactorList FactorList);
    public void visit(ClassDeclaration ClassDeclaration);
    public void visit(SpecifeIdentPart SpecifeIdentPart);
    public void visit(OptionalPrintParam OptionalPrintParam);
    public void visit(ConstVarClassDeclarationList ConstVarClassDeclarationList);
    public void visit(Unmatched Unmatched);
    public void visit(ConstType ConstType);
    public void visit(MultiplyOperator MultiplyOperator);
    public void visit(MethodDeclarationList MethodDeclarationList);
    public void visit(GlobalVarList GlobalVarList);
    public void visit(AssignmentStatement AssignmentStatement);
    public void visit(GlobalVariable GlobalVariable);
    public void visit(FormalParamDeclarationList FormalParamDeclarationList);
    public void visit(Condition Condition);
    public void visit(DesignatorStatement DesignatorStatement);
    public void visit(OptionalClassMethodsList OptionalClassMethodsList);
    public void visit(OptionalMethodsLocalVariablesDeclaration OptionalMethodsLocalVariablesDeclaration);
    public void visit(FormalParamDeclaration FormalParamDeclaration);
    public void visit(OptionalMethodFormalParams OptionalMethodFormalParams);
    public void visit(RelationalOperator RelationalOperator);
    public void visit(StatementList StatementList);
    public void visit(ExtendClassOption ExtendClassOption);
    public void visit(AssignmentOperator AssignmentOperator);
    public void visit(ConditionTerm ConditionTerm);
    public void visit(ActualParamDeclarationList ActualParamDeclarationList);
    public void visit(CaseStatement CaseStatement);
    public void visit(ClassVariableDeclaration ClassVariableDeclaration);
    public void visit(ReturnType ReturnType);
    public void visit(VariableDeclaration VariableDeclaration);
    public void visit(ClassVariableDeclarationList ClassVariableDeclarationList);
    public void visit(ConstDeclaration ConstDeclaration);
    public void visit(ClassVariable ClassVariable);
    public void visit(VariableDeclarationList VariableDeclarationList);
    public void visit(VarList VarList);
    public void visit(ConstVarClassDeclaration ConstVarClassDeclaration);
    public void visit(AddOperator AddOperator);
    public void visit(ConditionFact ConditionFact);
    public void visit(TermList TermList);
    public void visit(Expr1 Expr1);
    public void visit(CaseStatementList CaseStatementList);
    public void visit(Matched Matched);
    public void visit(SpecifeIdentPartList SpecifeIdentPartList);
    public void visit(Term Term);
    public void visit(OptionalSpecifeIdentPartList OptionalSpecifeIdentPartList);
    public void visit(NoAditionalParamPrint NoAditionalParamPrint);
    public void visit(AditionalParamPrint AditionalParamPrint);
    public void visit(ElseStart ElseStart);
    public void visit(IFCondition IFCondition);
    public void visit(DoConditionStart DoConditionStart);
    public void visit(DoCondition DoCondition);
    public void visit(StartDoStmt StartDoStmt);
    public void visit(MultipleStatement MultipleStatement);
    public void visit(MatchedStatement MatchedStatement);
    public void visit(ReturnNoExpr ReturnNoExpr);
    public void visit(ReturnExpr ReturnExpr);
    public void visit(BreakStmt BreakStmt);
    public void visit(ContinueStmt ContinueStmt);
    public void visit(ReadStmt ReadStmt);
    public void visit(PrintStmt PrintStmt);
    public void visit(DoStmt DoStmt);
    public void visit(MatchedDesignator MatchedDesignator);
    public void visit(UnmatchedIfElse UnmatchedIfElse);
    public void visit(UnmatchedIf UnmatchedIf);
    public void visit(NoStmt NoStmt);
    public void visit(StmtList StmtList);
    public void visit(UnmatchedStmt UnmatchedStmt);
    public void visit(MatchedStmt MatchedStmt);
    public void visit(OneVariableCondition OneVariableCondition);
    public void visit(TwoVariablesCondition TwoVariablesCondition);
    public void visit(LeftAnd LeftAnd);
    public void visit(OneConditionAnd OneConditionAnd);
    public void visit(ConditionListAnd ConditionListAnd);
    public void visit(LeftOr LeftOr);
    public void visit(ErrorCondition ErrorCondition);
    public void visit(OneConditionOr OneConditionOr);
    public void visit(ConditionListOr ConditionListOr);
    public void visit(NewNonArrayVariable NewNonArrayVariable);
    public void visit(NewArrayVariable NewArrayVariable);
    public void visit(ExprFactor ExprFactor);
    public void visit(FuncCallFactor FuncCallFactor);
    public void visit(Var Var);
    public void visit(NewOperator NewOperator);
    public void visit(BoolConst BoolConst);
    public void visit(CharConst CharConst);
    public void visit(NumConst NumConst);
    public void visit(OneFactor OneFactor);
    public void visit(MultipleFactors MultipleFactors);
    public void visit(TermDescription TermDescription);
    public void visit(OneTerm OneTerm);
    public void visit(MultipleTerms MultipleTerms);
    public void visit(BasicExpressionWithOutMinus BasicExpressionWithOutMinus);
    public void visit(BasicExpressionWithMinus BasicExpressionWithMinus);
    public void visit(TernarDivider TernarDivider);
    public void visit(TernarStart TernarStart);
    public void visit(NoTernarExpression NoTernarExpression);
    public void visit(TernarExpr TernarExpr);
    public void visit(AssignOp AssignOp);
    public void visit(LessEqualOp LessEqualOp);
    public void visit(LessOp LessOp);
    public void visit(GreaterEqualOp GreaterEqualOp);
    public void visit(GreaterOp GreaterOp);
    public void visit(NotEqualOp NotEqualOp);
    public void visit(EqualOp EqualOp);
    public void visit(ModuloOp ModuloOp);
    public void visit(DivideOp DivideOp);
    public void visit(MultiplyOp MultiplyOp);
    public void visit(MinusOp MinusOp);
    public void visit(PlusOp PlusOp);
    public void visit(FuncCallStart FuncCallStart);
    public void visit(FuncCall FuncCall);
    public void visit(AssignmentError AssignmentError);
    public void visit(AssignmentExpr AssignmentExpr);
    public void visit(DecrementDesignator DecrementDesignator);
    public void visit(IncrementDesignator IncrementDesignator);
    public void visit(DesignatorStatementFunctionCall DesignatorStatementFunctionCall);
    public void visit(AssignmentStmt AssignmentStmt);
    public void visit(LsquareStart LsquareStart);
    public void visit(ArrayMemberPart ArrayMemberPart);
    public void visit(NoIdentParts NoIdentParts);
    public void visit(IdentParts IdentParts);
    public void visit(Designator Designator);
    public void visit(OneActualParamDecl OneActualParamDecl);
    public void visit(ActualParamDeclList ActualParamDeclList);
    public void visit(NoMethodActualParams NoMethodActualParams);
    public void visit(MethodActualParams MethodActualParams);
    public void visit(NoArrayFormalParam NoArrayFormalParam);
    public void visit(ArrayFormalParam ArrayFormalParam);
    public void visit(ErrorFormalParamDecl ErrorFormalParamDecl);
    public void visit(FormalParamDecl FormalParamDecl);
    public void visit(OneFormalParamDecl OneFormalParamDecl);
    public void visit(FormalParamDeclList FormalParamDeclList);
    public void visit(NoMethodFormalParams NoMethodFormalParams);
    public void visit(MethodFormalParams MethodFormalParams);
    public void visit(MethodRetName MethodRetName);
    public void visit(NoReturnType NoReturnType);
    public void visit(FunctionReturnType FunctionReturnType);
    public void visit(NoMethodLocalVariableDecl NoMethodLocalVariableDecl);
    public void visit(MethodLocalVariableDecl MethodLocalVariableDecl);
    public void visit(MethodDecl MethodDecl);
    public void visit(NoMethodDecList NoMethodDecList);
    public void visit(MethodDeclList MethodDeclList);
    public void visit(Type Type);
    public void visit(GlobalVariableError GlobalVariableError);
    public void visit(GlobalNoArrayVariable GlobalNoArrayVariable);
    public void visit(GlobalArrrayVariable GlobalArrrayVariable);
    public void visit(GlobalOneVariable GlobalOneVariable);
    public void visit(GlobalVariableList GlobalVariableList);
    public void visit(GlobalVariableDeclaration GlobalVariableDeclaration);
    public void visit(OneVarDecl OneVarDecl);
    public void visit(VarDeclList VarDeclList);
    public void visit(NoArrayVariable NoArrayVariable);
    public void visit(ArrrayVariable ArrrayVariable);
    public void visit(OneVariable OneVariable);
    public void visit(VariableList VariableList);
    public void visit(VariableDecl VariableDecl);
    public void visit(ConstBooleanType ConstBooleanType);
    public void visit(ConstCharType ConstCharType);
    public void visit(ConstIntType ConstIntType);
    public void visit(ConstVariableAssginment ConstVariableAssginment);
    public void visit(OneConstDecl OneConstDecl);
    public void visit(ConstDeclList ConstDeclList);
    public void visit(ConstVarDecl ConstVarDecl);
    public void visit(GlobalVariableDecl GlobalVariableDecl);
    public void visit(GlobalConstDecl GlobalConstDecl);
    public void visit(NoConstVarClassDeclList NoConstVarClassDeclList);
    public void visit(ConstVarClassDeclList ConstVarClassDeclList);
    public void visit(ProgramName ProgramName);
    public void visit(Program Program);

}
