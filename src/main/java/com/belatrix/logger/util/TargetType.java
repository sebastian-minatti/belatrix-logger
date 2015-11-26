package com.belatrix.logger.util;

/**
 * Specify the different target to log.
 * <p>
 * If you need to create a new target update this class and also
 * {@link com.belatrix.logger.LoggerFactory}
 *
 */
public enum TargetType {
	CONSOLE, DATABASE, FILE
}
