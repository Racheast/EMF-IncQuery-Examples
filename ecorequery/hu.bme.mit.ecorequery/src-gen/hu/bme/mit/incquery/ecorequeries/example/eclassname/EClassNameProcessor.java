package hu.bme.mit.incquery.ecorequeries.example.eclassname;

import hu.bme.mit.incquery.ecorequeries.example.eclassname.EClassNameMatch;
import org.eclipse.viatra2.emf.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the EClassName pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
public abstract class EClassNameProcessor implements IMatchProcessor<EClassNameMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pEName the value of pattern parameter EName in the currently processed match 
   * 
   */
  public abstract void process(final Object EName);
  
  @Override
  public void process(final EClassNameMatch match) {
    process(match.getEName());  				
    
  }
}
