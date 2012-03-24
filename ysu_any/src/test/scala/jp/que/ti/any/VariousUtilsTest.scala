package jp.que.ti.any
import org.scalatest.junit.ShouldMatchersForJUnit
import org.scalatest.junit.JUnitSuite
import org.junit.Before
import org.junit.Test
import VariousUtils._

class VariousUtilsTest extends JUnitSuite with ShouldMatchersForJUnit {
  @Before def init() {}

  private val assumeThat = org.junit.Assume.assumeThat _

  @Test def test_format {
    //    format("A%sB%sC%s", "no1", "no2", "no3")
    assert("A%s".format("no1") === ("""Ano1"""))

    assert(format("A%sB%sC%s", "no1", "no2", "no3") ===
      ("""Ano1Bno2Cno3""")) // ***test***

    assert(format("A%sB%sC%s", "no1", "no2", "no3", "no4") ===
      ("""Ano1Bno2Cno3"""))

    assert(format("A%sB%sC%s", "no1", "no2") ===
      ("""A%sB%sC%s , args=WrappedArray(no1, no2)"""))

    assert(format("A%sB%sC%s", null) ===
      ("""A%sB%sC%s , args=WrappedArray(null)"""))

    assert(format("A%sB%sC%s", None) ===
      ("""A%sB%sC%s , args=WrappedArray(None)"""))

  }
}