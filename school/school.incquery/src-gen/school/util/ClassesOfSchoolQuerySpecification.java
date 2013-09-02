package school.util;

import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IQuerySpecificationProvider;
import school.ClassesOfSchoolMatcher;

/**
 * A pattern-specific query specification that can instantiate ClassesOfSchoolMatcher in a type-safe way.
 * 
 * @see ClassesOfSchoolMatcher
 * @see ClassesOfSchoolMatch
 * 
 */
@SuppressWarnings("all")
public final class ClassesOfSchoolQuerySpecification extends BaseGeneratedQuerySpecification<ClassesOfSchoolMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static ClassesOfSchoolQuerySpecification instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected ClassesOfSchoolMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return ClassesOfSchoolMatcher.on(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "school.incquery";
    
  }
  
  @Override
  protected String patternName() {
    return "school.classesOfSchool";
    
  }
  
  private ClassesOfSchoolQuerySpecification() throws IncQueryException {
    super();
  }
  
  @SuppressWarnings("all")
  public static class Provider implements IQuerySpecificationProvider<ClassesOfSchoolQuerySpecification> {
    @Override
    public ClassesOfSchoolQuerySpecification get() throws IncQueryException {
      return instance();
    }
  }
  
  
  @SuppressWarnings("all")
  private static class LazyHolder {
    private final static ClassesOfSchoolQuerySpecification INSTANCE = make();
    
    public static ClassesOfSchoolQuerySpecification make() {
      try {
      	return new ClassesOfSchoolQuerySpecification();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
