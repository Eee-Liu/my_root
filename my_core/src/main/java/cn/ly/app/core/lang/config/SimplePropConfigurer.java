package cn.ly.app.core.lang.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.util.Properties;

/**
 * Created on 2017/6/22.
 */
public class SimplePropConfigurer extends PropertyPlaceholderConfigurer {
	private Properties props;

	@Override
	protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props) throws BeansException {
		this.props = props;
		super.processProperties(beanFactoryToProcess, props);
	}

	public String getSpringProperties(String key) {
		return this.props != null ? this.props.getProperty(key) : "";
	}
}
