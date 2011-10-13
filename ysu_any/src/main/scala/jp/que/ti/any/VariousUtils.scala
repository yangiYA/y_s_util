package jp.que.ti.any
import org.slf4j.Logger
import org.slf4j.LoggerFactory

object VariousUtils {
	private val logger: Logger = LoggerFactory.getLogger(getClass());

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
				if (logger.isDebugEnabled()) logger.debug(
					"リソース=" + resource + " を使用した処理で例外が発生しました", e)
				throw e
			}
		} finally {
			try {
				if (resource != null) resource.close()
			} catch {
				case e: Throwable => {
					if (logger.isInfoEnabled()) logger.info(
						"リソース=" + resource + " のclose実行時に例外が発生しました", e)
				}
			}
		}
	}
}