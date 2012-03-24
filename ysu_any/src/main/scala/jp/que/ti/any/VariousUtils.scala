package jp.que.ti.any
import java.io.InputStream
import java.lang.ClassLoader
import java.lang.System
import java.util.logging.LogManager
import java.util.logging.Logger

import scala.collection.immutable.StringLike._
import scala.io.BufferedSource
import scala.math.ScalaNumber

import jp.que.ti.any.log.JLog

object VariousUtils {
  private val log: JLog = new JLog(Logger.getLogger(getClass().getName()));

  /**
   * java.util.logging の ログ設定を初期化します。
   * 引数で指定したプロパティーファイルをクラスパスから検索して初期化します
   * @param propFileName プロパティーファイル名。システムクラスローダから検索します。
   */
  def initLoggerConfig(propFileName: String): Unit = {
    val prpIs = ClassLoader.getSystemClassLoader().getResourceAsStream(propFileName)
    if (prpIs == null) return
    try {
      initLoggerConfig(prpIs);
    } catch {
      case e: Throwable =>
        println("Logger設定ファイル " + propFileName + " が読み込めませんでした")
        e.printStackTrace()
    }
  }

  /**
   *  ログ設定を初期化します。
   *  java.util.logging の ログを初期化します。
   */
  def initLoggerConfig(propInputStream: InputStream): Unit = {
    LogManager.getLogManager().readConfiguration(propInputStream);
  }

  private val _lineSeparator: String = try {
    val n = System.getProperty("line.separator")
    if (n == null) { "\n" } else { n }
  } catch { case any: Throwable => "\n" }

  /** 改行文字を返却します */
  def lineSeparator: String = _lineSeparator

  private def unwrapArg(arg: Any): AnyRef = arg match {
    case x: ScalaNumber => x.underlying
    case x => x.asInstanceOf[AnyRef]
  }

  /**
   *  Uses the underlying string as a pattern (in a fashion similar to
   *  printf in C), and uses the supplied arguments to fill in the
   *  holes.
   *
   *    The interpretation of the formatting patterns is described in
   *    <a href="" target="contentFrame" class="java/util/Formatter">
   *    `java.util.Formatter`</a>, with the addition that
   *    classes deriving from `ScalaNumber` (such as `scala.BigInt` and
   *    `scala.BigDecimal`) are unwrapped to pass a type which `Formatter`
   *    understands.
   *
   *
   *  @param args the arguments used to instantiating the pattern.
   *  @throws java.lang.IllegalArgumentException
   */
  //  def format(args: Any*): String =
  //    java.lang.String.format(toString, args map unwrapArg: _*)

  //  def format(str: String, args: Any*): String = {
  def format(str: String, args: Any*): String = {
    //    str.format(args)

    println(str)
    println("****** " + args)

    try {
      java.lang.String.format(str, args map unwrapArg: _*)
    } catch {
      case a: java.util.MissingFormatArgumentException => str + " , args=" + args
    }
  }

  /**
   * ブロックを抜けると自動的に、引数 resource をクローズする関数。
   * ローンパターン。
   *
   * <ol><li style="font-weight:700;">
   * 利用例<br/>
   * <pre>
   * using(Source.fromFile("foofoo.txt") ){ resource =>
   *   resource.getLines.mkString }
   * </pre>
   * </li></ol>
   *
   * @param resource 使い終わったらクローズしたいリソース
   * @param block 引数 resource を使用する処理ブロック
   */
  def using[A <: { def close() }, B](resource: A)(block: A => B): B = {
    try {
      block(resource) //処理ブロック
    } catch {
      case e: Throwable => {
        log.debug("リソース=" + resource + " を使用した処理で例外が発生しました", e)
        throw e
      }
    } finally {
      try {
        if (resource != null) resource.close()
      } catch {
        case e: Throwable => {
          log.warn("リソース=" + resource + " のclose実行時に例外が発生しました", e)
        }
      }
    }
  }
}