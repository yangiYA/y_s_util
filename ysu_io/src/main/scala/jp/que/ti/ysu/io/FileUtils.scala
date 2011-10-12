package jp.que.ti.ysu.io
import java.io.File
import scala.annotation.tailrec
import org.slf4j.LoggerFactory

/**
 * ファイルに関するユーティリティクラスです
 */
object FileUtils {
	private val logger = LoggerFactory.getLogger(this.getClass())

	/**
	 * 引数で渡されたディレクトリ以下のファイルの一覧を返却します
	 */
	def listFilesAll(directory: File): List[File] = directory match {
		case directory if (directory.isDirectory()) =>
			_listFiles(directory.listFiles().toList, Nil)
		case other => Nil
	}

	/**
	 * 引数で渡されたディレクトリ以下のファイルとディレクトリの一覧を返却します
	 */
	def listFilesAndDirectorys(directory: File): List[File] = directory match {
		case directory if (directory.isDirectory()) =>
			_listFilesAndDirectorys(directory.listFiles().toList, Nil);
		case other => Nil
	}

	@tailrec
	private def _listFiles(fileOrDirs: List[File], resultList: List[File]): List[File] = {
		if (fileOrDirs.forall(_.isFile())) {
			fileOrDirs ::: resultList
		} else {
			_listFiles(fileOrDirs.filter(_.isDirectory()).flatMap(_.listFiles()),
				fileOrDirs.filter(_.isFile()) ::: resultList)
		}
	}

	@tailrec
	private def _listFilesAndDirectorys(fileOrDirs: List[File], resultList: List[File]): List[File] = {
		if (fileOrDirs.forall(_.isFile())) {
			fileOrDirs ::: resultList
		} else {
			_listFilesAndDirectorys(fileOrDirs.filter(_.isDirectory()).flatMap(_.listFiles()),
				fileOrDirs ::: resultList)
		}
	}
}