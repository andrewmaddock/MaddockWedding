package uk.co.andrewmaddock.wedding.context.gae;

import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.web.context.support.XmlWebApplicationContext;

import com.google.appengine.api.utils.SystemProperty;

/**
 * Custom context class to further reduce the loading time of an application by disabling XML validation in production.
 *
 * @author Andrew Maddock
 *         Date: 26/07/13 14:32
 */
public class UnvalidatedXmlWebApplicationContext extends XmlWebApplicationContext {

    @Override
    protected void initBeanDefinitionReader(XmlBeanDefinitionReader beanDefinitionReader) {
        super.initBeanDefinitionReader(beanDefinitionReader);
        if (SystemProperty.environment.value() == SystemProperty.Environment.Value.Production) {
            beanDefinitionReader.setValidationMode(XmlBeanDefinitionReader.VALIDATION_NONE);
        }
    }
    
}
