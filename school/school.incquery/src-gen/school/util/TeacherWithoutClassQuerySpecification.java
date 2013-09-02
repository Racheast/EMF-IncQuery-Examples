package school.util;

import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IQuerySpecificationProvider;
import school.TeacherWithoutClassMatcher;

/**
 * A pattern-specific query specification that can instantiate TeacherWithoutClassMatcher in a type-safe way.
 * 
 * @see TeacherWithoutClassMatcher
 * @see TeacherWithoutClassMatch
 * 
 */
@SuppressWarnings("all")
public final class TeacherWithoutClassQuerySpecification extends BaseGeneratedQuerySpecification<TeacherWithoutClassMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static TeacherWithoutClassQuerySpecification instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected TeacherWithoutClassMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return TeacherWithoutClassMatcher.on(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "school.incquery";
    
  }
  
  @Override
  protected String patternName() {
    return "school.teacherWithoutClass";
    
  }
  
  private TeacherWithoutClassQuerySpecification() throws IncQueryException {
    super();
  }
  
  @SuppressWarnings("all")
  public static class Provider implements IQuerySpecificationProvider<TeacherWithoutClassQuerySpecification> {
    @Override
    public TeacherWithoutClassQuerySpecification get() throws IncQueryException {
      return instance();
    }
  }
  
  
  @SuppressWarnings("all")
  private static class LazyHolder {
    private final static TeacherWithoutClassQuerySpecification INSTANCE = make();
    
    public static TeacherWithoutClassQuerySpecification make() {
      try {
      	return new TeacherWithoutClassQuerySpecification();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
