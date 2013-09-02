package school.util;

import java.util.Map;
import org.eclipse.incquery.runtime.extensibility.IMatchChecker;
import org.eclipse.incquery.runtime.rete.tuple.Tuple;

/**
 * A xbase xexpression evaluator tailored for the school.courseWithPrimeWeight pattern.
 */
@SuppressWarnings("all")
public class CourseWithPrimeWeightEvaluator1_1 implements IMatchChecker {
  /**
   * The raw java code generated from the xbase xexpression by xtext.
   */
  private Boolean evaluateXExpressionGenerated(final Integer W) {
    boolean _xifexpression = false;
    int _modulo = ((W).intValue() % 2);
    boolean _equals = (_modulo == 0);
    if (_equals) {
      _xifexpression = false;
    } else {
      boolean _xblockexpression = false;
      {
        double _sqrt = Math.sqrt((W).intValue());
        Float _float = new Float(_sqrt);
        Integer maxValue = Integer.valueOf(Math.round((_float).floatValue()));
        Integer divisor = Integer.valueOf(3);
        boolean _lessEqualsThan = (divisor.compareTo(maxValue) <= 0);
        boolean _while = _lessEqualsThan;
        while (_while) {
          int _modulo_1 = ((W).intValue() % (divisor).intValue());
          boolean _equals_1 = (_modulo_1 == 0);
          if (_equals_1) {
            return Boolean.valueOf(false);
          } else {
            int _plus = ((divisor).intValue() + 2);
            divisor = Integer.valueOf(_plus);
          }
          boolean _lessEqualsThan_1 = (divisor.compareTo(maxValue) <= 0);
          _while = _lessEqualsThan_1;
        }
        _xblockexpression = (true);
      }
      _xifexpression = _xblockexpression;
    }
    return Boolean.valueOf(_xifexpression);
  }
  
  /**
   * A wrapper method for calling the generated java method with the correct attributes.
   */
  @Override
  public Boolean evaluateXExpression(final Tuple tuple, final Map<String,Integer> tupleNameMap) {
    int WPosition = tupleNameMap.get("W");
    java.lang.Integer W = (java.lang.Integer) tuple.get(WPosition);
    return evaluateXExpressionGenerated(W);
  }
}
