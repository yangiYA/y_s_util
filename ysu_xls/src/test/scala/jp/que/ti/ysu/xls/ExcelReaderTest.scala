package jp.que.ti.ysu.xls
import java.io.File

import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.scalatest.junit.JUnitSuite
import org.scalatest.junit.ShouldMatchersForJUnit
class ExcelReaderTest extends JUnitSuite with ShouldMatchersForJUnit {
  @Before def init() {}

  @Test def test_sheets {
    val sh = ExcelReader.sheets(ExcelReader.readExcel(new File("test.xls")))
    assertNotNull(sh)
    assert(sh.size === 3)
  }
}