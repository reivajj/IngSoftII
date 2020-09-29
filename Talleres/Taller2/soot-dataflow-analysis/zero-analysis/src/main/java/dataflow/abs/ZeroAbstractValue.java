package dataflow.abs;

public enum ZeroAbstractValue {

  BOTTOM("bottom"), NOT_ZERO("not-zero"), ZERO("zero"), MAYBE_ZERO("maybe-zero");

  private String name;

  @Override
  public String toString() {
    return this.name;
  }

  ZeroAbstractValue(String name) {
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

  public ZeroAbstractValue divideBy(ZeroAbstractValue another) {
    if(another == ZERO) return BOTTOM;
    if(this == ZERO) return ZERO;
    if(this == MAYBE_ZERO || another == MAYBE_ZERO) return MAYBE_ZERO;
    return NOT_ZERO;
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

  // VAN A AGREGAR UNKNOWN (BOTTOM), UNKNOWN Y LO QUE SEA QUEDA LO QUE SEA.
  // ESTO EN TODAS LAS OPERACIONES
  // 
  // EL MERGE DE BOTTOM CON CUALQUEIR COSA DA CUALQUIER COSA, NO BOTTOM
  // CUANDO DIVIDÍS POR CERO TE DA BOTTOM
  
  public ZeroAbstractValue merge(final ZeroAbstractValue another) {
    if (this == BOTTOM) return another;
    if (another == BOTTOM) return this;
    if (this == ZERO && another == ZERO) return ZERO;
    if (this == NOT_ZERO && another == NOT_ZERO) return NOT_ZERO;
    // Si hay un MAYBE_ZERO o recibo NOT_ZERO y ZERO retorno MAYBE_ZERO
    return MAYBE_ZERO;
  }

}
