class players{

    private String name;
    private char symbol;
    players(String name, char symbol){
        setName(name);
        setSymbol(symbol);
    }
    public void setName(String name){
        if(!name.isEmpty()){
            this.name = name;
        }

    }
    public String getName(){
        return this.name;
    }
    public void setSymbol(char symbol){
        
        this.symbol = symbol;
      
    }

    public char getSymbol(){
        return this.symbol;

    }
}