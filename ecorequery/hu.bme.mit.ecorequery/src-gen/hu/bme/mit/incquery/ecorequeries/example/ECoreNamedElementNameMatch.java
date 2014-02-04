package hu.bme.mit.incquery.ecorequeries.example;

import hu.bme.mit.incquery.ecorequeries.example.util.ECoreNamedElementNameQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.incquery.ecorequeries.example.ECoreNamedElementName pattern,
 * to be used in conjunction with {@link ECoreNamedElementNameMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see ECoreNamedElementNameMatcher
 * @see ECoreNamedElementNameProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class ECoreNamedElementNameMatch extends BasePatternMatch {
  private String fName;
  
  private static List<String> parameterNames = makeImmutableList("Name");
  
  private ECoreNamedElementNameMatch(final String pName) {
    this.fName = pName;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("Name".equals(parameterName)) return this.fName;
    return null;
    
  }
  
  public String getName() {
    return this.fName;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("Name".equals(parameterName) ) {
    	this.fName = (java.lang.String) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setName(final String pName) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fName = pName;
    
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.incquery.ecorequeries.example.ECoreNamedElementName";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return ECoreNamedElementNameMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fName};
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"Name\"=" + prettyPrintValue(fName));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fName == null) ? 0 : fName.hashCode());
    return result;
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof ECoreNamedElementNameMatch)) { // this should be infrequent
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!specification().equals(otherSig.specification()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    ECoreNamedElementNameMatch other = (ECoreNamedElementNameMatch) obj;
    if (fName == null) {if (other.fName != null) return false;}
    else if (!fName.equals(other.fName)) return false;
    return true;
  }
  
  @Override
  public ECoreNamedElementNameQuerySpecification specification() {
    try {
    	return ECoreNamedElementNameQuerySpecification.instance();
    } catch (IncQueryException ex) {
     	// This cannot happen, as the match object can only be instantiated if the query specification exists
     	throw new IllegalStateException	(ex);
    }
    
  }
  
  @SuppressWarnings("all")
  static final class Mutable extends ECoreNamedElementNameMatch {
    Mutable(final String pName) {
      super(pName);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  
  @SuppressWarnings("all")
  static final class Immutable extends ECoreNamedElementNameMatch {
    Immutable(final String pName) {
      super(pName);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
  
}
