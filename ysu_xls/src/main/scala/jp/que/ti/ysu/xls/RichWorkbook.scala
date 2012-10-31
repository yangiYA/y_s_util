package jp.que.ti.ysu.xls
import java.io.File
import java.io.FileInputStream

import org.apache.poi.hssf.usermodel.HSSFWorkbook
import org.apache.poi.ss.usermodel.Workbook
import org.apache.poi.ss.usermodel.WorkbookFactory

import jp.que.ti.any.VariousUtils.using

class RichWorkbook[A <: Workbook](val workbook: A) extends jp.que.ti.ysu.xls.WrappedWorkbook[A](workbook) {

}