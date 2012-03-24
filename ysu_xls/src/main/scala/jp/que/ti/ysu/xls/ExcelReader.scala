package jp.que.ti.ysu.xls
import java.io.File
import java.io.FileInputStream

import org.apache.poi.hssf.usermodel.HSSFCell
import org.apache.poi.hssf.usermodel.HSSFRow
import org.apache.poi.hssf.usermodel.HSSFSheet
import org.apache.poi.hssf.usermodel.HSSFWorkbook

import jp.que.ti.any.VariousUtils.using

object ExcelReader {
  def readExcel(file: File): HSSFWorkbook = {
    var book: HSSFWorkbook = null
    using(new FileInputStream(file)) { fis =>
      book = new HSSFWorkbook(fis)
    }
    book
  }

  implicit def hSSFWorkbookToRichHSSFSheet_ExcelReader(hSSFSheet: HSSFSheet) = new RichHSSFSheet(hSSFSheet)

  def sheets(book: HSSFWorkbook): List[HSSFSheet] = {
    val idx = 0 to (book.getNumberOfSheets - 1)
    val shts: List[HSSFSheet] = idx.foldLeft(List[HSSFSheet]()) { (x, y) =>
      sheetAt(book, y) match {
        case Some(value) => value :: x
        case None => x
      }
    }
    shts.reverse
  }

  def sheet(book: HSSFWorkbook, sheetName: String): Option[HSSFSheet] =
    someOrNome(book.getSheet(sheetName))

  /**
   * @param sheetIndex 0から始まるインデックス
   */
  def sheetAt(book: HSSFWorkbook, sheetIndex: Int): Option[HSSFSheet] =
    someOrNome(book.getSheetAt(sheetIndex))

  def row(sheet: Option[HSSFSheet], rowNum: Int): Option[HSSFRow] = sheet match {
    case Some(sho) => row(sheet, rowNum)
    case None => None
  }
  def row(sheet: HSSFSheet, rowNum: Int): Option[HSSFRow] = Option(sheet.getRow(rowNum))

  def cell(row: HSSFRow, cellNum: Int): Option[HSSFCell] = Option(row.getCell(cellNum))
  def cell(row: Option[HSSFRow], cellNum: Int): Option[HSSFCell] = row match {
    case Some(r) => Some(r.getCell(cellNum))
    case None => None
  }

  def cell(sheet: HSSFSheet, rowNum: Int, cellNum: Int): Option[HSSFCell] =
    cell(row(sheet, rowNum), cellNum)

  private def someOrNome[A](obj: A): Option[A] =
    try {
      Some(obj)
    } catch {
      case nse: NoSuchElementException => None
      case re: RuntimeException => None
      case ne: NullPointerException => None
    }
}

class RichHSSFSheet(val sheet: HSSFSheet) {
  def row(rowNum: Int): Option[HSSFRow] = ExcelReader.row(sheet, rowNum)
  def cell(rowNum: Int, cellNum: Int): Option[HSSFCell] =
    ExcelReader.cell(sheet, rowNum, cellNum)
}