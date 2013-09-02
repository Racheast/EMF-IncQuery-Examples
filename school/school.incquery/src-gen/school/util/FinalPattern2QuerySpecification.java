package school.util;

import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IQuerySpecificationProvider;
import school.FinalPattern2Matcher;

/**
 * A pattern-specific query specification that can instantiate FinalPattern2Matcher in a type-safe way.
 * 
 * @see FinalPattern2Matcher
 * @see FinalPattern2Match
 * 
 */
@SuppressWarnings("all")
public final class FinalPattern2QuerySpecification extends BaseGeneratedQuerySpecification<FinalPattern2Matcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static FinalPattern2QuerySpecification instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected FinalPattern2Matcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return FinalPattern2Matcher.on(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "school.incquery";
    
  }
  
  @Override
  protected String patternName() {
    return "school.finalPattern2";
    
  }
  
  private FinalPattern2QuerySpecification() throws IncQueryException {
    super();
  }
  
  @SuppressWarnings("all")
  public static class Provider implements IQuerySpecificationProvider<FinalPattern2QuerySpecification> {
    @Override
    public FinalPattern2QuerySpecification get() throws IncQueryException {
      return instance();
    }
  }
  
  
  @SuppressWarnings("all")
  private static class LazyHolder {
    private final static FinalPattern2QuerySpecification INSTANCE = make();
    
    public static FinalPattern2QuerySpecification make() {
      try {
      	return new FinalPattern2QuerySpecification();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
