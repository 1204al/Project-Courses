package tag;


import properties.Message;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class ErrorTag extends TagSupport {
    private String errorType;
    private String locale;

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    @Override
    public int doStartTag() throws JspException {
        if (errorType != null && !errorType.equals("")) {
            errorType= Message.RANDOM_ERROR;
        }
        if (locale != null && !locale.equals("")) {
            locale="en";

        }
        try {
            String language = locale;
            System.out.println("language = " + language);
            String error = errorType;

            ResourceBundle rb = ResourceBundle.getBundle("properties.messages_" + language);
            String errorMessage = (String) rb.getObject(error);

            pageContext.getOut().write("<span class='alert alert-dismissible alert-danger'>" + errorMessage + "</span>");
        } catch (IOException ex) {
            throw new JspException(ex.getMessage());
        }
        return SKIP_BODY;
    }
}

