package zhttp.logging.macros

import zhttp.logging.macros.LoggerMacroImpl._
import zhttp.logging.{LogLevel, Logger}

/**
 * Core Logger class.
 */
trait LoggerMacroExtensions{ self: Logger =>
  import scala.language.experimental.macros

  def isEnabled(logLevel: LogLevel): Boolean

  inline def trace(inline msg: String): Unit = $ { logTraceImpl('self, 'msg) }
  inline def debug(inline msg: String): Unit = $ { logDebugImpl('self, 'msg) }
  inline def info(inline msg: String): Unit = $ { logInfoImpl('self, 'msg) }
  inline def warn(inline msg: String): Unit = $ { logWarnImpl('self, 'msg) }
  inline def error(inline msg: String): Unit = $ { logErrorImpl('self, 'msg) }
  inline def error(inline msg: String, throwable: Throwable): Unit = ${logErrorWithCauseImpl('self, 'throwable, 'msg)}
}
