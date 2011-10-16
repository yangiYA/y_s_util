package jp.que.ti.any
import java.io.InputStream
import java.lang.ClassLoader
import java.lang.System
import java.util.logging.LogManager
import java.util.logging.Logger

object VariousUtils {
	private val log: JLog = new JLog(Logger.getLogger(getClass().getName()));

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
	def using[A <: { def close() }, B](resource: A)(block: A => B): Unit = {
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

	/** ログ設定を初期化します。引数で指定したプロパティーファイルをクラスパスから検索して初期化します */
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

	/** ログ設定を初期化します */
	def initLoggerConfig(propInputStream: InputStream): Unit = {
		LogManager.getLogManager().readConfiguration(propInputStream);
	}

	/** 改行文字を返却します */
	def lineSeparator: String = _lineSeparator
	private var _lineSeparator: String = "\n"
	try {
		val n = System.getProperty("line.separator")
		_lineSeparator = if (n == null) { "\n" } else { n }
	}
}