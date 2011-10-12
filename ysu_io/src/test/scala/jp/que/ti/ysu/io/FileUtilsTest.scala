package jp.que.ti.ysu.io
import org.scalatest.junit.ShouldMatchersForJUnit
import org.scalatest.junit.JUnitSuite
import org.junit.Before
import org.junit.Test
import java.io.File

class FileUtilsTest extends JUnitSuite with ShouldMatchersForJUnit {

	@Before def init() {}

	private val assumeThat = org.junit.Assume.assumeThat _

	@Test def test_defaultField {
		val fl = new File("testdata");
		val result = FileUtils.listFilesAll(fl)
		assert(result.size === 5) // ***test***

		val sorted = result.sort(_.getAbsolutePath() < _.getAbsolutePath())
		//		println(sorted);
		val crStr = replace2Slash(new File("").getAbsolutePath())
		//		println(crStr);
		val itr = sorted.iterator

		assert(replace2Slash(itr.next().getAbsolutePath()) ===
			(crStr + """/testdata/aa/aa1.txt""")) // ***test***
		assert(replace2Slash(itr.next().getAbsolutePath()) ===
			(crStr + """/testdata/aa/aa2.txt""")) // ***test***
		assert(replace2Slash(itr.next().getAbsolutePath()) ===
			(crStr + """/testdata/aa/aa_aa/test_aa_aa1.txt""")) // ***test***
		assert(replace2Slash(itr.next().getAbsolutePath()) ===
			(crStr + """/testdata/aa/aa_aa/test_aa_aa2.txt""")) // ***test***
		assert(replace2Slash(itr.next().getAbsolutePath()) ===
			(crStr + """/testdata/bb/testbb1.txt""")) // ***test***
	}

	@Test def test_listFilesAndDirectorys {
		val fl = new File("testdata");
		val result = FileUtils.listFilesAndDirectorys(fl)
		assert(result.size === 9) // ***test***

		val sorted = result.sort(_.getAbsolutePath() < _.getAbsolutePath())
		//		println(sorted);
		val crStr = replace2Slash(new File("").getAbsolutePath())
		//		println(crStr);
		val itr = sorted.iterator

		assert(replace2Slash(itr.next().getAbsolutePath()) ===
			(crStr + """/testdata/aa""")) // ***test***
		assert(replace2Slash(itr.next().getAbsolutePath()) ===
			(crStr + """/testdata/aa/aa1.txt""")) // ***test***
		assert(replace2Slash(itr.next().getAbsolutePath()) ===
			(crStr + """/testdata/aa/aa2.txt""")) // ***test***
		assert(replace2Slash(itr.next().getAbsolutePath()) ===
			(crStr + """/testdata/aa/aa_aa""")) // ***test***
		assert(replace2Slash(itr.next().getAbsolutePath()) ===
			(crStr + """/testdata/aa/aa_aa/test_aa_aa1.txt""")) // ***test***
		assert(replace2Slash(itr.next().getAbsolutePath()) ===
			(crStr + """/testdata/aa/aa_aa/test_aa_aa2.txt""")) // ***test***
		assert(replace2Slash(itr.next().getAbsolutePath()) ===
			(crStr + """/testdata/bb""")) // ***test***
		assert(replace2Slash(itr.next().getAbsolutePath()) ===
			(crStr + """/testdata/bb/testbb1.txt""")) // ***test***
		assert(replace2Slash(itr.next().getAbsolutePath()) ===
			(crStr + """/testdata/cc""")) // ***test***
	}

	private def replace2Slash(s: String): String = {
		val backSlashRegex = """\\""".r
		backSlashRegex.replaceAllIn(s, "/")
	}

}