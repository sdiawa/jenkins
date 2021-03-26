package sofrone;



public enum Operation {
	PLUS("+"){

		@Override
		public double eval(double a, double b) {
			// TODO Auto-generated method stub
			return a+b;
		}
		
	},
	MINUS("-"){

		@Override
		public double eval(double a, double b) {
			// TODO Auto-generated method stub
			return a-b;
		}
		
	},
	MULT("*"){

		@Override
		public double eval(double a, double b) {
			// TODO Auto-generated method stub
			return a * b;
		}
		
	},
	DIVIDE("/"){

		@Override
		public double eval(double a, double b) {
			// TODO Auto-generated method stub
			
			return a / b;
			
			
		}
		
	};

	  // constructeur priv� affectant le symbole au champ local
	  public final  String symbol;
	  private Operation(String symbol) {
		this.symbol = symbol;
	  }

	  // getter traditionnel
	  public String getSymbol() {
		  return symbol;
	  }
	  public  double eval(double a,double b) {
		// TODO Auto-generated method stub
		return 0;
	}

}
