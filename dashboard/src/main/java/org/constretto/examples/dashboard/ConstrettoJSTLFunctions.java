package org.constretto.examples.dashboard;

import org.constretto.ConstrettoConfiguration;
import org.constretto.Property;
import org.constretto.exception.ConstrettoConversionException;
import org.constretto.exception.ConstrettoException;
import org.constretto.exception.ConstrettoExpressionException;

import java.util.Iterator;

/**
 * @author <a href="mailto:kaare.nilsen@arktekk.no">Kaare Nilsen</a>
 */
public class ConstrettoJSTLFunctions {
    private static ConstrettoConfiguration configuration;

    public static <K> K evaluateTo(String expression, K defaultValue) throws ConstrettoExpressionException {
        return configuration().evaluateTo(expression, defaultValue);
    }

    public static <K> K evaluateTo(Class<K> targetClass, String expression) throws ConstrettoExpressionException, ConstrettoConversionException {
        return configuration().evaluateTo(targetClass, expression);
    }

    public static String evaluateToString(String expression) throws ConstrettoException {
        return configuration().evaluateToString(expression);
    }

    public static Boolean evaluateToBoolean(String expression) throws ConstrettoException {
        return configuration().evaluateToBoolean(expression);
    }

    public static Double evaluateToDouble(String expression) throws ConstrettoException {
        return configuration().evaluateToDouble(expression);
    }

    public static Long evaluateToLong(String expression) throws ConstrettoException {
        return configuration().evaluateToLong(expression);
    }

    public static Float evaluateToFloat(String expression) throws ConstrettoException {
        return configuration().evaluateToFloat(expression);
    }

    public static Integer evaluateToInt(String expression) throws ConstrettoException {
        return configuration().evaluateToInt(expression);
    }

    public static Short evaluateToShort(String expression) throws ConstrettoException {
        return configuration().evaluateToShort(expression);
    }

    public static Byte evaluateToByte(String expression) throws ConstrettoException {
        return configuration().evaluateToByte(expression);
    }
                      
    public static Boolean hasValue(String expression) {
        return configuration().hasValue(expression);
    }

    public static Iterator<Property> iterator() {
        return configuration().iterator();
    }

    private static ConstrettoConfiguration configuration() {
        if (configuration == null) {
            throw new ConstrettoException("Missing consretto config, did you remember to register the ConstrettoTaglibListener?");
        }
        return configuration;
    }

    public static void configuration(ConstrettoConfiguration configuration) {
        ConstrettoJSTLFunctions.configuration = configuration;

    }
}
