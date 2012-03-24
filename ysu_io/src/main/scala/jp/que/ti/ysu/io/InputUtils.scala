package jp.que.ti.ysu.io
import java.io.File
import java.io.IOException
import java.io.InputStream

import scala.io.BufferedSource
import scala.io.Source

import jp.que.ti.any.VariousUtils.using

object InputUtils {
  /**
   * ファイルを文字列のlistに変換する
   * @param enc エンコーディング。デフォルトは UTF-8
   * @throws
   */
  def recordsListFromFile(file: File, enc: String = "UTF-8"): List[String] = {

    try {
      recordsListFromSource(Source.fromFile(file, enc))
    } catch {
      case ioe: IOException => throw new IOException("""cannot read file. file=%s """.format(
        if (file == null) { "null" } else { file.getAbsolutePath() }) //
        , ioe)
      case th: Throwable => throw new IOException(
        """cannot read file. file=%s ; enc=%s""".format(
          if (file == null) { "null" } else { file.getAbsolutePath() } //
          , enc) //
          , th)
    }
  }

  /**
   * InputStream を文字列のlistに変換する
   * @param enc エンコーディング。デフォルトは UTF-8
   * @throws
   */
  def recordsListFromInputStream(inputStream: InputStream, enc: String = "UTF-8"): List[String] = {
    try {
      recordsListFromSource(Source.fromInputStream(inputStream, enc))
    } catch {
      case ioe: IOException => throw ioe
      case th: Throwable => throw new IOException(
        """cannot read inputStream. inputStream=%s ; enc=%s""".format(
          if (inputStream == null) { "null" } else { inputStream } //
          , enc) //
          , th)
    }
  }

  /**
   * scala.io.BufferedSource を文字列のlistに変換する
   * @param enc エンコーディング。デフォルトは UTF-8
   * @throws
   */
  def recordsListFromSource(bufferedSource: BufferedSource): List[String] = {
    using(bufferedSource) { source =>
      val it = source.getLines()
      var rtn: List[String] = Nil
      try {
        it.foreach(x => rtn = x :: rtn)
      } catch {
        case ioe: IOException => throw ioe
        case th: Throwable => throw new IOException(
          """cannot read bufferedSource. bufferedSource=%s""".format(
            if (bufferedSource == null) { "null" } else { bufferedSource }) //
            , th)
      }
      rtn.reverse
    }
  }

}