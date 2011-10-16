package jp.que.ti.any.log
import java.util.logging.Formatter
import java.util.logging.LogRecord
import jp.que.ti.any.VariousUtils
import java.io.PrintWriter
import java.io.StringWriter
import java.util.logging.LogManager
import java.io.InputStream

/**コンソールにプレーンな情報を出力するために作成されたシンプルなロギングフォーマッタ */
class SimpleFormatter extends Formatter {
	/**  レベル文字列に続き、メッセージを出力するシンプルなフォーマット	 */
	override def format(record: LogRecord): String = {
		val sb = new StringBuilder
		sb.append(record.getLevel().getLocalizedName())
		sb.append(":")
		sb.append(record.getMessage())
		sb.append(VariousUtils.lineSeparator)
		if (record.getThrown() != null) {
			val sw = new StringWriter()
			VariousUtils.using(new PrintWriter(sw)) { pw =>
				record.getThrown().printStackTrace(pw)
			}
			sb.append(sw.toString());
		}
		sb.toString()
	}

	/** ログ設定を初期化します。引数で指定したプロパティーファイルをクラスパスから検索して初期化します */
	def initConfig(propFileName: String): Unit = SimpleFormatter.initConfig(propFileName)

	/** ログ設定を初期化します */
	def initConfig(propInputStream: InputStream): Unit = SimpleFormatter.initConfig(propInputStream)
}

object SimpleFormatter {
	/** ログ設定を初期化します。引数で指定したプロパティーファイルをクラスパスから検索して初期化します */
	def initConfig(propFileName: String = "defaultLogging.properties"): Unit = VariousUtils.initLoggerConfig(propFileName)

	/** ログ設定を初期化します */
	def initConfig(propInputStream: InputStream): Unit = VariousUtils.initLoggerConfig(propInputStream)

	this.initConfig()
}