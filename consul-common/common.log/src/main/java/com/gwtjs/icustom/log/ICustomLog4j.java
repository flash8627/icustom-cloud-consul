package com.gwtjs.icustom.log;

import java.text.MessageFormat;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * ILogger接口的Log4j实现，委托Logger进行实际的日志记录
 * 
 * @author aGuang
 * @since 2013-8-26
 */
public class ICustomLog4j implements ICustomLogger {

	/** log4j的日志实例类 */
	private Logger logger;

	/** Fully qualified name **/
	private static final String FQCN = ICustomLog4j.class.getName();

	/** The factory method of Log4jLogger **/
	public static ICustomLogger getLog(String name) {
		return new ICustomLog4j(Logger.getLogger(name));
	}

	/**
	 * @param name
	 */
	public ICustomLog4j(Logger logger) {
		this.logger = logger;
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see log.ILogger#debug(java.lang.String)
	 */
	public void debug(String message) {
		logger.log(FQCN, Level.DEBUG, message, null);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see log.ILogger#debug(java.lang.String)
	 */
	public void debug(Object message) {
		logger.log(FQCN, Level.DEBUG, message, null);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see log.ILogger#debug(java.lang.String)
	 */
	public void debug(String message,Object obj) {
		logger.log(FQCN, Level.DEBUG, message+obj.toString(), null);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see log.ILogger#debug(java.lang.String,
	 * java.lang.Object[])
	 */
	public void debug(String message, Object... params) {
		if (logger.isEnabledFor(Level.DEBUG)) {
			debug(MessageFormat.format(message, params));
		}
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see log.ILogger#debug(java.lang.Throwable)
	 */
	public void debug(Throwable t) {
		debug(null, t);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see log.ILogger#debug(java.lang.String,
	 * java.lang.Throwable)
	 */
	public void debug(String message, Throwable t) {
		logger.log(FQCN, Level.DEBUG, message, t);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see log.ILogger#debug(java.lang.String,
	 * java.lang.Object[], java.lang.Throwable)
	 */
	public void debug(String message, Object[] params, Throwable t) {
		if (logger.isEnabledFor(Level.DEBUG)) {
			debug(MessageFormat.format(message, params), t);
		}
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see log.ILogger#info(java.lang.String)
	 */
	public void info(String message) {
		logger.log(FQCN, Level.INFO, message, null);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see log.ILogger#info(java.lang.String)
	 */
	public void info(Object message) {
		logger.log(FQCN, Level.INFO, message.toString(), null);
	}

	/*
	 * （非 Javadoc）
	 * @see log.ILogger#info(java.lang.String)
	 */
	public void info(String message,Object obj) {
		logger.log(FQCN, Level.INFO, message+" "+obj, null);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see ILogger#info(java.lang.String,
	 * java.lang.Object[])
	 */
	public void info(String message, Object... params) {
		if (logger.isEnabledFor(Level.INFO)) {
			info(MessageFormat.format(message, params));
		}
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see log.ILogger#info(java.lang.Throwable)
	 */
	public void info(Throwable t) {
		info(null, t);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see log.ILogger#info(java.lang.String,
	 * java.lang.Throwable)
	 */
	public void info(String message, Throwable t) {
		logger.log(FQCN, Level.INFO, message, t);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see log.ILogger#info(java.lang.String,
	 * java.lang.Object[], java.lang.Throwable)
	 */
	public void info(String message, Object[] params, Throwable t) {
		if (logger.isEnabledFor(Level.INFO)) {
			info(MessageFormat.format(message, params), t);
		}
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see log.ILogger#warn(java.lang.String)
	 */
	public void warn(String message) {
		logger.log(FQCN, Level.WARN, message, null);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see log.ILogger#warn(java.lang.String,
	 * java.lang.Object[])
	 */
	public void warn(String message, Object... params) {
		if (logger.isEnabledFor(Level.WARN)) {
			warn(MessageFormat.format(message, params));
		}
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see log.ILogger#warn(java.lang.Throwable)
	 */
	public void warn(Throwable t) {
		warn(null, t);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see log.ILogger#warn(java.lang.String,
	 * java.lang.Throwable)
	 */
	public void warn(String message, Throwable t) {
		logger.log(FQCN, Level.WARN, message, t);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see log.ILogger#warn(java.lang.String,
	 * java.lang.Object[], java.lang.Throwable)
	 */
	public void warn(String message, Object[] params, Throwable t) {
		if (logger.isEnabledFor(Level.WARN)) {
			warn(MessageFormat.format(message, params), t);
		}
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see log.ILogger#error(java.lang.String)
	 */
	public void error(String message) {
		logger.log(FQCN, Level.ERROR, message, null);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see log.ILogger#error(java.lang.String,
	 * java.lang.Object[])
	 */
	public void error(String message, Object... params) {
		if (logger.isEnabledFor(Level.ERROR)) {
			error(MessageFormat.format(message, params));
		}
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see log.ILogger#error(java.lang.Throwable)
	 */
	public void error(Throwable t) {
		error(null, t);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see log.ILogger#error(java.lang.String,
	 * java.lang.Throwable)
	 */
	public void error(String message, Throwable t) {
		logger.log(FQCN, Level.ERROR, message, t);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see log.ILogger#error(java.lang.String,
	 * java.lang.Object[], java.lang.Throwable)
	 */
	public void error(String message, Object[] params, Throwable t) {
		if (logger.isEnabledFor(Level.ERROR)) {
			error(MessageFormat.format(message, params), t);
		}
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see log.ILogger#fatal(java.lang.String)
	 */
	public void fatal(String message) {
		logger.log(FQCN, Level.FATAL, message, null);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see log.ILogger#fatal(java.lang.String,
	 * java.lang.Object[])
	 */
	public void fatal(String message, Object... params) {
		if (logger.isEnabledFor(Level.FATAL)) {
			fatal(MessageFormat.format(message, params));
		}
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see log.ILogger#fatal(java.lang.Throwable)
	 */
	public void fatal(Throwable t) {
		fatal(null, t);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see log.ILogger#fatal(java.lang.String,
	 * java.lang.Throwable)
	 */
	public void fatal(String message, Throwable t) {
		logger.log(FQCN, Level.FATAL, message, t);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see log.ILogger#fatal(java.lang.String,
	 * java.lang.Object[], java.lang.Throwable)
	 */
	public void fatal(String message, Object[] params, Throwable t) {
		if (logger.isEnabledFor(Level.FATAL)) {
			fatal(MessageFormat.format(message, params), t);
		}
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see log.ILogger#trace(java.lang.String,
	 * java.lang.Object[])
	 */
	public void trace(String message) {
		logger.log(FQCN, Level.TRACE, message, null);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see log.ILogger#trace(java.lang.String, *
	 * java.lang.Object[])
	 */
	public void trace(String message, Object... params) {
		if (logger.isEnabledFor(Level.TRACE)) {
			trace(MessageFormat.format(message, params));
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see log.ILogger#isDebugEnabled()
	 */
	public boolean isDebugEnabled() {
		return logger.isDebugEnabled();
	}

}
