package cd.aaa.number.resolver;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import cd.aaa.number.resolver.CroreResolver;
import cd.aaa.number.resolver.HundredsResolver;
import cd.aaa.number.resolver.LacResolver;
import cd.aaa.number.resolver.Resolver;
import cd.aaa.number.resolver.TensAndUnitsResolver;
import cd.aaa.number.resolver.ThousandResolver;

public class HundredsResolverTest {
  
  Resolver r = new HundredsResolver();
  
  @Test
  public void testNumberAtHunderdsPlace() {
    assertEquals(0,  r.getUnits(11));
    assertEquals(0,  r.getUnits(99));
    assertEquals(9,  r.getUnits(999));
    assertEquals(0,  r.getUnits(1000));
    assertEquals(4,  r.getUnits(2457));
    assertEquals(2,  r.getUnits(12133243));
  }
  
  @Test
  public void shouldReturnHundredAsDenominationString() {
    assertEquals("hundred", r.getDenomination());
  }
  
  @Test
  public void shouldReturnTrueWhenSameResolversAreCompared() {
    assertEquals(new HundredsResolver(), new HundredsResolver());
    assertEquals(new ThousandResolver(), new ThousandResolver());
  }
  
  @Test(expected = ClassCastException.class)
  public void shouldThrowExceptionWhenDisSimilarResolversAreCompared() {
    assertNotEquals(new HundredsResolver(), new TensAndUnitsResolver());
  }
  
  @Test
  public void shouldReturnFalseWhenDissimilarRangeResolversAreCompared() {
    assertNotEquals(new ThousandResolver(), new HundredsResolver());
    assertNotEquals(new CroreResolver(), new LacResolver());
  }


}
