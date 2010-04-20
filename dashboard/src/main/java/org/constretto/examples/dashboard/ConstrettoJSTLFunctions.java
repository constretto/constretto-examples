/*
 * Copyright 2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.constretto.examples.dashboard;

import org.constretto.ConstrettoConfiguration;
import org.constretto.Property;
import org.constretto.exception.ConstrettoConversionException;
import org.constretto.exception.ConstrettoException;
import org.constretto.exception.ConstrettoExpressionException;

import java.util.Iterator;

/**
 * @author <a href="mailto:kaare.nilsen@gmail.com">Kaare Nilsen</a>
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
