package com.fruits.algo.stackqueue;

public class NumericExpressionCaculator {
	/*
	 * operator outer priority: ^ * / + - ( ) \n 5 3 3 2 2 5 1 1
	 * 
	 * operator internal priority: ^ * / + - ( 4 3 3 2 2 0
	 */
	private int[] operatorOuterPriority = { 5, 3, 3, 2, 2, 5, 1, 1 };
	private int[] operatorInternalPriority = { 4, 3, 3, 2, 2, 0 };

	private static class Exponent extends Operator {
		public Exponent(char operator, int outerPriority, int internalPriority) {
			super(operator, outerPriority, internalPriority);
		}

		public Number eval(Number left, Number right) {
			return new Number(Math.pow(left.getNumber(), right.getNumber()));
		}
	}

	private static class Multiply extends Operator {
		public Multiply(char operator, int outerPriority, int internalPriority) {
			super(operator, outerPriority, internalPriority);
		}

		public Number eval(Number left, Number right) {
			return new Number((left.getNumber() * right.getNumber()));
		}
	}

	private static class Divide extends Operator {
		public Divide(char operator, int outerPriority, int internalPriority) {
			super(operator, outerPriority, internalPriority);
		}

		public Number eval(Number left, Number right) {
			return new Number((left.getNumber() / right.getNumber()));
		}
	}

	private static class Plus extends Operator {
		public Plus(char operator, int outerPriority, int internalPriority) {
			super(operator, outerPriority, internalPriority);
		}

		public Number eval(Number left, Number right) {
			return new Number((left.getNumber() + right.getNumber()));
		}
	}

	private static class Minus extends Operator {
		public Minus(char operator, int outerPriority, int internalPriority) {
			super(operator, outerPriority, internalPriority);
		}

		public Number eval(Number left, Number right) {
			return new Number((left.getNumber() - right.getNumber()));
		}
	}

	private static class LP extends Operator {
		public LP(char operator, int outerPriority, int internalPriority) {
			super(operator, outerPriority, internalPriority);
		}

		public Number eval(Number left, Number right) {
			return new Number(Double.MIN_VALUE);
		}
	}

	private static class RP extends Operator {
		public RP(char operator, int outerPriority, int internalPriority) {
			super(operator, outerPriority, internalPriority);
		}

		public Number eval(Number left, Number right) {
			return new Number(Double.MIN_VALUE);
		}
	}

	private static class LF extends Operator {
		public LF(char operator, int outerPriority, int internalPriority) {
			super(operator, outerPriority, internalPriority);
		}

		public Number eval(Number left, Number right) {
			return new Number(Double.MIN_VALUE);
		}
	}

	private static class Space extends Operator {
		public Space(char operator, int outerPriority, int internalPriority) {
			super(operator, outerPriority, internalPriority);
		}

		public Number eval(Number left, Number right) {
			return new Number(Double.MIN_VALUE);
		}
	}

	private abstract static class Operator implements Symbol {
		public static final Operator EXPONENT = new Exponent('^', 5, 4);
		public static final Operator MULTIPLY = new Multiply('*', 3, 3);
		public static final Operator DIVIDE = new Divide('/', 3, 3);
		public static final Operator PLUS = new Plus('+', 2, 2);
		public static final Operator MINUS = new Minus('-', 2, 2);
		public static final Operator LP = new LP('(', 5, 0);
		public static final Operator RP = new RP(')', 1, -1);
		public static final Operator LF = new LF('\n', 1, -1);
		public static final Operator SPACE = new Space(' ', -1, -1);

		private char operator;
		private int outerPri;
		private int internalPri;

		public Operator(char operator, int outerPriority, int internalPriority) {
			this.operator = operator;
			this.outerPri = outerPriority;
			this.internalPri = internalPriority;
		}

		public char getOperator() {
			return operator;
		}

		public void setOperator(char operator) {
			this.operator = operator;
		}

		public int getOuterPri() {
			return outerPri;
		}

		public void setOuterPri(int outerPriority) {
			this.outerPri = outerPriority;
		}

		public int getInternalPri() {
			return internalPri;
		}

		public void setInternalPri(int internalPriority) {
			this.internalPri = internalPriority;
		}

		public abstract Number eval(Number left, Number right);

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + operator;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Operator other = (Operator) obj;
			if (operator != other.operator)
				return false;
			return true;
		}

		public static Operator getOperator(char c) {
			switch (c) {
			case '^':
				return EXPONENT;
			case '*':
				return MULTIPLY;
			case '/':
				return DIVIDE;
			case '+':
				return PLUS;
			case '-':
				return MINUS;
			case '(':
				return LP;
			case ')':
				return RP;
			}
			return null;
		}
	}

	private static interface Symbol {
	}

	private static class Number implements Symbol {
		private double number;

		public Number(double num) {
			this.number = num;
		}

		public double getNumber() {
			return number;
		}

		public void setNumber(double number) {
			this.number = number;
		}
	}

	private Number eval(Operator operator, Number left, Number right) {
		return operator.eval(left, right);
	}

	public static class ExpressParser {
		private String express;
		private int pos = 0;

		public ExpressParser(String express) {
			this.express = express;
		}

		private boolean isOperator(char c) {
			if ((c == '^') || (c == '*') || (c == '/') || (c == '+') || (c == '-') || (c == '(') || (c == ')') || (c == '\n'))
				return true;
			return false;
		}

		public Symbol getNextSymbol() {
			if (express.charAt(pos) == 'n')
				return Operator.LF;

			int status = 0;
			char c;
			double num = 0;
			boolean flag = false;
			while ((c = express.charAt(pos)) != 'n') {
				if (Character.isDigit(c)) {
					num = num * 10 + c - '0';
					flag = true;
					if (status == 0)
						status = 1;
					pos++;
				} else if (isOperator(c)) {
					if (status == 1) {
						status = 0;
						System.out.println(num);
						return new Number(num);
					}
					pos++;
					return Operator.getOperator(c);
				}
			}

			if (flag)
				return new Number(num);
			return null;
		}
	}

	public static double eval(String numericExpress) {
		ExpressParser parser = new ExpressParser(numericExpress);
		Stack numStack = new Stack(256);
		Stack opStack = new Stack(256);
		opStack.push(Operator.LP);

		for (;;) {
			Symbol nextSymbol = parser.getNextSymbol();
			if (nextSymbol instanceof Operator) {
				Operator nextOp = (Operator) nextSymbol;
				if (nextOp.getOuterPri() > ((Operator) opStack.peek()).getInternalPri()) {
					System.out.println(nextOp.getOperator());
					opStack.push(nextOp);
				} else {
					do {
						Number left = (Number) numStack.pop();
						Number right = (Number) numStack.pop();
						System.out.println("left:" + left.getNumber());
						System.out.println("right:" + left.getNumber());
						Operator operator = (Operator) opStack.pop();
						numStack.push(operator.eval(left, right));
						System.out.println(operator.eval(left, right).getNumber());
					} while (nextOp.getOuterPri() <= ((Operator) opStack.peek()).getInternalPri());
					if (nextOp.equals(Operator.LF))
						break;
					if (nextOp.equals(Operator.RP)) {
						do {
							opStack.pop();
						} while (!opStack.peek().equals(Operator.LP));
					}
					opStack.push(nextOp);
				}

			} else if (nextSymbol instanceof Number) {
				System.out.println(((Number) nextSymbol).getNumber());
				numStack.push(nextSymbol);
			}
		}

		return ((Number) numStack.pop()).getNumber();

		// return Double.MIN_VALUE;
	}

	public static void main(String[] args) {
		System.out.println(eval("3+4*5\n"));
	}
}
