package configclass;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 主配置
 */

@Configuration
@ComponentScan(basePackages={"configclass","controller","service","dao","domain"})
@Import(ConfigClass.class)
public class MainConfig {
}
