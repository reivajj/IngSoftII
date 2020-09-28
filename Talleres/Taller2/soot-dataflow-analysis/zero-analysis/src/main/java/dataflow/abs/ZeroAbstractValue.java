package dataflow.abs;

public enum ZeroAbstractValue {

  NOT_ZERO("not-zero"), ZERO("zero"), MAYBE_ZERO("maybe-zero");

  private String name;

  @Override
  public String toString() {
    return this.name;
  }

  ZeroAbstractValue(final String name) {
    this.name = name;
  }

  public ZeroAbstractValue add(final ZeroAbstractValue another) {
    switch (this){
      case NOT_ZERO: 
        if (another == ZERO) return NOT_ZERO;
        else return MAYBE_ZERO;   
      case ZERO: 
        if (another.equals(NOT_ZERO)) return NOT_ZERO;
        if (another.equals(ZERO)) return ZERO;
        if (another.equals(MAYBE_ZERO)) return MAYBE_ZERO; 
        break;
      case MAYBE_ZERO: 
        return MAYBE_ZERO; 
      default: throw new UnsupportedOperationException();
    }
    return this;
  }
  

  public ZeroAbstractValue divideBy(final ZeroAbstractValue another) {
    switch (another){
      case NOT_ZERO:
        if(this == NOT_ZERO) return MAYBE_ZERO;  // Consultar bien
        if(this == ZERO) return ZERO;
        if(this == MAYBE_ZERO) return MAYBE_ZERO;
        break;
      case MAYBE_ZERO:
        return this;
        // if(this == NOT_ZERO) return NOT_ZERO;  // Consultar bien
        // if(this == ZERO) return ZERO;
        // if(this == MAYBE_ZERO) return MAYBE_ZERO;
        // break;
      case ZERO:
        break;
      default: throw new UnsupportedOperationException();
    }

    // QUE HAGO SI ES MAYBE_ZERO o ZERO el DIVISOR? ASUMO QUE NUNCA LE LLEGA? Y SE CHEQUEA EN ZEROVALUEVISITOR?
    
    return this;
  }
  

  public ZeroAbstractValue multiplyBy(final ZeroAbstractValue another) {
    switch (this) {
      case NOT_ZERO: 
        if (another == NOT_ZERO) return NOT_ZERO;
        if (another == ZERO) return ZERO;
        if (another == MAYBE_ZERO) return MAYBE_ZERO;   
        break;
      case ZERO: 
        return ZERO;   
      case MAYBE_ZERO: 
        if (another == ZERO) return ZERO;
        else return MAYBE_ZERO;
      default:
        throw new UnsupportedOperationException();
    }
    return this;
  }
  

  public ZeroAbstractValue substract(final ZeroAbstractValue another) {
    switch (this) {
      case NOT_ZERO: 
        if (another == NOT_ZERO) return MAYBE_ZERO;
        if (another == ZERO) return NOT_ZERO;
        if (another == MAYBE_ZERO) return MAYBE_ZERO;   
        break;
      case ZERO: 
        if (another == NOT_ZERO) return NOT_ZERO;
        if (another == ZERO) return ZERO;
        if (another == MAYBE_ZERO) return MAYBE_ZERO;   
        break;  
      case MAYBE_ZERO: 
        return MAYBE_ZERO;   
      default:
        throw new UnsupportedOperationException();
    }
    // PORQUE ME PIDE ESTO??
    return this;
  }

  public ZeroAbstractValue merge(final ZeroAbstractValue another) {
    if (this == MAYBE_ZERO || another == MAYBE_ZERO) return MAYBE_ZERO;
    if (this == ZERO && another == ZERO) return ZERO;
    if (this == NOT_ZERO && another == NOT_ZERO) return NOT_ZERO;
    if ((this == ZERO && another == NOT_ZERO) || (this == NOT_ZERO && another == ZERO)) return MAYBE_ZERO;
    throw new UnsupportedOperationException();
  }
  
}
