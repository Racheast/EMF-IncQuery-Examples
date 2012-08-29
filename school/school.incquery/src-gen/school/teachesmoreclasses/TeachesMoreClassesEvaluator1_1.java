package school.teachesmoreclasses;

import java.util.Map;
import org.eclipse.viatra2.emf.incquery.runtime.api.IMatchChecker;
import org.eclipse.viatra2.gtasm.patternmatcher.incremental.rete.tuple.Tuple;

/**
 * A xbase xexpression evaluator tailored for the teachesMoreClasses pattern.
 */
public class TeachesMoreClassesEvaluator1_1 implements IMatchChecker {
  /**
   * The raw java code generated from the xbase xexpression by xtext.
   */
  private Boolean evaluateXExpressionGenerated(final Object N, final Object M) {
    Object _N = N;
    Object _M = M;
    boolean _greaterThan = (((Integer) _N).compareTo(((Integer) _M)) > 0);
    return Boolean.valueOf(_greaterThan);
  }
  
  /**
   * A wrapper method for calling the generated java method with the correct attributes.
   */
  public Boolean evaluateXExpression(final Tuple tuple, final Map<String,Integer> tupleNameMap) {
    int NPosition = tupleNameMap.get("N");
    java.lang.Object N = (java.lang.Object) tuple.get(NPosition);
    int MPosition = tupleNameMap.get("M");
    java.lang.Object M = (java.lang.Object) tuple.get(MPosition);
    return evaluateXExpressionGenerated(N, M);
  }
}