package zhttp.logging.macros

import zhttp.logging.macros.LoggerMacroImpl._

trait LoggerMacroExtensions { self =>
  import scala.language.experimental.macros
  def isEnabled: Boolean

  final def trace(msg: String, tags: List[String]): Unit = macro logTraceImpl
  final def debug(msg: String, tags: List[String]): Unit = macro logDebugImpl
  final def info(msg: String, tags: List[String]): Unit = macro logInfoImpl
  final def warn(msg: String, tags: List[String]): Unit = macro logWarnImpl
  final def error(msg: String, tags: List[String]): Unit = macro logErrorImpl
  final def error(msg: String, throwable: Throwable, tags: List[String]): Unit =
    macro logErrorWithCauseImpl
}