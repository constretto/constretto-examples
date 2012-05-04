package org.constretto.web.tag;

import org.constretto.ConstrettoConfiguration;
import org.constretto.Property;
import org.constretto.exception.ConstrettoException;

import javax.servlet.jsp.JspTagException;
import java.util.Iterator;

public class ConstrettoForEachTag extends javax.servlet.jsp.jstl.core.LoopTagSupport {
    private static ConstrettoConfiguration configuration;
    private Iterator<String> iterator = null;
    private String expression;

    public void setExpression(String expression) {
        this.expression = expression;
    }

    @Override
    protected Object next() throws JspTagException {
        return iterator.next();
    }

    @Override
    protected boolean hasNext() throws JspTagException {
        return iterator.hasNext();
    }

    @Override
    protected void prepare() throws JspTagException {
        iterator = configuration.evaluateToList(String.class,expression).iterator();
    }

    private static ConstrettoConfiguration configuration() {
        if (configuration == null) {
            throw new ConstrettoException("Missing consretto config, did you remember to register the ConstrettoTaglibListener?");
        }
        return configuration;
    }

    public static void configuration(ConstrettoConfiguration configuration) {
        ConstrettoForEachTag.configuration = configuration;
    }
}
