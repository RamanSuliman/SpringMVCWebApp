package restful;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration   
/*
 * - It detects the extistence of Jackson on the classpath and automatically creates and registers default JSON and XML converters.
 * - The functionality of the annotation is equivalent to the XML version:  <mvc:annotation-driven/>
 * - With more complexity, extending the WebMvcConfigurationSupport directly.
 */
@EnableWebMvc  
public class WebConfig 
{
	
}
