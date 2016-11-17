public enum Mark {
    X("X"), O("O"), EMPTY(".");

    private String name;
    
    Mark (String name) {
        this.name = name;
    }
    
    
    @Override
    public String toString() {
        
        return name;
    }
}


