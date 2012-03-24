package jp.que.ti.ysu.xls

import java.io.File

import org.junit.Before
import org.junit.Test
import org.scalatest.junit.JUnitSuite
import org.scalatest.junit.ShouldMatchersForJUnit

class CamelAndSnakeCaseTest extends JUnitSuite with ShouldMatchersForJUnit {
  //  def CamelAndSnakeCaseTest()=super()

  @Before def init() {}

  @Test def test_defaultField {
    var result = CamelAndSnakeCase.snakeToCamelCase("""hoge_foo_bar""")
    assert(result === """hogeFooBar""")

    result = CamelAndSnakeCase.snakeToCamelCase("""AAA_ABC_DEF""")
    assert(result === """aaaAbcDef""")
    
    result = CamelAndSnakeCase.snakeToCamelCase("""T_M_MST""")
    assert(result === """tMMst""")
    
    CamelAndSnakeCase.snakeToCamelCase(new File("""CamelAndSnakeCaseTest.txt"""))
  }
}
