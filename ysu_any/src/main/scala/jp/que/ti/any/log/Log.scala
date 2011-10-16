package jp.que.ti.any
import java.util.logging.Level

trait Log[T] {
	def debug(message: => String): Unit = debug(message, null)
	def debug(message: => String, e: Throwable): Unit
	def info(message: => String): Unit = info(message, null)
	def info(message: => String, e: Throwable): Unit
	def warn(message: => String): Unit = warn(message, null)
	def warn(message: => String, e: Throwable): Unit
	def error(message: => String): Unit = error(message, null)
	def error(message: => String, e: Throwable): Unit
}

class JLog(logger: java.util.logging.Logger) extends Log[java.util.logging.Logger] {
	override def debug(message: => String, e: Throwable): Unit =
		if (logger.isLoggable(Level.FINEST)) logger.log(Level.FINEST, message, e)
	override def info(message: => String, e: Throwable): Unit =
		if (logger.isLoggable(Level.INFO)) logger.log(Level.INFO, message, e)
	override def warn(message: => String, e: Throwable): Unit =
		if (logger.isLoggable(Level.WARNING)) logger.log(Level.WARNING, message, e)
	override def error(message: => String, e: Throwable): Unit =
		if (logger.isLoggable(Level.SEVERE)) logger.log(Level.SEVERE, message, e)
}