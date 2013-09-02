package school.util;

import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IQuerySpecificationProvider;
import school.SchoolsNamesMatcher;

/**
 * A pattern-specific query specification that can instantiate SchoolsNamesMatcher in a type-safe way.
 * 
 * @see SchoolsNamesMatcher
 * @see SchoolsNamesMatch
 * 
 */
@SuppressWarnings("all")
public final class SchoolsNamesQuerySpecification extends BaseGeneratedQuerySpecification<SchoolsNamesMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static SchoolsNamesQuerySpecification instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected SchoolsNamesMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return SchoolsNamesMatcher.on(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "school.incquery";
    
  }
  
  @Override
  protected String patternName() {
    return "school.schoolsNames";
    
  }
  
  private SchoolsNamesQuerySpecification() throws IncQueryException {
    super();
  }
  
  @SuppressWarnings("all")
  public static class Provider implements IQuerySpecificationProvider<SchoolsNamesQuerySpecification> {
    @Override
    public SchoolsNamesQuerySpecification get() throws IncQueryException {
      return instance();
    }
  }
  
  
  @SuppressWarnings("all")
  private static class LazyHolder {
    private final static SchoolsNamesQuerySpecification INSTANCE = make();
    
    public static SchoolsNamesQuerySpecification make() {
      try {
      	return new SchoolsNamesQuerySpecification();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
