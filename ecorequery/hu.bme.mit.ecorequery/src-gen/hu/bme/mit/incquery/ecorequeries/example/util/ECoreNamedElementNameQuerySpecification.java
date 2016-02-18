package hu.bme.mit.incquery.ecorequeries.example.util;

import com.google.common.collect.Sets;
import hu.bme.mit.incquery.ecorequeries.example.ECoreNamedElementNameMatch;
import hu.bme.mit.incquery.ecorequeries.example.ECoreNamedElementNameMatcher;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFPQuery;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFQuerySpecification;
import org.eclipse.viatra.query.runtime.emf.types.EClassTransitiveInstancesKey;
import org.eclipse.viatra.query.runtime.emf.types.EStructuralFeatureInstancesKey;
import org.eclipse.viatra.query.runtime.exception.IncQueryException;
import org.eclipse.viatra.query.runtime.matchers.psystem.PBody;
import org.eclipse.viatra.query.runtime.matchers.psystem.PVariable;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.Equality;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.viatra.query.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate ECoreNamedElementNameMatcher in a type-safe way.
 * 
 * @see ECoreNamedElementNameMatcher
 * @see ECoreNamedElementNameMatch
 * 
 */
@SuppressWarnings("all")
public final class ECoreNamedElementNameQuerySpecification extends BaseGeneratedEMFQuerySpecification<ECoreNamedElementNameMatcher> {
  private ECoreNamedElementNameQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static ECoreNamedElementNameQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected ECoreNamedElementNameMatcher instantiate(final ViatraQueryEngine engine) throws IncQueryException {
    return ECoreNamedElementNameMatcher.on(engine);
  }
  
  @Override
  public ECoreNamedElementNameMatch newEmptyMatch() {
    return ECoreNamedElementNameMatch.newEmptyMatch();
  }
  
  @Override
  public ECoreNamedElementNameMatch newMatch(final Object... parameters) {
    return ECoreNamedElementNameMatch.newMatch((java.lang.String) parameters[0]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link ECoreNamedElementNameQuerySpecification} to be created 
   * 	<b>not</b> at the class load time of the outer class, 
   * 	but rather at the first call to {@link ECoreNamedElementNameQuerySpecification#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private final static ECoreNamedElementNameQuerySpecification INSTANCE = new ECoreNamedElementNameQuerySpecification();
    
    /**
     * Statically initializes the query specification <b>after</b> the field {@link #INSTANCE} is assigned.
     * This initialization order is required to support indirect recursion.
     * 
     * <p> The static initializer is defined using a helper field to work around limitations of the code generator.
     * 
     */
    private final static Object STATIC_INITIALIZER = ensureInitialized();
    
    public static Object ensureInitialized() {
      INSTANCE.ensureInitializedInternalSneaky();
      return null;					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static ECoreNamedElementNameQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.incquery.ecorequeries.example.ECoreNamedElementName";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("Name");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("Name", "java.lang.String"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      	{
      		PBody body = new PBody(this);
      		PVariable var_Name = body.getOrCreateVariableByName("Name");
      		PVariable var_Element = body.getOrCreateVariableByName("Element");
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_Name, "Name")
      		));
      		//        ENamedElement(Element)
      		new TypeConstraint(body, new FlatTuple(var_Element), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/emf/2002/Ecore", "ENamedElement")));
      		//        ENamedElement.name(Element,Name)
      		new TypeConstraint(body, new FlatTuple(var_Element), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/emf/2002/Ecore", "ENamedElement")));
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new TypeConstraint(body, new FlatTuple(var_Element, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/emf/2002/Ecore", "ENamedElement", "name")));
      		new Equality(body, var__virtual_0_, var_Name);
      		bodies.add(body);
      	}
      	// to silence compiler error
      	if (false) throw new IncQueryException("Never", "happens");
      } catch (IncQueryException ex) {
      	throw processDependencyException(ex);
      }
      return bodies;
    }
  }
}
