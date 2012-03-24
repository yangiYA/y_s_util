package jp.que.ti.ysu.xls
import java.io.File

import scala.io.Source

import jp.que.ti.any.VariousUtils.using

object CamelAndSnakeCase {

  /** "data.txt"の各行を、スネークケースをキャメルケースにする */
  def main(args: Array[String]): Unit = {
    CamelAndSnakeCase.snakeToCamelCase("data.txt")
  }

  /** スネークケースをキャメルケースにする */
  def snakeToCamelCase(str: String): String = {
    val chs = str.toList.reverse

    val tmpList = snakeToCamelCaseWk(str)
    tmpList.foldLeft("")((x, y) => x + y)
  }

  /**
   *  スネークケースをキャメルケースにするワークメソッド
   *  @return List[Char] スネークケースをキャメルケースにした、文字のリスト
   */
  private def snakeToCamelCaseWk(str: String): List[Char] = {
    val chs = str.toList.reverse

    chs.foldLeft(List[Char]())((x, y) => {
      y match {
        case '_' => if (x.headOption == None) {
          x
        } else {
          x.head.toUpper :: x.tail
        }
        case other => y.toLowerCase :: x
      }
    })
  }

  /** スネークケースを先頭が大文字のキャメルケースにする */
  def snakeToCamelCaseHeadUppercase(str: String): String = {
    val chs = str.toList.reverse

    var tmpList = snakeToCamelCaseWk(str)
    tmpList = tmpList.head.toUpper :: tmpList.tail
    tmpList.foldLeft("")((x, y) => x + y)
  }

  /**
   * ファイルの各行のスネークケースの文字列をキャメルケースにして標準出力する
   */
  def snakeToCamelCase(fl: File): Unit = {
    using(Source.fromFile(fl)) { source =>
      val lines = source.getLines
      val rslt = lines.foldLeft(List[String]()) { (x, y) =>
        snakeToCamelCase(y) :: x
      }

      rslt.foreach(println)
    }
  }

}